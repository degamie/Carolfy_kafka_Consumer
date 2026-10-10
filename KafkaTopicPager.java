//WID(10.10.2026)(Sarthak Mittal)(DegamieSign)(KafkaTopicPager)
package com.kafka.Carofly.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaTopicPager {

    private static final Logger log = LoggerFactory.getLogger(KafkaTopicPager.class);

    private final ConsumerFactory<String, String> consumerFactory;
    void setConsumerFactory(ConsumerFactory<String,String>consumerFactory){
        this.consumerFactory=consumerFactory;
    }
    private final ConsumerFactory.Listener<String, String> consumerFactoryListener;

    public KafkaTopicPager(ConsumerFactory<String, String> consumerFactory) {
        this.consumerFactory = consumerFactory;

        // Listener hook for tracking created/removed consumer instances
        this.consumerFactoryListener = new ConsumerFactory.Listener<>() {
            @Override
            public void consumerAdded(String id, Consumer<String, String> consumer) {
                log.debug("Consumer instance initialized: ID={}, Consumer={}", id, consumer);
            }

            @Override
            public void consumerRemoved(String id, Consumer<String, String> consumer) {
                log.debug("Consumer instance closed: ID={}, Consumer={}", id, consumer);
            }
        };

        this.consumerFactory.addListener(this.consumerFactoryListener);
    }

    /**
     * Reads a paginated slice of records starting from a specific partition offset.
     *
     * @param topic Topic name to inspect
     * @param partition Partition index
     * @param startOffset Starting Kafka offset
     * @param pageSize Maximum number of records to return
     * @return Future containing the paginated list of records
     */
    @Async("consumer-player-async")
    public CompletableFuture<List<ConsumerRecord<String, String>>> getPlayerPage(
            String topic,
            int partition,
            long startOffset,
            int pageSize) {

        // Auto-close consumer after read loop
        try (Consumer<String, String> consumer = consumerFactory.createConsumer()) {
            TopicPartition topicPartition = new TopicPartition(topic, partition);
            consumer.assign(Collections.singletonList(topicPartition));
            consumer.seek(topicPartition, startOffset);

            List<ConsumerRecord<String, String>> recordsCollected = new ArrayList<>();
            int maxPollAttempts = 5;
            int attempts = 0;

            while (recordsCollected.size() < pageSize && attempts < maxPollAttempts) {
                ConsumerRecords<String, String> polledRecords = consumer.poll(Duration.ofMillis(500));

                if (polledRecords.isEmpty()) {
                    attempts++;
                    continue;
                }

                for (ConsumerRecord<String, String> record : polledRecords.records(topicPartition)) {
                    recordsCollected.add(record);
                    if (recordsCollected.size() == pageSize) {
                        break;
                    }
                }
            }

            return CompletableFuture.completedFuture(recordsCollected);

        } catch (Exception ex) {
            log.error("Failed to read page from topic {} [p={}, offset={}]: {}",
                    topic, partition, startOffset, ex.getMessage(), ex);
            return CompletableFuture.failedFuture(ex);
        }
    }
}