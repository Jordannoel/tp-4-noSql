package com.epsi.guez.tp4nosql.controller;

import com.epsi.guez.tp4nosql.model.Note;
import com.epsi.guez.tp4nosql.service.NoteRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NotesController {

    private NoteRepository noteRepository;

    public NotesController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping(value = "/notes/{contenu}/{auteur}", method = RequestMethod.POST)
    public String postNote(@PathVariable(value = "contenu") String contenu,
                           @PathVariable(value = "auteur") String auteur) {
        String idNote = generateId();
        noteRepository.save(new Note(idNote, contenu, auteur));
        return noteRepository.findById(idNote).getId();
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Note> getNotes() {
        return noteRepository.findAll();
    }

    @RequestMapping(value = "/notes/{idNote}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Note getNote(@PathVariable(value = "idNote") String idNote) {
        return noteRepository.findById(idNote);
    }

    @RequestMapping(value = "/notes/{idNote}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable(value = "idNote") String idNote) {
        noteRepository.delete(idNote);
    }

    @RequestMapping(value = "/subscribe/{auteur}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Note> subscribe(@PathVariable(value = "auteur") String auteur) {
        return getNotesAuteur(auteur);
    }

    /**
     * Renvoie les notes faites par un auteur
     *
     * @param auteur Nom de l'auteur
     * @return Une Map de notes
     */

    private Map<String, Note> getNotesAuteur(String auteur) {
        Map<String, Note> noteMap = noteRepository.findAll();
        noteMap.entrySet().removeIf(entry -> !entry.getValue().getAuteur().equals(auteur));
        return noteMap;
    }

    /**
     * Récupère le dernier id créé + 1
     *
     * @return L'id de la note à créer
     */
    private String generateId() {
        int max = 0;
        Map<String, Note> noteMap = noteRepository.findAll();
        for (Map.Entry<String, Note> entry : noteMap.entrySet()) {
            int tmp = Integer.parseInt(entry.getValue().getId());
            if (tmp > max) {
                max = tmp;
            }
        }
        max++;
        return String.valueOf(max);
    }
}
