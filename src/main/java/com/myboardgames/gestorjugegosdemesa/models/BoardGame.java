/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myboardgames.gestorjugegosdemesa.models;

public class BoardGame {
    private String id;
    private String title;
    private String designer;
    private String category;
    private String playing_time;
    private String players;
    private String bgg_rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlaying_time() {
        return playing_time;
    }

    public void setPlaying_time(String playing_time) {
        this.playing_time = playing_time;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String getBgg_rating() {
        return bgg_rating;
    }

    public void setBgg_rating(String bgg_rating) {
        this.bgg_rating = bgg_rating;
    }
}
