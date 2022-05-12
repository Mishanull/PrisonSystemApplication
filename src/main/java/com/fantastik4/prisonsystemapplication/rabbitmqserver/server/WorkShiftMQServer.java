package com.fantastik4.prisonsystemapplication.rabbitmqserver.server;

import com.fantastik4.prisonsystemapplication.model.WorkShift;
import com.fantastik4.prisonsystemapplication.services.WorkShiftService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.List;

public class WorkShiftMQServer {
    private WorkShiftService workShiftService;
    private Gson gson;

    public WorkShiftMQServer(WorkShiftService workShiftService) {
        this.workShiftService = workShiftService;
        gson = new Gson();
    }

    @RabbitListener(queues = "workShift.add")
    public String CreateWorkShiftAsync(Message message){
        try {
            String jsonShift = new String(message.getBody());
            return workShiftService.createWorkShift(jsonShift);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "workShift.remove")
    public String RemoveWorkShiftAsync(Message message){
        Long id = Long.parseLong(new String(message.getBody()));
        return workShiftService.removeWorkShift(id);
    }

    @RabbitListener(queues = "workShift.get")
    public String GetWorkShiftsAsync(Message message){
        List<WorkShift> shifts = workShiftService.getWorkShifts();
        if (shifts!=null) return gson.toJson(shifts);
        return "fail";
    }

    @RabbitListener(queues = "workShift.update")
    String updatePrisoner(Message message){
        try {
            String jsonPrisoner = new String(message.getBody());
            return workShiftService.updateWorkShift(jsonPrisoner);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "workShift.addGuard")
    String addGuardToWorkShiftAsync(Message message){
        return null;
    }

    @RabbitListener(queues = "workShift.setGuards")
    String setGuardsInWorkShiftAsync(Message message){
        return null;
    }

    @RabbitListener(queues = "workShift.removeGuard")
    String removeGuardFromWorkShiftAsync(Message message){
        return null;
    }
}
