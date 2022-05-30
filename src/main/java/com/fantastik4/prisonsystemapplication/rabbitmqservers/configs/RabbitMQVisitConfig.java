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
    public Queue CreateVisitQueue(){return new Queue("visit.add");}
    @Bean
    public Binding CreateVisitBinding(){
        return BindingBuilder.bind(CreateVisitQueue()).to(visitExchange()).with("visit.add");
    }

    @Bean
    public Queue GetVisitsQueue(){return new Queue("visit.get");}
    @Bean
    public Binding GetVisitsBinding(){
        return BindingBuilder.bind(GetVisitsQueue()).to(visitExchange()).with("visit.get");
    }

    @Bean
    public Queue GetVisitByAccessCodeQueue(){return new Queue("visit.getByCode");}
    @Bean
    public Binding gGetVisitByAccessCodeBinding(){
        return BindingBuilder.bind(GetVisitByAccessCodeQueue()).to(visitExchange()).with("visit.getByCode");
    }

    @Bean
    public Queue UpdateVisitStatusQueue(){return new Queue("visit.update");}
    @Bean
    public Binding UpdateVisitStatusBinding(){
        return BindingBuilder.bind(UpdateVisitStatusQueue()).to(visitExchange()).with("visit.update");
    }
    @Bean
    public Queue GetNumVisitsTodayAsyncQueue(){return new Queue("visit.getNumToday");}
    @Bean
    public Binding GetNumVisitsTodayAsyncBinding(){
        return BindingBuilder.bind(GetNumVisitsTodayAsyncQueue()).to(visitExchange()).with("visit.getNumToday");
    }
    @Bean
    public Queue GetVisitsPendingAsyncQueue(){return new Queue("visit.getPending");}
    @Bean
    public Binding GetVisitsPendingAsyncBinding(){
        return BindingBuilder.bind(GetVisitsPendingAsyncQueue()).to(visitExchange()).with("visit.getPending");
    }
}
