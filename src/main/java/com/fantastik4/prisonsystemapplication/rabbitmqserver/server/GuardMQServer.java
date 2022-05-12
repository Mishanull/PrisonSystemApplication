package com.fantastik4.prisonsystemapplication.rabbitmqserver.server;


import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.services.GuardService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GuardMQServer {
    private GuardService guardService;
    private Gson gson;

    public GuardMQServer(GuardService guardService) {
        this.guardService = guardService;
        gson = new Gson();
    }

    @RabbitListener(queues = "guard.add")
    public String createGuard(Message message) {
        String jsonGuard = new String(message.getBody());
        Guard newGuard = gson.fromJson(jsonGuard, Guard.class);
        return guardService.createGuard(newGuard);
    }

    @RabbitListener(queues = "guard.remove")
    public String removeGuard(Message message) {
        Long id = Long.parseLong(new String(message.getBody()));
        return guardService.removeGuard(id);
    }

    @RabbitListener(queues = "guard.getById")
    public String getGuardById(Message message) {
        Long guardId=Long.parseLong(new String(message.getBody()));
        return guardService.getGuardById(guardId);
    }

    @RabbitListener(queues = "guards.get")
    public String getGuards(Message message){
        return guardService.getGuards();
    }

    @RabbitListener(queues = "guard.update")
    public String updateGuard(Message message){
        return guardService.updateGuard(new String(message.getBody()));
    }
}
