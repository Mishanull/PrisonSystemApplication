package com.fantastik4.prisonsystemapplication.rabbitmqservers.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQVisitConfig {
    @Bean
    public DirectExchange visitExchange(){
        return new DirectExchange("visit.exchange");
    }

    @Bean
    public Queue createVisitQueue(){return new Queue("visit.add");}
    @Bean
    public Binding createVisitBinding(){
        return BindingBuilder.bind(createVisitQueue()).to(visitExchange()).with("visit.add");
    }

    @Bean
    public Queue getVisitsQueue(){return new Queue("visit.get");}
    @Bean
    public Binding getVisitsBinding(){
        return BindingBuilder.bind(getVisitsQueue()).to(visitExchange()).with("visit.get");
    }

    @Bean
    public Queue getVisitByAccessCodeQueue(){return new Queue("visit.getByCode");}
    @Bean
    public Binding getVisitByAccessCodeBinding(){
        return BindingBuilder.bind(getVisitByAccessCodeQueue()).to(visitExchange()).with("visit.getByCode");
    }

    @Bean
    public Queue updateVisitStatusQueue(){return new Queue("visit.update");}
    @Bean
    public Binding updateVisitStatusBinding(){
        return BindingBuilder.bind(updateVisitStatusQueue()).to(visitExchange()).with("visit.update");
    }
    @Bean
    public Queue getNumVisitsTodayQueue(){return new Queue("visit.getNumToday");}
    @Bean
    public Binding getNumVisitsTodayBinding(){
        return BindingBuilder.bind(getNumVisitsTodayQueue()).to(visitExchange()).with("visit.getNumToday");
    }
    @Bean
    public Queue getVisitsPendingQueue(){return new Queue("visit.getPending");}
    @Bean
    public Binding getVisitsPendingBinding(){
        return BindingBuilder.bind(getVisitsPendingQueue()).to(visitExchange()).with("visit.getPending");
    }
}
