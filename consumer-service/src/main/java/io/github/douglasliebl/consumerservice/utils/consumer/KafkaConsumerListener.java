package io.github.douglasliebl.consumerservice.utils.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class KafkaConsumerListener {

    @KafkaListener(groupId = "group-1", topics = "main-topic", containerFactory = "containerFactory")
    public void listener(String message) {
        log.info(message);
    }
}
