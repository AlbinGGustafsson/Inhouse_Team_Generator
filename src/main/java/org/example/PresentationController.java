package org.example;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.ArrayList;

public class PresentationController {

    private Team blueTeam;
    private Team redTeam;

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

    @FXML
    public void startPresentation(Team blueTeam, Team redTeam) {
        this.blueTeam = blueTeam;
        this.redTeam = redTeam;

        if (presentationStarted) {
            System.out.println("Presentation in progress");
            return;
        }
        presentationStarted = true;

        System.out.println("Presentation starting");


        Thread presentationThread = new Thread(new PresentationThread());
        presentationThread.start();

    }

    class PresentationThread implements Runnable {
        @Override
        public void run() {
            String musicFile = "images/test.mp3";
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();


            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
                int finalI1 = i;
                Platform.runLater(() -> {
                    presentationTeamLabel.setText("Blue team player " + (finalI1 + 1));
                    presentationTeamLabel.setTextFill(Color.BLUE);
                    presentationImageView.setImage(new Image(blueTeam.getTeam().get(finalI1).getUrl()));
                    presentationPlayerLabel.setText(blueTeam.getTeam().get(finalI1).getName());
                });
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
                int finalI = i;
                Platform.runLater(() -> {
                    presentationTeamLabel.setText("Red team player " + (finalI + 1));
                    presentationTeamLabel.setTextFill(Color.RED);
                    presentationImageView.setImage(new Image(redTeam.getTeam().get(finalI).getUrl()));
                    presentationPlayerLabel.setText(redTeam.getTeam().get(finalI).getName());
                });

            }
        }

    }

}
