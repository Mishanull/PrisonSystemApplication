package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.models.Alert;
import com.fantastik4.prisonsystemapplication.services.AlertService;
import com.fantastik4.prisonsystemapplication.services.GuardService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertMQServer {
    private AlertService alertService;
    private RabbitTemplate template;
//    private LoggedUsersService loggedUsersService;
    private Gson gson;
    @Autowired
    public AlertMQServer(AlertService alertService,RabbitTemplate template) {
        this.template=template;
        this.alertService = alertService;
        this.gson=new Gson();
    }



    @RabbitListener(queues="alert.broadcast")
    public void broadcastAlert(Message message){

        String alert=new String(message.getBody());
        Alert a=gson.fromJson(alert,Alert.class);
        System.out.println(a);
        template.convertAndSend("guard.listen", "", alert);
        alertService.createAlert(alert);
    }
    @RabbitListener(queues = "alert.get")
    public String getAlerts(Message message){
        return alertService.getAlerts();
    }
}
