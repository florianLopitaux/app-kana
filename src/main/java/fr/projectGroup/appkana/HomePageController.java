package fr.projectGroup.appkana;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class HomePageController {
    // FIELDS
    @FXML
    private CheckBox hiraganaCheckBox;

    @FXML
    private CheckBox katakanaCheckBox;

    @FXML
    private CheckBox dakutenCheckBox;

    @FXML
    private Label errorButtonMessage;


    // METHODS
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
