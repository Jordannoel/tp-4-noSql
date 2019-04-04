package com.epsi.guez.tp4nosql.service;

import com.epsi.guez.tp4nosql.model.Note;

import java.util.Map;

public interface NoteRepository {
    void save(Note note);

    Map<String, Note> findAll();

    Note findById(String id);

    void delete(String id);
}