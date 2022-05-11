package com.fantastik4.prisonsystemapplication.rabbitmqserver.server;


import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.model.Prisoner;
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
    public String addGuard(Message message) {
        String jsonGuard = new String(message.getBody());
        System.out.println(jsonGuard);
        Guard newGuard = gson.fromJson(jsonGuard, Guard.class);
        System.out.println(newGuard);
        return gson.toJson(guardService.addGuard(newGuard));
    }

    @RabbitListener(queues = "guard.remove")
    public String removeGuard(Message message) {
        Long id = Long.parseLong(new String(message.getBody()));
        return gson.toJson(guardService.removeGuard(id));
    }

    @RabbitListener(queues = "guard.getById")
    public String getGuardById(Message message) {
        Long guardId=Long.parseLong(new String(message.getBody()));
        Guard guard = guardService.getGuardById(guardId);
        if (guard!=null) return gson.toJson(guard);
        return "failed " ;
    }

    @RabbitListener(queues = "guards.get")
    public String getGuards(Message message){
        System.out.println(new String(message.getBody()));
        List<Guard> guards = guardService.getGuards();
        if (guards!=null) return gson.toJson(guards);
        return "failed to fetch guards";
    }
    @RabbitListener(queues = "guard.update")
    public String updateGuard(Message message){
        System.out.println(new String(message.getBody()));
        return guardService.updateGuard(new String(message.getBody()));
    }
}
