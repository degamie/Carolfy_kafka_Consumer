//WID(23/9/2026)(Sarthak Mittal(DegamieSign)(beladona(authenticatioN)#1
package com.kafka.Carofly.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class beladona {
    Properties getproperties(Properties properties){
        return properies;
    }
    void setproperties(Properties properties){
        this.properties=properties;
    }
    void main(String[] args){
    Properties properties= new Properties();
         properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");

    // Security protocol (SASL_PLAINTEXT or SASL_SSL)
        properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");

    // SASL Mechanism
        properties.put("sasl.mechanism", "PLAIN");

    // JAAS Login Configuration for SASL/PLAIN
        properties.put("sasl.jaas.config",
                "org.apache.kafka.common.security.plain.PlainLoginModule required " +
                "username=\"alice\" " +
                "password=\"alice@123\";");

    // Serializers
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
        producer.send(new ProducerRecord<>("order-topic", "key", "Hello Secure Kafka"));
        producer.flush();
        System.out.println("Message sent successfully!");
    }
}
}
