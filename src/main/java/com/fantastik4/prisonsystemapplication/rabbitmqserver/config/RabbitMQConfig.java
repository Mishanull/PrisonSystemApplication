package com.fantastik4.prisonsystemapplication.rabbitmqserver.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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
