package com.fantastik4.prisonsystemapplication.services;

import org.springframework.stereotype.Service;

@Service
public interface NoteService {
    String AddNote(String[] prisonerIdAndText);
    String RemoveNote(long noteId);
    String UpdateNote(String note);
}
