package fr.projectGroup.appkana;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class AppMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Kana Training");
        stage.setResizable(true);

        Scene scene = new Scene(new HomePageController());
        scene.getStylesheets().add(this.getClass().getResource("/fr/projectGroup/appkana/css/HomePageStyle.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
