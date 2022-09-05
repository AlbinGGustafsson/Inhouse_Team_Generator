package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class StartupController {

    private PlayerLoader playerLoader = new PlayerLoader();

    private ArrayList<Player> playersInInHouse = new ArrayList<>();

    @FXML
    private ComboBox<Player> comboBox1, comboBox2, comboBox3, comboBox4, comboBox5, comboBox6, comboBox7, comboBox8, comboBox9, comboBox10;

    @FXML
    private Button createTeamsButton;

    @FXML
    private Pane startupPane;

    @FXML
    private TextField skillDiffInput;

    @FXML
    private Button loadPlayersButton;

    @FXML
    private Label title;

    public StartupController() {
    }

    @FXML
    void createTeams(ActionEvent event) throws IOException {

        playersInInHouse.clear();
        createPlayersFromChoices();

        int maxSkillDiff = Integer.parseInt(skillDiffInput.getText());

        Shuffler shuffler = new Shuffler(playersInInHouse);
        shuffler.skillScramble(maxSkillDiff);

        Team blueTeam = shuffler.getBlueTeam();
        Team redTeam = shuffler.getRedTeam();

        Alert alert = new Alert(Alert.AlertType.INFORMATION, blueTeam.toString() + "\n" + redTeam.toString());
        alert.showAndWait();


//        PresentationController presentationController = new PresentationController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("presentation.fxml"));
        loader.load();
        PresentationController presentationController = loader.getController();
        presentationController.sendTeamsForPresentation(blueTeam, redTeam);


        App.setRoot("presentation");
        App.stage.sizeToScene();

    }

    @FXML
    void loadPlayers(ActionEvent event) {
        playerLoader.loadPlayers();

        comboBox1.setItems(playerLoader.getObsListPlayers());
        comboBox2.setItems(playerLoader.getObsListPlayers());
        comboBox3.setItems(playerLoader.getObsListPlayers());
        comboBox4.setItems(playerLoader.getObsListPlayers());
        comboBox5.setItems(playerLoader.getObsListPlayers());
        comboBox6.setItems(playerLoader.getObsListPlayers());
        comboBox7.setItems(playerLoader.getObsListPlayers());
        comboBox8.setItems(playerLoader.getObsListPlayers());
        comboBox9.setItems(playerLoader.getObsListPlayers());
        comboBox10.setItems(playerLoader.getObsListPlayers());

        System.out.println(playerLoader.getObsListPlayers());
    }

    private void createPlayersFromChoices() {
        playersInInHouse.add(comboBox1.getValue());
        playersInInHouse.add(comboBox2.getValue());
        playersInInHouse.add(comboBox3.getValue());
        playersInInHouse.add(comboBox4.getValue());
        playersInInHouse.add(comboBox5.getValue());
        playersInInHouse.add(comboBox6.getValue());
        playersInInHouse.add(comboBox7.getValue());
        playersInInHouse.add(comboBox8.getValue());
        playersInInHouse.add(comboBox9.getValue());
        playersInInHouse.add(comboBox10.getValue());
    }

}
