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
    @Bean
    public Queue loginConfirmationQueue(){
        return new Queue("login.confirm");
    }
    @Bean
    public Binding loginBinding(){
        return BindingBuilder.bind(loginConfirmationQueue()).to(exchange()).with("login.confirm");
    }

    @Bean
    public Queue logOutQueue(){
        return new Queue("logout.confirm");
    }
    @Bean
    public Binding logOutBinding(){
        return BindingBuilder.bind(logOutQueue()).to(exchange()).with("logout.confirm");
    }
}
