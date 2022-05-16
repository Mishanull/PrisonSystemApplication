package com.fantastik4.prisonsystemapplication.rabbitmqserver.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQWorkShiftConfig {

    @Bean
    public DirectExchange workShiftExchange(){
        return new DirectExchange("workShift.exchange");
    }

    @Bean
    public Queue createWorkShiftQueue(){return new Queue("workShift.add");}
    @Bean
    public Binding createWorkShiftBinding(){
        return BindingBuilder.bind(createWorkShiftQueue()).to(workShiftExchange()).with("workShift.add");
    }

    @Bean
    public Queue removeWorkShiftQueue(){return new Queue("workShift.remove");}
    @Bean
    public Binding removeWorkShiftBinding(){
        return BindingBuilder.bind(removeWorkShiftQueue()).to(workShiftExchange()).with("workShift.remove");
    }

    @Bean
    public Queue getWorkShiftsQueue(){return new Queue("workShift.get");}
    @Bean
    public Binding getWorkShiftsBinding(){
        return BindingBuilder.bind(getWorkShiftsQueue()).to(workShiftExchange()).with("workShift.get");
    }

    @Bean
    public Queue updateWorkShiftQueue(){return new Queue("workShift.update");}
    @Bean
    public Binding updateWorkShiftBinding(){
        return BindingBuilder.bind(updateWorkShiftQueue()).to(workShiftExchange()).with("workShift.update");
    }

    @Bean
    public Queue addGuardToWorkShiftQueue(){return new Queue("workShift.addGuard");}
    @Bean
    public Binding addGuardToWorkShiftBinding(){
        return BindingBuilder.bind(addGuardToWorkShiftQueue()).to(workShiftExchange()).with("workShift.addGuard");
    }

    @Bean
    public Queue setGuardsInWorkShiftQueue(){return new Queue("workShift.setGuards");}
    @Bean
    public Binding setGuardsInWorkShiftBinding(){
        return BindingBuilder.bind(setGuardsInWorkShiftQueue()).to(workShiftExchange()).with("workShift.setGuards");
    }

    @Bean
    public Queue removeGuardFromWorkShiftQueue(){return new Queue("workShift.removeGuard");}
    @Bean
    public Binding removeGuardFromWorkShiftBinding(){
        return BindingBuilder.bind(removeGuardFromWorkShiftQueue()).to(workShiftExchange()).with("workShift.removeGuard");
    }
}
