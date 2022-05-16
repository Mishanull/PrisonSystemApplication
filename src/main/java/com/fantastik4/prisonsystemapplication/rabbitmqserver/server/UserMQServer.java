package com.fantastik4.prisonsystemapplication.rabbitmqserver.server;

import com.fantastik4.prisonsystemapplication.model.Guard;
import com.fantastik4.prisonsystemapplication.model.User;
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
            System.out.println(message);
            User user = userService.getUser(new String(message.getBody()));
            System.out.println(user.getRole());
            if(user!=null) return gson.toJson(user);
            else throw new Exception("User not retrieved yet");
        }
        catch (Exception e){
            e.printStackTrace();
//            System.exit(1);
            return "error";
        }
    }
//    @RabbitListener(queues ="login.confirm")
//    public void logUser(Message message){
//        Long id=Long.parseLong(new String(message.getBody()));
//        User u=userService.getUserById(id);
//        if(u.getRole().equals("guard")){
//            loggedUsersService.LogGuard((Guard)u);
//        }
//        else loggedUsersService.LogWarden(u);
//    }
//    @RabbitListener(queues ="logout.confirm")
//    public void logOutUser(Message message){
//        Long id=Long.parseLong(new String(message.getBody()));
//        User u=userService.getUserById(id);
//        if(u.getRole().equals("guard")){
//            loggedUsersService.LogOutGuard(u.getId());
//        }
//        else loggedUsersService.LogOutWarden();
//    }

}
