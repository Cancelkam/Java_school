package com.javaSchool.eCare.config;

import lombok.RequiredArgsConstructor;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.jms.ConnectionFactory;

@PropertySource(value = "classpath:applicationJMS.properties")
@Configuration
@RequiredArgsConstructor
public class JMSConfig {

    private final Environment environment;

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(environment.getProperty("spring.activemq.broker-url"));
        return activeMQConnectionFactory;
    }
}
