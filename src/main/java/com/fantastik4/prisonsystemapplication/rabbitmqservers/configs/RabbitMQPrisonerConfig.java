package com.fantastik4.prisonsystemapplication.rabbitmqservers.configs;

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
    public Binding prisonerAddBinding(){
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

    //getting all prisoners queue
    @Bean
    public Queue prisonersGetQueue(){
        return new Queue("prisoners.get");
    }
    @Bean
    public Binding prisonersGetBinding(){
        return BindingBuilder.bind(prisonersGetQueue()).to(prisonerExchange()).with("prisoners.get");
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

    //getting prisoner by id queues
    @Bean
    public Queue prisonerUpdateQueue(){
        return new Queue("prisoner.update");
    }
    @Bean
    public Binding prisonerUpdateBinding(){
        return BindingBuilder.bind(prisonerUpdateQueue()).to(prisonerExchange()).with("prisoner.update");
    }
}
