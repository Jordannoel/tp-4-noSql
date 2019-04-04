package com.epsi.guez.tp4nosql.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class Note implements Serializable {

    private String id;
    private String contenu;
    private String auteur;
    private String dateCreation;

    public Note(String id, String contenu, String infosAuteur) {
        this.id = id;
        this.contenu = contenu;
        this.auteur = infosAuteur;
        this.dateCreation = makeDateCreation();
    }

    private String makeDateCreation() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
