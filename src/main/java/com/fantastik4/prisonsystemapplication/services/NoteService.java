package com.fantastik4.prisonsystemapplication.services;

import org.springframework.stereotype.Service;

@Service
public interface NoteService {
    String addNote(String[] prisonerIdAndText);
    String removeNote(long noteId);
    String updateNote(String note);
}
