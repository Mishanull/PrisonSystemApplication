package com.fantastik4.prisonsystemapplication.rabbitmqserver.config;

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
    public Queue prisonerAddQueue(){
        return new Queue("prisoner.add");
    }
    @Bean
    public Binding prisonerBinding(){
        return BindingBuilder.bind(prisonerAddQueue()).to(prisonerExchange()).with("prisoner.add");
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
        return new Queue("prisoners.get");
    }
    @Bean
    public Binding prisonerGetBinding(){
        return BindingBuilder.bind(prisonerGetQueue()).to(prisonerExchange()).with("prisoners.get");
    }

    //getting prisoner by id queues
    @Bean
    public Queue prisonerGetByIdQueue(){
        return new Queue("prisoner.getById");
    }
    @Bean
    public Binding prisonerGetByIdBinding(){
        return BindingBuilder.bind(prisonerGetByIdQueue()).to(prisonerExchange()).with("prisoner.getById");
    }
}
