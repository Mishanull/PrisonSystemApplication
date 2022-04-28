package com.fantastik4.applicationtier.rabbitmqserver.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQPrisonerConfig {

    //exchange missing ->new exchange for prisoners queues ?
    @Bean
    public DirectExchange prisonerExchange(){
        return new DirectExchange("prisoner.exchange");
    }

    //adding prisoner queues
    @Bean
    public Queue prisonerQueue(){
        return new Queue("prisoner.add");
    }
    @Bean
    public Binding prisonerBinding(){
        return BindingBuilder.bind(prisonerQueue()).to(prisonerExchange()).with("prisoner.add");
    }


    //removing prisoner queues
    @Bean
    public Queue prisonerRemoveQueue(){
        return new Queue("prisoner.remove");
    }
    @Bean
    public Binding prisonerRemoveBinding(){
        return BindingBuilder.bind(prisonerRemoveQueue()).to(prisonerExchange()).with("prisoner.remove");
    }

    //getting prisoner queues
    @Bean
    public Queue prisonerGetQueue(){
        return new Queue("prisoner.get");
    }
    @Bean
    public Binding prisonerGetBinding(){
        return BindingBuilder.bind(prisonerGetQueue()).to(prisonerExchange()).with("prisoner.get");
    }
}
