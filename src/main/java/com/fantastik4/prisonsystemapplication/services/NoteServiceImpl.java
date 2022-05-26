package com.fantastik4.prisonsystemapplication.services;

import com.fantastik4.prisonsystemapplication.models.Note;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NoteServiceImpl implements NoteService {
    private final RestTemplate restTemplate;
    private Gson gson;

    @Autowired
    public NoteServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        gson = new Gson();
    }

    @Override
    public String addNote(String[] prisonerIdAndText) {
        try {
            String[] request = new String[2];
            request[0] = prisonerIdAndText[0];
            request[1] = prisonerIdAndText[1];

            restTemplate.postForObject("https://localhost:7150/Note", request, String.class);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String removeNote(long noteId) {
        try {
            restTemplate.delete("https://localhost:7150/Note/{noteId}", noteId);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String updateNote(String note) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(note, headers);
            restTemplate.patchForObject("https://localhost:7150/Note", request, Note.class);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
