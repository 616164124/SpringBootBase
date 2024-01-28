package com.mikael.bo;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private String id;
    private String tilte;
    private String auther;
    private String world_count;
    private String date;


    public Book(String id, String tilte, String auther, String world_count, String date) {
        this.id = id;
        this.tilte = tilte;
        this.auther = auther;
        this.world_count = world_count;
        this.date = date;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getWorld_count() {
        return world_count;
    }

    public void setWorld_count(String world_count) {
        this.world_count = world_count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitile(String tilte) {
        this.tilte=tilte;
    }

    public void setWord_count(String word_count) {
    this.world_count=world_count;
    }
}
