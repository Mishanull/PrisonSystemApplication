package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.models.Alert;
import com.fantastik4.prisonsystemapplication.services.AlertService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertMQServer {
    private AlertService alertService;
    private RabbitTemplate template;
    private Gson gson;
    @Autowired
    public AlertMQServer(AlertService alertService,RabbitTemplate template) {
        this.template=template;
        this.alertService = alertService;
        this.gson=new Gson();
    }


    @RabbitListener(queues="alert.broadcast")
    public String broadcastAlert(Message message){
        String request=new String(message.getBody());
        Alert alert=gson.fromJson(request,Alert.class);
        try{
        if(alert.getSectors()[0]) template.convertAndSend("guard.listen.sector1", "", request);
        if(alert.getSectors()[1]) template.convertAndSend("guard.listen.sector2", "", request);
        if(alert.getSectors()[1]) template.convertAndSend("guard.listen.sector3", "", request);
        alertService.createAlert(request);
        return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "alert.get")
    public String getAlerts(Message message){
        String response = new String(message.getBody());
        String[] pagination;
        pagination = gson.fromJson(response,String[].class);
        return alertService.getAlerts(pagination[0], pagination[1]);
    }

    @RabbitListener(queues = "alert.getNum")
    public String GetAlertsToday(){
        return alertService.GetAlertsToday();
    }
}
