package com.epsi.guez.tp4nosql.service;

import com.epsi.guez.tp4nosql.model.Note;

import java.util.Map;

public interface NoteRepository {
    /**
     * Sauvegarde une note
     *
     * @param note La note à sauvegarder
     */
    void save(Note note);

    /**
     * Retourne toutes les notes
     *
     * @return une Map de notes
     */
    Map<String, Note> findAll();

    /**
     * Retourne une note en particulier
     *
     * @param id L'id de la note à retourner
     * @return Une Note
     */
    Note findById(String id);

    /**
     * Supprime une note
     *
     * @param id L'id de la note à supprimer
     */
    void delete(String id);
}