package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.services.NoteService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteMQServer {
    private NoteService noteService;
    private final Gson gson;

    @Autowired
    public NoteMQServer(NoteService noteService) {
        this.noteService = noteService;
        this.gson = new Gson();
    }

    @RabbitListener(queues = "note.add")
    public String addNote(Message message) {
        try {
            String response = new String(message.getBody());
            String[] strArray;
            strArray = gson.fromJson(response, String[].class);
            return noteService.addNote(strArray);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RabbitListener(queues = "note.remove")
    public String removeNote(Message message){
        Long noteId = Long.parseLong(new String(message.getBody()));
        return noteService.removeNote(noteId);
    }

    @RabbitListener(queues = "note.update")
    public String updateNote(Message message){
        String jsonNote = new String(message.getBody());
        return noteService.updateNote(jsonNote);
    }
}
