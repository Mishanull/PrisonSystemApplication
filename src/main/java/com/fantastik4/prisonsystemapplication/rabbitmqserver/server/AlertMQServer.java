package com.fantastik4.prisonsystemapplication.rabbitmqserver.server;

import com.fantastik4.prisonsystemapplication.services.GuardService;
import com.fantastik4.prisonsystemapplication.services.LoggedUsersService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class AlertMQServer {
    private GuardService guardService;
//    private LoggedUsersService loggedUsersService;
    private Gson gson;
    @Autowired
    public AlertMQServer(GuardService guardService) {
        this.guardService = guardService;
//        this.loggedUsersService = loggedUsersService;
        this.gson=new Gson();
    }



    @RabbitListener(queues="alert.broadcast")
    @SendTo("guards.listen.alert")
    public String broadcastAlert(Message message){
        System.out.println(new String(message.getBody()));
        return new String(message.getBody());
    }
}
