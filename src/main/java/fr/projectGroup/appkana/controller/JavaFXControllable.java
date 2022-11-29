package fr.projectGroup.appkana.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public interface JavaFXControllable {
    default void loadFXMLFile(String pageName) throws RuntimeException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/projectGroup/appkana/fxml/" + pageName + "PageView.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    };

    default void linkSceneWithCSSFile(Scene scene, String pageName) {
        scene.getStylesheets().add(this.getClass().getResource("/fr/projectGroup/appkana/css/" + pageName + "PageStyle.css").toExternalForm());
    }
}
