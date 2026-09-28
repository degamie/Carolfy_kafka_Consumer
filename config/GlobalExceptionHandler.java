//WID(4/9/2026)(Sarthak Mittal(DegamieSign)(GlobalExceptionHandler)(PlayerConsumerr
package com.kafka.Carofly.config;

import com.kafka.Carofly.service.PlayerConsumer;
import org.apache.kafka.clients.consumer.CommitFailedException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.errors.WakeupException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
@Configuration
public class GlobalExceptionHandler {
    @Autowired
    public PlayerConsumer playerConsumer;
    GlobalExceptionHandler(PlayerConsumer playerConsumer){
        this.playerConsumer=playerConsumer;
    }

    boolean isrunning=false;
    private void process(ConsumerRecord<String, String> record) {}
    public void handleException(){
        try{
            while (isrunning){
                ConsumerRecord<String,String>consumerRecord=playerConsumer.poll(Duration.ofMillis(500));
                for (ConsumerRecord<String, String> record : consumerRecord) {
                    try {
                        process(record);
                        playerConsumer.commitSync();
            }
            catch(Exception e){
                    e.printStackTrace();
            }
        }

    }
} catch (WakeupException e) {
            e.printStackTrace();
        } catch (CommitFailedException e) {
            e.printStackTrace();
        } finally {
        playerConsumer.close();
}
    }


}
