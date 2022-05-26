package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.models.Visit;
import com.fantastik4.prisonsystemapplication.services.EmailService;
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
    private EmailService emailService;
    private Gson gson;

    @Autowired
    public VisitMQServer(VisitService visitService, EmailService emailService, Gson gson) {
        this.visitService = visitService;
        this.emailService = emailService;
        this.gson = gson;
    }

    @RabbitListener(queues = "visit.add")
    public String CreateVisit(Message message){
        String jsonVisit = new String(message.getBody());
        String response = visitService.CreateVisit(jsonVisit);

        Visit v = gson.fromJson(jsonVisit, Visit.class);
        if (response.equals("success")){
            new Thread(()->{
                emailService.sendSimpleMessage(v.getEmail(),"Visit request auto-response",
                        "Your visit-request was sent successfully.\nWait for the approval mail containing your access code please.");
            }).start();
        }
        else if(response.equals("denied")){
            new Thread(()->{
                emailService.sendSimpleMessage(v.getEmail(),"Visit request auto-response",
                        "Your visit-request was denied due to bad behavior score of visited inmate.\nTry again in a few weeks please.");
            }).start();
        }
        else {
            new Thread(()->{
                emailService.sendSimpleMessage(v.getEmail(),"Visit request auto-response",
                        "Your visit-request failed to send." + "\nTry again later please.");
            }).start();
        }

        return response;
    }

    @RabbitListener(queues = "visit.get")
    public String GetVisits(Message message){
        String response = new String(message.getBody());
        String[] pagination;
        pagination = gson.fromJson(response,String[].class);
        return visitService.GetVisits(pagination[0],pagination[1]);
    }

    @RabbitListener(queues = "visit.getByCode")
    String GetVisitByAccessCode(Message message){
        String code = new String(message.getBody());
        return visitService.GetVisitByAccessCode(code);
    }

    @RabbitListener(queues = "visit.update")
    String UpdateVisitStatus(Message message){
        try {

            String response = new String(message.getBody());
            String[] strArray;
            strArray=gson.fromJson(response,String[].class);
            return visitService.UpdateVisitStatus(strArray);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "visit.getNumToday")
    public String GetNumVisitsTodayAsync(){
        return  visitService.GetNumVisitsTodayAsync();
    }
}