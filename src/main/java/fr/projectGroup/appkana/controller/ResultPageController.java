package fr.projectGroup.appkana.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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

        if (percentage <= 25) {
            msgReward.setText("Tu n'es qu'au début de ton apprentissage :(");
        } else if (percentage <= 50) {
            msgReward.setText("Tu commences à y arriver mais il te reste beaucoup de progrès à faire");
        } else if (percentage <= 75) {
            msgReward.setText("Plutôt pas mal, tu n'as fait que quelques erreurs :)");
        } else {
            msgReward.setText("Super ! Tu es un pro des kana !");
        }
    }


    // METHODS
    @FXML
    private void initialize() {
        Image bgImage = new Image(String.valueOf(getClass().getResource("/fr/projectGroup/appkana/img/bg_appkana.png")));
        this.setBackground(new Background(new BackgroundImage(bgImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
    }

    @FXML
    private void onReturnHomeButtonClick() {
        Scene homeScene = new Scene(new HomePageController(this.primaryStage));
        homeScene.getStylesheets().add(this.getClass().getResource("/fr/projectGroup/appkana/css/HomePageStyle.css").toExternalForm());

        this.primaryStage.setScene(homeScene);
    }

    @FXML
    private void onRetryButtonClick() {

    }
}
