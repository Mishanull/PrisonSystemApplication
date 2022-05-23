package com.fantastik4.prisonsystemapplication.rabbitmqservers.servers;

import com.fantastik4.prisonsystemapplication.services.NoteService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteMQServer {
    private NoteService noteService;

    @Autowired
    public NoteMQServer(NoteService noteService) {
        this.noteService = noteService;
    }

    @RabbitListener(queues = "note.add")
    public String addNote(Message message){
        String text = new String(message.getBody());
   ////??????
        return text;
    }

    @RabbitListener(queues = "note.remove")
    public String removeNote(Message message){
        Long noteId = Long.parseLong(new String(message.getBody()));
        return noteService.RemoveNote(noteId);
    }

    @RabbitListener(queues = "note.update")
    public String updateNote(Message message){
        String jsonNote = new String(message.getBody());
        return noteService.UpdateNote(jsonNote);
    }
}
