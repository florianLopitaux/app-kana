package fr.projectGroup.appkana.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultPageController extends VBox {
    // FIELDS
    private final Stage primaryStage;

    @FXML
    Label textResult;
    @FXML
    Label msgReward;

    @FXML
    Button returnButton;
    @FXML
    Button retryButton;


    // CONSTRUCTOR
    public ResultPageController(Stage primaryStage, int playerScore, int nbKanaToGuess) {
        this.primaryStage = primaryStage;
        final double percentage = ((float)playerScore / nbKanaToGuess) * 100;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/projectGroup/appkana/fxml/ResultPageView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.textResult.setText("Votre score : " + playerScore + " / " + nbKanaToGuess + "\n(" + percentage + "%)");
    }


    // METHODS
    @FXML
    private void initialize() {

    }
}
