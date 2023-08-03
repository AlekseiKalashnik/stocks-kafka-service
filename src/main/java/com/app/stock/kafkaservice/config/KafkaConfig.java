//package com.app.stock.kafkaservice.config;
//
//import com.app.stock.stockAnalyzer.dto.UserDTO;
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.config.SslConfigs;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.security.jaas.KafkaJaasLoginModuleInitializer;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaConfig {
//
//    String HOST = "rc1a-bfnhhricruq3oufj.mdb.yandexcloud.net:9091";
//    String TOPIC = "topic-1";
//    String USER = "developer";
//    String PASS = "11111111";
//    String TS_FILE = "/etc/security/ssl";
//    String TS_PASS = "11111111";
//    String jaasTemplate = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";
//    String jaasCfg = String.format(jaasTemplate, USER, PASS);
//    String GROUP = "group-1";
//
//    @Bean
//    public KafkaJaasLoginModuleInitializer jaasConfig() throws IOException {
//        KafkaJaasLoginModuleInitializer jaasConfig = new KafkaJaasLoginModuleInitializer();
//        jaasConfig.setControlFlag(KafkaJaasLoginModuleInitializer.ControlFlag.valueOf("REQUIRED"));
//        Map<String, String> options = new HashMap<>();
//        options.put("bootstrap.servers", HOST);
//        options.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        options.put("group.id", GROUP);
//        options.put("security.protocol", "SASL_SSL");
//        options.put("sasl.mechanism", "SCRAM-SHA-512");
//        options.put("sasl.jaas.config", jaasCfg);
//        options.put("ssl.truststore.location", TS_FILE);
//        options.put("ssl.truststore.password", TS_PASS);
//        jaasConfig.setOptions(options);
//        return jaasConfig;
//
//    }
//
//    @Autowired
//    private ConsumerFactory<Integer, String> consumerFactory;
//
//    @Autowired
//    private CryptoService cryptoService;
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfig()));
//        return factory;
//    }
//
//    private Map<String, Object> consumerConfig() {
//        Map<String, Object> consumerConfig = new HashMap<>(consumerFactory.getConfigurationProperties());
//        decryptAndAddToConsumerConfig(consumerConfig, SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG);
//        decryptAndAddToConsumerConfig(consumerConfig, SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG);
//        decryptAndAddToConsumerConfig(consumerConfig, SslConfigs.SSL_KEY_PASSWORD_CONFIG);
//        return consumerConfig;
//    }
//
//    private void decryptAndAddToConsumerConfig(Map<String, Object> config, String property) {
//        config.compute(property, (k, v) -> cryptoService.decrypt((String) v));
//    }
//}
