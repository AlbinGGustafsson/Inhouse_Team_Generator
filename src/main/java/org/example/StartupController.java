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

    @FXML
    public void initialize() {
        loadPlayers();
    }

    @FXML
    void createTeams(ActionEvent event) {

        try {
            playersInInHouse.clear();
            createPlayersFromChoices();

            //kontrollerar så att playersInInHouse inte innehåller null
            if (playersInInHouse.contains(null)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Not 10 players selected");
                alert.showAndWait();
                return;
            }

            //kontrollerar om det finns duplicates i playersInInHouse
            for (int i = 0; i < playersInInHouse.size(); i++) {
                for (int j = i + 1; j < playersInInHouse.size(); j++) {
                    if (playersInInHouse.get(i).equals(playersInInHouse.get(j))) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Duplicate players selected");
                        alert.showAndWait();
                        return;
                    }
                }
            }

            int maxSkillDiff = Integer.parseInt(skillDiffInput.getText());
            Shuffler shuffler = new Shuffler(playersInInHouse);
            shuffler.skillScramble(maxSkillDiff);

            Team blueTeam = shuffler.getBlueTeam();
            Team redTeam = shuffler.getRedTeam();

//            Alert alert = new Alert(Alert.AlertType.INFORMATION, blueTeam.toString() + "\n" + redTeam.toString());
//            alert.showAndWait();

            //laddar in presentation.fxml och instansierar ett instans av controllern.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("presentation.fxml"));
            Parent root = loader.load();
            PresentationController presentationController = loader.getController();
            presentationController.startPresentation(blueTeam, redTeam);

            //close stage derived from the event
//            Node source = (Node)event.getSource();
//            Stage currentStage = (Stage)source.getScene().getWindow();
//            currentStage.close();

            //skapar en ny stage/scene lägger in presentation.fxml på scenen och laddar in css filen på scenen och visar stagen.
            Stage presentationStage = new Stage();
            Scene presentationScene = new Scene(root);
            presentationScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            presentationStage.setScene(presentationScene);
            presentationStage.setTitle("Presentation");
            presentationStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void loadPlayers(ActionEvent event) {
        TextToSpeech textToSpeech = new TextToSpeech();
        textToSpeech.test();

        loadPlayers();
    }

    private void loadPlayers() {
        playerLoader.loadPlayers();

        ArrayList<ComboBox> comboBoxes = new ArrayList<>();

        for(Node n : startupPane.getChildren()){
            if (n instanceof ComboBox c){
                comboBoxes.add(c);
                c.setItems(playerLoader.getObsListPlayers());
            }
        }

//        comboBox1.setItems(playerLoader.getObsListPlayers());
//        comboBox2.setItems(playerLoader.getObsListPlayers());
//        comboBox3.setItems(playerLoader.getObsListPlayers());
//        comboBox4.setItems(playerLoader.getObsListPlayers());
//        comboBox5.setItems(playerLoader.getObsListPlayers());
//        comboBox6.setItems(playerLoader.getObsListPlayers());
//        comboBox7.setItems(playerLoader.getObsListPlayers());
//        comboBox8.setItems(playerLoader.getObsListPlayers());
//        comboBox9.setItems(playerLoader.getObsListPlayers());
//        comboBox10.setItems(playerLoader.getObsListPlayers());

        //lägger in 10 första autoamtiskt(för testning)
        for (int i = 0; i < comboBoxes.size(); i++){
            comboBoxes.get(i).setValue(playerLoader.getObsListPlayers().get(i));
        }

        //utskrift för vad som laddats in från filen
        System.out.println(playerLoader.getObsListPlayers() + " loaded from file");
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
