package fr.projectGroup.appkana;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class HomePageController {
    // FIELDS
    @FXML
    private CheckBox hiraganaCheckBox;

    @FXML
    private CheckBox katakanaCheckBox;

    @FXML
    private CheckBox dakutenCheckBox;


    // METHODS
    @FXML
    protected void onStartGameButtonClick() {
        System.out.println("click on button !");
    }
}
