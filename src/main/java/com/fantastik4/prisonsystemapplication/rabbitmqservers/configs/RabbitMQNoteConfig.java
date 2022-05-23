package com.fantastik4.prisonsystemapplication.rabbitmqservers.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQNoteConfig {
    @Bean
    public DirectExchange noteExchange(){
        return new DirectExchange("note.exchange");
    }

    @Bean
    public Queue noteQueue(){
        return new Queue("note.add");
    }
    @Bean
    public Binding noteBinding(){
        return BindingBuilder.bind(noteQueue()).to(noteExchange()).with("note.add");
    }

    @Bean
    public Queue notedRemoveQueue(){
        return new Queue("note.remove");
    }
    @Bean
    public Binding noteRemoveBinding(){
        return BindingBuilder.bind(notedRemoveQueue()).to(noteExchange()).with("note.remove");
    }

    @Bean
    public Queue noteUpdateQueue(){
        return new Queue("note.update");
    }
    @Bean
    public Binding noteUpdateBinding(){
        return BindingBuilder.bind(noteUpdateQueue()).to(noteExchange()).with("note.update");
    }
}
