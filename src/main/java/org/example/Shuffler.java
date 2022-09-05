package org.example;

import javafx.util.Pair;

import java.util.*;

public class Shuffler {
    private ArrayList<Player> players;
    private Pair<Team, Team> teams;

    public Shuffler(ArrayList<Player> players) {
        this.players = players;
    }

    public void normalScramble() {
        Collections.shuffle(players);
        teams = createTeams();
    }

    public void skillScramble(int maxSkillDifference) {

        if (maxSkillDifference <= 0){
            normalScramble();
            return;
        }

        while (true) {
            Collections.shuffle(players);
            teams = createTeams();

            int actualSkillDifference = Math.abs(teams.getValue().getTotalSkill() - teams.getKey().getTotalSkill());

            if (actualSkillDifference < maxSkillDifference) {
                System.out.println(String.format("Teams generated with skilldifference of %d", actualSkillDifference));
                break;
            }
        }

    }

    private Pair<Team, Team> createTeams() {

        ArrayList<Player> teamBlue = new ArrayList<>(players.subList(0, 5));
        ArrayList<Player> teamRed = new ArrayList<>(players.subList(5, 10));
        Team blueTeam = new Team(teamBlue, TeamType.BLUE);
        Team redTeam = new Team(teamRed, TeamType.RED);

        return new Pair<>(blueTeam, redTeam);
    }

    public Pair<Team, Team> getTeams() {
        return teams;
    }

    public Team getBlueTeam(){
        return teams.getKey();
    }

    public Team getRedTeam(){
        return teams.getValue();
    }

}
