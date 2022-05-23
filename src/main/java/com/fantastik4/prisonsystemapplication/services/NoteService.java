package com.fantastik4.prisonsystemapplication.services;

import org.springframework.stereotype.Service;

@Service
public interface NoteService {
    String AddNote(long prisonerId, String text);
    String RemoveNote(long noteId);
    String UpdateNote(String note);
}
