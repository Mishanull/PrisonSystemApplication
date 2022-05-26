package com.fantastik4.prisonsystemapplication.rabbitmqservers.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQGuardConfig {
    @Bean
    public DirectExchange guardExchange(){
        return new DirectExchange("guard.exchange");
    }

    @Bean
    public Queue guardQueue(){
        return new Queue("guard.add");
    }
    @Bean
    public Binding guardBinding(){
        return BindingBuilder.bind(guardQueue()).to(guardExchange()).with("guard.add");
    }

    @Bean
    public Queue guardRemoveQueue(){
        return new Queue("guard.remove");
    }
    @Bean
    public Binding guardRemoveBinding(){
        return BindingBuilder.bind(guardRemoveQueue()).to(guardExchange()).with("guard.remove");
    }

    @Bean
    public Queue guardsGetQueue(){
        return new Queue("guards.get");
    }
    @Bean
    public Binding guardsGetBinding(){
        return BindingBuilder.bind(guardsGetQueue()).to(guardExchange()).with("guards.get");
    }

    @Bean
    public Queue guardGetByIdQueue(){
        return new Queue("guard.getById");
    }
    @Bean
    public Binding guardGetByIdBinding(){
        return BindingBuilder.bind(guardGetByIdQueue()).to(guardExchange()).with("guard.getById");
    }

    @Bean
    public Queue guardUpdateQueue(){
        return new Queue("guard.update");
    }
    @Bean
    public Binding guardUpdateBinding(){
        return BindingBuilder.bind(guardUpdateQueue()).to(guardExchange()).with("guard.update");
    }
    @Bean
    public Queue guardSectorQueue(){
        return new Queue("guard.getBySector");
    }
    @Bean
    public Binding guardSectorBinding(){
        return BindingBuilder.bind(guardSectorQueue()).to(guardExchange()).with("guard.getBySector");
    }
    @Bean
    public Queue GetGuardsPerSectTodayQueue(){
        return new Queue("guard.getPerSectorToday");
    }
    @Bean
    public Binding GetGuardsPerSectTodayBinding(){
        return BindingBuilder.bind(GetGuardsPerSectTodayQueue()).to(guardExchange()).with("guard.getPerSectorToday");
    }
    @Bean
    public Queue GetNumGuardsPerSectQueue(){
        return new Queue("guard.getNumPerSector");
    }
    @Bean
    public Binding GetNumGuardsPerSectBinding(){
        return BindingBuilder.bind(GetNumGuardsPerSectQueue()).to(guardExchange()).with("guard.getNumPerSector");
    }
    @Bean
    public Queue GetNumGuardsPerSectTodayQueue(){
        return new Queue("guard.getNumPerSectorToday");
    }
    @Bean
    public Binding GetNumGuardsPerSectTodayBinding(){
        return BindingBuilder.bind(GetNumGuardsPerSectTodayQueue()).to(guardExchange()).with("guard.getNumPerSectorToday");
    }
}
