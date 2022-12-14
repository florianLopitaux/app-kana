package fr.projectGroup.appkana.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RankingPageController extends VBox implements JavaFXControllable {
    // FIELDS
    Stage primaryStage;

    @FXML
    private VBox rankingContainer;


    // CONSTRUCTOR
    public RankingPageController(Stage primaryStage) {
        this.primaryStage = primaryStage;

        this.loadFXMLFile("Ranking");
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
}
