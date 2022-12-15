package fr.projectGroup.appkana.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * This interface contains some default methods that use by all JavaFX controller class.
 */
public interface JavaFXControllable {

    /**
     * This method load the FXML file associated to the page that we want loading.
     *
     * @param pageName: the name of the page (to find the fxml file) that we want load.
     * @throws RuntimeException: exception called when the method load of the FXMLLoader object crashed.
     */
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

    /**
     * This method link the css file corresponding with the page to the scene.
     *
     * @param scene: The scene which contains the page displaying.
     * @param pageName: the name of the page (to find the css file) that we want link.
     */
    default void linkSceneWithCSSFile(Scene scene, String pageName) {
        scene.getStylesheets().add(this.getClass().getResource("/fr/projectGroup/appkana/css/" + pageName + "PageStyle.css").toExternalForm());
    }
}
