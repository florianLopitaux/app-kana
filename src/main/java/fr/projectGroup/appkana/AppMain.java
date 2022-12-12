package fr.projectGroup.appkana;

import fr.projectGroup.appkana.controller.HomePageController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AppMain extends Application {
    /**
     * This method is an override from the Application class of the JavaFX library.
     *
     * @param stage: The JavaFx stage object to set our elements on the window.
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Kana Training");
        stage.setResizable(false);

        Scene scene = new Scene(new HomePageController(stage));
        scene.getStylesheets().add(this.getClass().getResource("/fr/projectGroup/appkana/css/HomePageStyle.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    /**
     * This main method is used to launch the application when the AppMain is executed.
     *
     * @param args: the arguments passed of the executable.
     */
    public static void main(String[] args) {
        Application.launch();
    }
}
