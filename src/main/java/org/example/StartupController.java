package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

    private Stage stage;
    private Scene scene;
    private Parent root;

    public StartupController() {
    }

    @FXML
    void createTeams(ActionEvent event) {

        try {
            playersInInHouse.clear();
            createPlayersFromChoices();

            int maxSkillDiff = Integer.parseInt(skillDiffInput.getText());

            Shuffler shuffler = new Shuffler(playersInInHouse);
            shuffler.skillScramble(maxSkillDiff);

            Team blueTeam = shuffler.getBlueTeam();
            Team redTeam = shuffler.getRedTeam();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, blueTeam.toString() + "\n" + redTeam.toString());
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("presentation.fxml"));
            Parent root = loader.load();
            PresentationController presentationController = loader.getController();
            presentationController.sendTeamsForPresentation(blueTeam, redTeam);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Presentation");
            stage.show();

//            App.setRoot("presentation");
//            App.stage.sizeToScene();


        } catch (IOException e) {
            e.printStackTrace();
        }

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
