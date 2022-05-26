package com.fantastik4.prisonsystemapplication.rabbitmqservers.configs;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQAlertConfig {
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
    public Queue getAlertsQueue(){
        return new Queue("alert.get");
    }
    @Bean
    public Binding getAlertsBinding(){
        return BindingBuilder.bind(getAlertsQueue()).to(alertExchange()).with("alert.get");
    }
    @Bean
    public FanoutExchange allSectorsExchange(){
        return new FanoutExchange("guard.listen");
    }
    @Bean
    public FanoutExchange sector1Exchange(){return new FanoutExchange("guard.listen.sector1");}
    @Bean
    public FanoutExchange sector2Exchange(){return new FanoutExchange("guard.listen.sector2");}
    @Bean
    public FanoutExchange sector3Exchange(){return new FanoutExchange("guard.listen.sector3");}

}
