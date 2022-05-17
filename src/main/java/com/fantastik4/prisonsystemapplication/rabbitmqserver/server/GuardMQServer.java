package com.fantastik4.prisonsystemapplication.rabbitmqserver.server;


import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.services.EmailService;
import com.fantastik4.prisonsystemapplication.services.GuardService;
import com.fantastik4.prisonsystemapplication.utils.PasswordGenerator;
import com.fantastik4.prisonsystemapplication.utils.PasswordHasher;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuardMQServer {
    private GuardService guardService;
    private EmailService emailService;
    private Gson gson;

    @Autowired
    public GuardMQServer(GuardService guardService, EmailService emailService) {
        this.guardService = guardService;
        this.emailService = emailService;
        gson = new Gson();
    }

    @RabbitListener(queues = "guard.add")
    public String createGuard(Message message) {
        String jsonGuard = new String(message.getBody());
        Guard newGuard = gson.fromJson(jsonGuard, Guard.class);

        String newPassword = PasswordGenerator.generate(8);
        System.out.println("Generated password: " + newPassword);
        String hashedPassword = PasswordHasher.hash(newPassword);
        System.out.println("Hashed password: " + hashedPassword);
        newGuard.setPassword(hashedPassword);

        String response = guardService.createGuard(newGuard);
        if (!response.equals("fail")){
            new Thread(()->{
                emailService.sendSimpleMessage(newGuard.getEmail(),
                        "Log-in credentials", "Your new log in credentials are:" +
                                "\n - username: "+newGuard.getUsername()+
                                "\n - password: "+newPassword);
            }).start();
        }
        return response;
    }

    @RabbitListener(queues = "guard.remove")
    public String removeGuard(Message message) {
        Long id = Long.parseLong(new String(message.getBody()));
        return guardService.removeGuard(id);
    }

    @RabbitListener(queues = "guard.getById")
    public String getGuardById(Message message) {
        Long guardId=Long.parseLong(new String(message.getBody()));
        return guardService.getGuardById(guardId);
    }

    @RabbitListener(queues = "guards.get")
    public String getGuards(Message message){
        return guardService.getGuards();
    }

    @RabbitListener(queues = "guard.update")
    public String updateGuard(Message message){
        return guardService.updateGuard(new String(message.getBody()));
    }
}
