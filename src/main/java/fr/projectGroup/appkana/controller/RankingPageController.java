package fr.projectGroup.appkana.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
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

    }
}
