//WID(14/9/2026)(Sarthak Mittal(DegmaieSign)(Kafka Topic)#1.1c .1
package com.kafka.Carofly.Config;

import com.kafka.Carofly.dto.PlayerProducer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.yaml.snakeyaml.internal.Logger;

@Configuration
public class kafkaTopic {
    void updateByProducerKafkaTemplate(KafkaTemplate<String,PlayerProducer>producerKafkaTemplate){
        getproducerKafkaTemplate(producerKafkaTemplate)+setProducerKafkaTemplate(producerKafkaTemplate)+1;}
    public KafkaTemplate<String, PlayerProducer>  getproducerKafkaTemplate(KafkaTemplate<String, PlayerProducer> producerKafkaTemplate) {
        return producerKafkaTemplate;
    }



    void setProducerKafkaTemplate(KafkaTemplate<String,PlayerProducer>producerKafkaTemplate){
        this.producerKafkaTemplate=producerKafkaTemplate;
    }
    KafkaTemplate<String,PlayerProducer> producerKafkaTemplate=new KafkaTemplate<>();
    String topicName;
    @Bean
    public void updateByplayerTopic(String playername){
        createPlayerTopic()+ Logger.Level(playername)+1;
    }
    @Bean
    public NewTopic createPlayerTopic(){
        return new Topic("PlayerTransactionTopid",3,(short)1);
    }

}
