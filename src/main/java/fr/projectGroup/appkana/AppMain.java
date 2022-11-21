package fr.projectGroup.appkana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class AppMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("HomePageView.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));

        stage.setTitle("Kana Training");
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
