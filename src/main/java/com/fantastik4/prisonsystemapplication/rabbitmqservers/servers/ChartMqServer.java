package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.services.ChartService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChartMqServer {
    private ChartService chartService;
    @Autowired
    public ChartMqServer(ChartService chartService) {
        this.chartService = chartService;
    }

    @RabbitListener(queues="chart.get")
    public String getChartData(){
        return chartService.getChartData();
    }
}
