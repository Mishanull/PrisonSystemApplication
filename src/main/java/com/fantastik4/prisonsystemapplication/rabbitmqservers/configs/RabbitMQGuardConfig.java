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
    public Queue getGuardsPerSectTodayQueue(){
        return new Queue("guard.getPerSectorToday");
    }
    @Bean
    public Binding getGuardsPerSectTodayBinding(){
        return BindingBuilder.bind(getGuardsPerSectTodayQueue()).to(guardExchange()).with("guard.getPerSectorToday");
    }
    @Bean
    public Queue getNumGuardsPerSectQueue(){
        return new Queue("guard.getNumPerSector");
    }
    @Bean
    public Binding getNumGuardsPerSectBinding(){
        return BindingBuilder.bind(getNumGuardsPerSectQueue()).to(guardExchange()).with("guard.getNumPerSector");
    }
    @Bean
    public Queue isGuardAssignedQueue(){
        return new Queue("guard.isAssigned");
    }
    @Bean
    public Binding isGuardAssignedBinding(){
        return BindingBuilder.bind(isGuardAssignedQueue()).to(guardExchange()).with("guard.isAssigned");
    }
    @Bean
    public Queue getNumGuardsPerSectTodayQueue(){
        return new Queue("guard.getNumPerSectorToday");
    }
    @Bean
    public Binding getNumGuardsPerSectTodayBinding(){
        return BindingBuilder.bind(getNumGuardsPerSectTodayQueue()).to(guardExchange()).with("guard.getNumPerSectorToday");
    }
    @Bean
    public Queue isGuardWorkingQueue(){
        return new Queue("guard.isWorking");
    }
    @Bean
    public Binding isGuardWorkingBinding(){
        return BindingBuilder.bind(isGuardWorkingQueue()).to(guardExchange()).with("guard.isWorking");
    }

    @Bean
    public Queue changePasswordQueue(){
        return new Queue("guard.changePassword");
    }
    @Bean
    public Binding changePasswordBinding(){
        return BindingBuilder.bind(changePasswordQueue()).to(guardExchange()).with("guard.changePassword");
    }
}
