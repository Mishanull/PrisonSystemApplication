package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Guard;
import com.fantastik4.prisonsystemapplication.models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class LoggedUsersService {
    private HashMap<Long, Guard> guards=new HashMap<>();
    private User warden=null;

    public LoggedUsersService() {
    }

    public void LogGuard(Guard g) {
        if(guards.containsKey(g.getId())){
            return;
        }
        guards.put(g.getId(),g);
    }
    public void LogOutGuard(long id){
        guards.remove(id);
    }
    public void LogWarden(User u){
        warden=u;
    }
    public void LogOutWarden(){
        warden=null;
    }

    public HashMap<Long, Guard> getGuards() {
        return guards;
    }

    public boolean isWardenLoggedIn() {
        return warden==null;
    }
}
