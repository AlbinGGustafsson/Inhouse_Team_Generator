package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class PresentationController {

    private static Team blueTeam;
    private static Team redTeam;

    private static ArrayList<String> urls;

    private boolean presentationStarted;

    @FXML
    private ImageView presentationImageView;

    @FXML
    private Pane presentationPane;

    @FXML
    private Label presentationPlayerLabel;

    @FXML
    private Label presentationTeamLabel;

    public void sendTeamsForPresentation(Team blueTeam, Team redTeam) {
        this.blueTeam = blueTeam;
        this.redTeam = redTeam;

        if (presentationStarted) {
            System.out.println("Presentation in progress");
            return;
        }
        presentationStarted = true;

        System.out.println("Presentation starting");

        System.out.println(urls);

        presentationImageView.setImage(new Image(blueTeam.getTeam().get(0).getUrl()));
        //presentationImageView.setImage(new Image(urls.get(0)));


//        urls = new ArrayList<>();
//        for (Player p : blueTeam.getTeam()){
//            urls.add(p.getUrl());
//        }
//        for (Player p : redTeam.getTeam()){
//            urls.add(p.getUrl());
//        }
//        System.out.println(urls);

    }

    @FXML
    private void startPresentation(MouseEvent event) {



    }

}
