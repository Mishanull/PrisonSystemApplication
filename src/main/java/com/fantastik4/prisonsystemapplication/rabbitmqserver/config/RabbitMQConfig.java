package com.fantastik4.applicationtier.rabbitmqserver.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    public static final String QUEUE = "prison.users";
    public static final String RPC_EXCHANGE = "sep3.prison";

    @Bean
    public Queue  msgQueue(){
        return new Queue(QUEUE);
    }
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(RPC_EXCHANGE);
    }
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(msgQueue()).to(exchange()).with(QUEUE);
    }


}
