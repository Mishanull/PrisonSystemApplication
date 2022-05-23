package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.models.Visit;
import com.fantastik4.prisonsystemapplication.services.VisitService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VisitMQServer {
    private VisitService visitService;
    private Gson gson;

    @Autowired
    public VisitMQServer(VisitService visitService, Gson gson) {
        this.visitService = visitService;
        this.gson = gson;
    }

    @RabbitListener(queues = "visit.add")
    public String CreateVisit(Message message){
        try {
            String jsonVisit = new String(message.getBody());
            return visitService.CreateVisit(jsonVisit);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "visit.get")
    public String GetVisits(){
        return visitService.GetVisits();
    }

    @RabbitListener(queues = "visit.getByCode")
    String GetVisitByAccessCode(Message message){
        String code = new String(message.getBody());
        return visitService.GetVisitByAccessCode(code);
    }

    @RabbitListener(queues = "visit.update")
    String UpdateVisitStatus(Message message){
        try {
            String[] strArray = new String[]{new String(message.getBody())};
            String id = strArray[0];
            String status = strArray[1];
            return visitService.UpdateVisitStatus(id, status);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}