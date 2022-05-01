package com.fantastik4.prisonsystemapplication.rabbitmqserver.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQGuardConfig {
    @Bean
    public DirectExchange guardExchange(){
        return new DirectExchange("guard.exchange");
    }

    @Bean
    public Queue guardQueue(){
        return new Queue("guard.add");
    }
    @Bean
    public Binding guardBinding(){
        return BindingBuilder.bind(guardQueue()).to(guardExchange()).with("guard.add");
    }

    @Bean
    public Queue guardRemoveQueue(){
        return new Queue("guard.remove");
    }
    @Bean
    public Binding guardRemoveBinding(){
        return BindingBuilder.bind(guardRemoveQueue()).to(guardExchange()).with("guard.remove");
    }


    @Bean
    public Queue guardGetQueue(){
        return new Queue("guard.get");
    }
    @Bean
    public Binding guardGetBinding(){
        return BindingBuilder.bind(guardGetQueue()).to(guardExchange()).with("guard.get");
    }


}
