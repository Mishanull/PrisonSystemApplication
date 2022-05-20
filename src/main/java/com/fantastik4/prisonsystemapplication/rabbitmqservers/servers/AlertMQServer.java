package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.services.GuardService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertMQServer {
    private GuardService guardService;
    private RabbitTemplate template;
//    private LoggedUsersService loggedUsersService;
    private Gson gson;
    @Autowired
    public AlertMQServer(GuardService guardService,RabbitTemplate template) {
        this.template=template;
        this.guardService = guardService;
//        this.loggedUsersService = loggedUsersService;
        this.gson=new Gson();
    }



    @RabbitListener(queues="alert.broadcast")
    public void broadcastAlert(Message message){

        String alert=new String(message.getBody());
        System.out.println(alert);
        template.convertAndSend("guard.listen","",alert);
    }
}
