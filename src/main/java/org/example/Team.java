package org.example;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Team {
    TeamType teamType;
    private ArrayList<Player> team;

    public Team(ArrayList<Player> team, TeamType teamType) {
        this.team = team;
        this.teamType = teamType;
    }

    public int getTotalSkill() {

        int totalSkill = 0;
        for (Player p : team) {
            totalSkill += p.getSkill();
        }
        return totalSkill;
    }

    public ArrayList<Player> getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return team.toString();
    }
}
