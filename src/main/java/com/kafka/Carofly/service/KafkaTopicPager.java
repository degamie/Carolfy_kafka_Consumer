//WID(8/9/2026)(Sarthak Mittal(DegamieSign))(Binding ConsumerFactory)
package com.kafka.Carofly.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.jspecify.annotations.Nullable;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaTopicPager {
    void setConsumerFactory(ConsumerFactory<String,String>consumerFactory){
        this.consumerFactory=consumerFactory;
    }
    public KafkaTopicPager(ConsumerFactory<String, String> consumerFactory) {
        this.consumerFactory = consumerFactory;
    }

    ConsumerFactory<String,String> consumerFactory;

    @Async("consumer-player-async")
    public List<ConsumerRecord<String,String>>getplayerpage(String topic,int playertopicoffset, int page, int size,int partition) {

        try (
                Consumer<String, String> consumer = consumerFactory.createConsumer()) {
            TopicPartition tp = new TopicPartition(playertopicoffset, partition);
            consumer.assign(List.of(tp));
            consumer.seek(tp, playertopicoffset);

            List<ConsumerRecord<String, String>> page = new ArrayList<>();
            while (page.size() < size) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
                if (records.isEmpty()) break;
                records.records(tp).forEach(page::add);
            }
            return page.size() > size ? page.subList(0, size) : page;
        }
    }

}
