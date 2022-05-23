package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.services.WorkShiftService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
    public String GetWorkShiftsAsync(){
        return workShiftService.getWorkShifts();
    }

    @RabbitListener(queues = "workShift.getById")
    public String getWorkShiftById(Message message){
        Long workShiftId = Long.parseLong(new String(message.getBody()));
        return workShiftService.getWorkShiftById(workShiftId);
    }

    @RabbitListener(queues = "workShift.update")
    String updateWorkShift(Message message){
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
            String response = new String(message.getBody());
            String[] strArray;
            strArray=gson.fromJson(response,String[].class);
            return workShiftService.addGuardToWorkShift(strArray);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "workShift.removeGuard")
    String removeGuardFromWorkShiftAsync(Message message) {
        try {
            String response = new String(message.getBody());
            String[] strArray;
            strArray=gson.fromJson(response,String[].class);
            return workShiftService.removeGuardFromWorkShift(strArray);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}

