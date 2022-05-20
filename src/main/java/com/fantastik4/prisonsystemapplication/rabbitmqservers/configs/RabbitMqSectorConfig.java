package com.fantastik4.prisonsystemapplication.rabbitmqserver.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqSectorConfig {
    @Bean
    public DirectExchange sectorExchange(){
        return new DirectExchange("sector.exchange");
    }


    @Bean
    public Queue sectorsGetQueue(){
        return new Queue("sectors.get");
    }
    @Bean
    public Binding sectorsGetBinding(){
        return BindingBuilder.bind(sectorsGetQueue()).to(sectorExchange()).with("sectors.get");
    }
}
