package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerLoader {

    private static ObservableList<Player> obsListPlayers;
    private ArrayList<Player> allPlayers;

    public PlayerLoader() {
        allPlayers = new ArrayList<>();
    }
    public void loadPlayers() {

        allPlayers.clear();

        try{
            FileReader fileReader = new FileReader("images/players.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                allPlayers.add(parseLine(line));
            }

            obsListPlayers = FXCollections.observableList(allPlayers);

        }catch (FileNotFoundException f){
            System.out.println("file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Player parseLine(String line){

        ArrayList<String> lineArrayList = new ArrayList<>(List.of(line.split(":")));
        Player p = new Player(lineArrayList.get(0), Integer.parseInt(lineArrayList.get(1)), lineArrayList.get(2));
        return p;
    }

    public ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }

    public ObservableList<Player> getObsListPlayers() {
        return obsListPlayers;
    }
}
