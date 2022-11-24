package fr.projectGroup.appkana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HomePageController extends BorderPane {
    // FIELDS
    @FXML
    private CheckBox hiraganaCheckBox;

    @FXML
    private CheckBox katakanaCheckBox;

    @FXML
    private CheckBox dakutenCheckBox;

    @FXML
    private Label errorButtonMessage;


    // CONSTRUCTOR
    public HomePageController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/projectGroup/appkana/fxml/HomePageView.fxml"));

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

    @FXML
    protected void onStartGameButtonClick() {
        System.out.println("click on button !");

        if (!hiraganaCheckBox.isSelected() && !katakanaCheckBox.isSelected()) {
            errorButtonMessage.setText("You need to select at least hiragana or katakana characters");
            return;
        } else {
            errorButtonMessage.setText("");
        }

        System.out.println("Launch game !");
    }
}
