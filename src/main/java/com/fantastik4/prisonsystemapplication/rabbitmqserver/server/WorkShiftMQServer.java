package com.fantastik4.prisonsystemapplication.rabbitmqserver.server;

import com.fantastik4.prisonsystemapplication.model.WorkShift;
import com.fantastik4.prisonsystemapplication.services.WorkShiftService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkShiftMQServer {
    private final WorkShiftService workShiftService;
    private Gson gson;

    @Autowired
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
            String jsonShifts = new String(message.getBody());
            return workShiftService.updateWorkShift(jsonShifts);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "workShift.addGuard")
    String addGuardToWorkShiftAsync(Message message) {
        try {
            String[] strArray = new String[]{new String(message.getBody())};
            String guardId = strArray[0];
            String shiftId = strArray[0];
            return workShiftService.addGuardToWorkShift(guardId, shiftId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "workShift.removeGuard")
    String removeGuardFromWorkShiftAsync(Message message) {
        try {
            String[] strArray = new String[]{new String(message.getBody())};
            String guardId = strArray[0];
            String shiftId = strArray[0];
            return workShiftService.removeGuardFromWorkShift(guardId, shiftId);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}

