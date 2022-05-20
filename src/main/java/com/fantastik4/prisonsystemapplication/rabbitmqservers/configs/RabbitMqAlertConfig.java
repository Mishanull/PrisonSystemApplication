package com.fantastik4.prisonsystemapplication.rabbitmqservers.configs;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqAlertConfig {
    @Bean
    public DirectExchange alertExchange(){return new DirectExchange("alert.exchange");}
    @Bean
    public Queue alertQueue(){
        return new Queue("alert.broadcast");
    }
    @Bean
    public Binding alertBinding(){
        return BindingBuilder.bind(alertQueue()).to(alertExchange()).with("alert.broadcast");
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("guard.listen");
    }
}
