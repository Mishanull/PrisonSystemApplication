package com.fantastik4.applicationtier.rabbitmqserver.server;

import com.fantastik4.applicationtier.model.User;
import com.fantastik4.applicationtier.services.UserService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class UserMQServer {

    private UserService userService;
    private Gson gson;

    @Autowired
    public UserMQServer(UserService userService) {
        this.userService=userService;
        gson=new Gson();
    }

    @RabbitListener(queues="prison.users")
    public String getUser(Message message){
        try {
            System.out.println(message);
            User user = userService.getUser(new String(message.getBody()));
            System.out.println(user);
            if(user!=null) return gson.toJson(user);
            else throw new Exception("User not retrieved yet");
        }
        catch (Exception e){
            e.printStackTrace();
//            System.exit(1);
            return "error";
        }
    }


}
