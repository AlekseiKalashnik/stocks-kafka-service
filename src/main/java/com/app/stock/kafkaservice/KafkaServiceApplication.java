package com.app.stock.kafkaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class KafkaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaServiceApplication.class, args);
        System.setProperty("java.security.auth.login.config","/jaas.conf");
    }

}
