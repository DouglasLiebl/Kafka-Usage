package io.github.douglasliebl.consumerservice.utils.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class KafkaConsumerListener {

    @KafkaListener(groupId = "group-1", topicPartitions = {
            @TopicPartition(topic = "main-topic", partitions = {"0"})
    }, containerFactory = "containerFactory")
    public void listener(String message) {
        log.info("000: " + message);
    }

    @KafkaListener(groupId = "group-1", topics = "main-topic", containerFactory = "containerFactory")
    public void log(String message) {
        log.info("001" + message);
    }
}
