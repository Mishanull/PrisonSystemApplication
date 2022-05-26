package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.services.SectorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SectorMQServer {

    private SectorService sectorService;
    @Autowired
    public SectorMQServer(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @RabbitListener(queues = "sectors.get")
    public String getSectors(){
        return sectorService.getSectors();
    }
}
