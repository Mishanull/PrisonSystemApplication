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
    public String addPGuard(Message message) {
        String jsonGuard = new String(message.getBody());
        System.out.println(jsonGuard);
        Guard newGuard = gson.fromJson(jsonGuard, Guard.class);
        System.out.println(newGuard);
        return gson.toJson(guardService.addPGuard(newGuard));
    }

    @RabbitListener(queues = "guard.remove")
    public String removeGuard(Message message) {
        String jsonGuard = new String(message.getBody());
        Guard releaseGuard = gson.fromJson(jsonGuard, Guard.class);
        return gson.toJson(guardService.removeGuard(releaseGuard));
    }

    @RabbitListener(queues = "guard.getById")
    public String getGuardById(Message message) {
        Long guardId = gson.fromJson(new String(message.getBody()), Long.class);
        Guard guard = guardService.getGuardById(guardId);
        if (guard!=null) return gson.toJson(guard);
        return "failed to fetch guard-" +guardId;
    }

    @RabbitListener(queues = "guards.get")
    public String getGuards(Message message){
        List<Guard> guards = guardService.getGuards();
        if (guards!=null) return gson.toJson(guards);
        return "failed to fetch guards";
    }
}
