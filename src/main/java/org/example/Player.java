package org.example;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Player {

    private String name;
    private int skill;
    private String url;

    public Player(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }

    public Player(String name, int skill, String url) {
        this.name = name;
        this.skill = skill;
        this.url = url;

    }

    public String getName() {
        return name;
    }

    public int getSkill() {
        return skill;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public String getUrl() {
        return "file:" + url;
    }

    @Override
    public String toString() {
        return name + " " + skill;
        //return String.format("Name: %s Skill: %d", name, skill);
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Player p){
            return this.name == p.getName();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
