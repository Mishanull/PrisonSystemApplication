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
    @Bean
    public Queue prisonerSSNQueue(){
        return new Queue("prisoner.getBySSN");
    }
    @Bean
    public Binding prisonerSSNBinding(){
        return BindingBuilder.bind(prisonerSSNQueue()).to(prisonerExchange()).with("prisoner.getBySSN");
    }
    @Bean
    public Queue prisonerCountQueue(){
        return new Queue("prisoners.count");
    }
    @Bean
    public Binding prisonerCountBinding(){
        return BindingBuilder.bind(prisonerCountQueue()).to(prisonerExchange()).with("prisoners.count");
    }
    @Bean
    public Queue prisonersBySectorQueue(){
        return new Queue("prisoners.getBySector");
    }
    @Bean
    public Binding prisonersBySectorBinding(){
        return BindingBuilder.bind(prisonersBySectorQueue()).to(prisonerExchange()).with("prisoners.getBySector");
    }


    @Bean
    public Queue getNumPrisPerSectAsyncQueue(){
        return new Queue("prisoner.getNumPerSector");
    }
    @Bean
    public Binding getNumPrisPerSectAsyncBinding(){
        return BindingBuilder.bind(getNumPrisPerSectAsyncQueue()).to(prisonerExchange()).with("prisoner.getNumPerSector");
    }@Bean
    public Queue addPointsToPrisonerQueue(){
        return new Queue("prisoner.addPoints");
    }
    @Bean
    public Binding addPointsToPrisonerBinding(){
        return BindingBuilder.bind(addPointsToPrisonerQueue()).to(prisonerExchange()).with("prisoner.addPoints");
    }
    @Bean public Queue getPrisonersWithLowBehaviour(){
        return new Queue("prisoner.getLowBehaviour");
    }
    @Bean
    public Binding getPrisonerWithLowBehaviourBinding(){
        return BindingBuilder.bind(getPrisonersWithLowBehaviour()).to(prisonerExchange()).with("prisoner.getLowBehaviour");
    }
}
