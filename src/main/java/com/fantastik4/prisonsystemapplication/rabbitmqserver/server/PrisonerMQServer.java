package com.fantastik4.prisonsystemapplication.rabbitmqserver.server;

import com.fantastik4.prisonsystemapplication.model.Prisoner;
import com.fantastik4.prisonsystemapplication.services.PrisonerService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class PrisonerMQServer {
    private PrisonerService prisonerService;
    private Gson gson;

    @Autowired
    public PrisonerMQServer(PrisonerService prisonerService) {
        this.prisonerService = prisonerService;
        gson = new Gson();
    }

    @RabbitListener(queues = "prisoner.add")
    public String addPrisoner(Message message){
        try {
            String jsonPrisoner = new String(message.getBody());
            return prisonerService.addPrisoner(jsonPrisoner);
        }catch (Exception e){
            e.printStackTrace();
            return gson.toJson(null);
        }
    }

    @RabbitListener(queues = "prisoner.remove")
    public String removePrisoner(Message message){
        String jsonPrisoner = new String(message.getBody());
        Prisoner releasedPrisoner = gson.fromJson(jsonPrisoner, Prisoner.class);
        return gson.toJson(prisonerService.removePrisoner(releasedPrisoner));
    }

    @RabbitListener(queues = "prisoner.getById")
    public String getPrisonerById(Message message){
        Long prisonerId = gson.fromJson(new String(message.getBody()), Long.class);
        Prisoner p = prisonerService.getPrisonerById(prisonerId);
        if (p!=null) return gson.toJson(p);
        return "failed to fetch prisoner-" +prisonerId;
    }

    @RabbitListener(queues = "prisoners.get")
    public String getPrisoners(Message message){
        ArrayList<Prisoner> prisoners = prisonerService.getPrisoners();
        if (prisoners!=null) return gson.toJson(prisoners);
        return "failed to fetch prisoners";
    }
}
