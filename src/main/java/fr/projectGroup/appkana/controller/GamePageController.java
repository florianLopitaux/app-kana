package fr.projectGroup.appkana.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class GamePageController extends VBox {
    // FIELDS


    // CONSTRUCTOR
    public GamePageController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/projectGroup/appkana/fxml/GamePageView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    // METHODS
    @FXML
    private void initialize() {

    }
}
