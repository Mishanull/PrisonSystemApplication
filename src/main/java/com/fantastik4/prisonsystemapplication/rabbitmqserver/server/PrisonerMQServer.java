package com.fantastik4.prisonsystemapplication.rabbitmqserver.server;

import com.fantastik4.prisonsystemapplication.model.Prisoner;
import com.fantastik4.prisonsystemapplication.services.PrisonerService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


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
            return "fail";
        }
    }

    @RabbitListener(queues = "prisoner.update")
    public String updatePrisoner(Message message){
        try {
            String jsonPrisoner = new String(message.getBody());
            return prisonerService.updatePrisoner(jsonPrisoner);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "prisoner.remove")
    public String removePrisoner(Message message){
        Long id = Long.parseLong(new String(message.getBody()));
        return prisonerService.removePrisoner(id);
    }

    @RabbitListener(queues = "prisoner.getById")
    public String getPrisonerById(Message message){
        try {
            Long prisonerId = Long.parseLong(new String(message.getBody()));
            Prisoner p = prisonerService.getPrisonerById(prisonerId);
            if (p!=null) return gson.toJson(p);
            return "fail";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "prisoners.get")
    public String getPrisoners(Message message){
        List<Prisoner> prisoners = prisonerService.getPrisoners();
        if (prisoners!=null) return gson.toJson(prisoners);
        return "fail";
    }
}
