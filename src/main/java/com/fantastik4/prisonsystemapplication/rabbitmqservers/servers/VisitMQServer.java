package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.models.Visit;
import com.fantastik4.prisonsystemapplication.services.EmailService;
import com.fantastik4.prisonsystemapplication.services.VisitService;
import com.fantastik4.prisonsystemapplication.utils.PasswordGenerator;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public String createVisit(Message message){
        String jsonVisit = new String(message.getBody());
        String response = visitService.createVisit(jsonVisit);

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
    public String getVisits(Message message){
        String response = new String(message.getBody());
        String[] pagination;
        pagination = gson.fromJson(response,String[].class);
        return visitService.getVisits(pagination[0],pagination[1]);
    }

    @RabbitListener(queues = "visit.getByCode")
    String getVisitByAccessCode(Message message){
        String code = new String(message.getBody());
        return visitService.getVisitByAccessCode(code);
    }

    @RabbitListener(queues = "visit.update")
    String updateVisitStatus(Message message){
        try {

            String response = new String(message.getBody());
            String[] request=new String[3];
            Visit visit=gson.fromJson(response, Visit.class);
            switch (visit.getStatus()){
                case Approved ->{
                    String accessCode=PasswordGenerator.generate(10);
                    visit.setAccessCode(accessCode);
                    request[2]=accessCode;
                    emailService.sendSimpleMessage(visit.getEmail(),"Visit Approved","Your visit for "
                        + visit.getVisitDate().toGMTString()+" has been approved. \n You need to be there at the exact hour you booked, no later than half an hour after, otherwise you will be denied entrance.\nThe access code is "+ visit.getAccessCode());}

                case Denied -> emailService.sendSimpleMessage(visit.getEmail(), "Visit was denied","Your visit for " + visit.getVisitDate().toGMTString() +" has been denied.\n Contact the prison management to find out why.");
            }
            request[0]=visit.getId().toString();
            request[1]=visit.getStatus().toString();
            return visitService.updateVisitStatus(request);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "visit.getNumToday")
    public String getNumVisitsToday(){
        return  visitService.getVisitsToday();
    }
    @RabbitListener(queues = "visit.getPending")
    public String getPendingVisits(){
        return  visitService.getVisitsPending();
    }
}