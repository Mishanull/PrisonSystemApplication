package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.services.PrisonerService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PrisonerMQServer {
    private PrisonerService prisonerService;
    private Gson gson=new Gson();
    @Autowired
    public PrisonerMQServer(PrisonerService prisonerService) {
        this.prisonerService = prisonerService;
    }

    @RabbitListener(queues = "prisoner.add")
    public String createPrisoner(Message message){
        String jsonPrisoner = new String(message.getBody());
        return prisonerService.createPrisoner(jsonPrisoner);
    }

    @RabbitListener(queues = "prisoner.update")
    public String updatePrisoner(Message message){
        String jsonPrisoner = new String(message.getBody());
        return prisonerService.updatePrisoner(jsonPrisoner);
    }

    @RabbitListener(queues = "prisoner.remove")
    public String removePrisoner(Message message){
        Long prisonerId = Long.parseLong(new String(message.getBody()));
        return prisonerService.removePrisoner(prisonerId);
    }

    @RabbitListener(queues = "prisoner.getById")
    public String getPrisonerById(Message message){
        Long prisonerId = Long.parseLong(new String(message.getBody()));
        return prisonerService.getPrisonerById(prisonerId);
    }

    @RabbitListener(queues = "prisoners.get")
    public String getPrisoners(Message message){
        try {
            String response = new String(message.getBody());
            String[] pagination = gson.fromJson(response, String[].class);
            return prisonerService.getPrisoners(pagination[0], pagination[1]);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "prisoner.getBySSN")
    public String getPrisonerBySSN(Message message){
        String SSN=new String(message.getBody());
        return prisonerService.getPrisonerBySSN(SSN);
    }

    @RabbitListener(queues = "prisoner.getNumPerSector")
    public String GetNumPrisPerSectAsync(){
        return prisonerService.GetNumPrisPerSectAsync();
    }

    @RabbitListener(queues = "prisoner.addPoints")
    public String AddPointsToPrisoner(Message message){
        try {
            String response = new String(message.getBody());
            String[] strArray;
            strArray=gson.fromJson(response,String[].class);
            return prisonerService.AddPointsToPrisoner(strArray);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @RabbitListener(queues = "prisoners.count")
    public String getPrisonersCount(){
        return prisonerService.getPrisonersCount();
    }
    @RabbitListener(queues = "prisoners.getBySector")
    public String getPrisonersBySector(Message message){
        String response = new String(message.getBody());
        String[] toArray = gson.fromJson(response, String[].class);
        return prisonerService.getPrisonersBySector(toArray[0],toArray[1],toArray[2]);
    }
    @RabbitListener(queues = "prisoner.getLowBehaviour")
    public String getPrisonersWithLowBehaviour(){
        return prisonerService.getPrisonersWithLowBehaviour();
    }
}
