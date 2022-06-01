package com.fantastik4.prisonsystemapplication.rabbitmqservers.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqChartConfig {

    @Bean
    public Queue chartQueue(){
        return new Queue("chart.get");
    }
    @Bean
    public DirectExchange chartExchange(){
        return new DirectExchange("chart.exchange");
    }
    @Bean
    public Binding chartBinding() {
        return BindingBuilder.bind(chartQueue()).to(chartExchange()).with("chart.get");
    }
}
