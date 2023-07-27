package com.app.stock.kafkaservice.service;

import com.app.stock.stockAnalyzer.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final EmailService emailService;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void getMessageFromTopic(UserDTO user) {
        emailService.sendSimpleEmail(user.getEmail(),
                "Welcome to Stock-Analyzer",
                "You successfully registered with you data:" + "\n"+
                        " Username: " + user.getUsername() +
                        ", " + "email: " + user.getEmail());

        log.info("kafka message consumed");
    }
}
