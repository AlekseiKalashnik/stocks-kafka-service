package com.app.stock.kafkaservice;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.security.jaas.KafkaJaasLoginModuleInitializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    String HOST = "rc1a-bfnhhricruq3oufj.mdb.yandexcloud.net:9091";
    String USER = "developer";
    String PASS = "11111111";
    String TS_FILE = "/etc/security/ssl";
    String TS_PASS = "11111111";
    String jaasTemplate = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";
    String jaasCfg = String.format(jaasTemplate, USER, PASS);
    String GROUP = "group-1";

    @Bean
    public KafkaJaasLoginModuleInitializer jaasConfig() throws IOException {
        KafkaJaasLoginModuleInitializer jaasConfig = new KafkaJaasLoginModuleInitializer();
        jaasConfig.setControlFlag(KafkaJaasLoginModuleInitializer.ControlFlag.valueOf("REQUIRED"));
        Map<String, String> options = new HashMap<>();
        options.put("bootstrap.servers", HOST);
        options.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        options.put("group.id", GROUP);
        options.put("security.protocol", "SASL_SSL");
        options.put("sasl.mechanism", "SCRAM-SHA-512");
        options.put("sasl.jaas.config", jaasCfg);
        options.put("ssl.truststore.location", TS_FILE);
        options.put("ssl.truststore.password", TS_PASS);
        jaasConfig.setOptions(options);
        return jaasConfig;
    }
}
