package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.models.User;
import com.fantastik4.prisonsystemapplication.services.LoggedUsersService;
import com.fantastik4.prisonsystemapplication.services.UserService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMQServer {

    private UserService userService;
    private Gson gson;
    private LoggedUsersService loggedUsersService;
    @Autowired
    public UserMQServer(UserService userService) {
        this.userService=userService;
        gson=new Gson();
    }

    @RabbitListener(queues="prison.users")
    public String getUser(Message message){
        try {
            User user = userService.getUser(new String(message.getBody()));
            assert user!=null;
            return gson.toJson(user);
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

}
