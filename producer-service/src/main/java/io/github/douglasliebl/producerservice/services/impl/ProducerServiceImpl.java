package io.github.douglasliebl.producerservice.services.impl;

import io.github.douglasliebl.producerservice.services.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send("main-topic", message).whenComplete((result, exception) -> {
            if (exception != null) log.info("Falha ao enviar a mensagem: {}", exception.getMessage());
            else log.info("Mensagem enviada com sucesso para o topico: {}", result.getRecordMetadata().topic());
        });
    }
}
