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

        String request=new String(message.getBody());
        String[] array=gson.fromJson(request,String[].class);
        Long[] sectors=gson.fromJson(array[1],Long[].class);
        if(sectors[0]==1) template.convertAndSend("guard.listen.sector1", "", array[0]);
        if(sectors[1]==2) template.convertAndSend("guard.listen.sector2", "", array[0]);
        if(sectors[2]==3) template.convertAndSend("guard.listen.sector3", "", array[0]);
        alertService.createAlert(array[0]);
    }
    @RabbitListener(queues = "alert.get")
    public String getAlerts(Message message){
        String response = new String(message.getBody());
        String[] pagination=new String[2];
        pagination = gson.fromJson(response,String[].class);
        return alertService.getAlerts(pagination[0], pagination[1]);
    }
}
