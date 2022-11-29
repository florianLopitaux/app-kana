package fr.projectGroup.appkana.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController extends BorderPane implements JavaFXControllable {
    // FIELDS
    private final Stage primaryStage;

    @FXML
    private CheckBox hiraganaCheckBox;
    @FXML
    private CheckBox katakanaCheckBox;

    @FXML
    private Slider kanaCountSlider;
    @FXML
    private Label kanaCountLabel;

    @FXML
    private Label errorButtonMessage;


    // CONSTRUCTOR
    public HomePageController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.loadFXMLFile("Home");
    }


    // METHODS
    @FXML
    private void initialize() {
        // Background image
        Image bgImage = new Image(String.valueOf(getClass().getResource("/fr/projectGroup/appkana/img/bg_appkana.png")));
        this.setBackground(new Background(new BackgroundImage(bgImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));

        BorderPane.setMargin(this.getTop(), new Insets(25, 0, 0, 0));

        // Slider configuration
        this.kanaCountSlider.valueProperty().addListener((observable, oldValue, newValue) -> this.kanaCountSlider.setValue(newValue.intValue()));
        this.kanaCountSlider.valueProperty().addListener((observable, oldValue, newValue) -> this.kanaCountLabel.setText(newValue.toString()));

        this.kanaCountSlider.setValue(10);
        this.hiraganaCheckBox.setSelected(true);

        // Checkbox listeners
        this.hiraganaCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (this.katakanaCheckBox.isSelected()) {
                changeMaxSlider(newValue);
            }
        });

        this.katakanaCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (this.hiraganaCheckBox.isSelected()) {
                changeMaxSlider(newValue);
            }
        });
    }

    @FXML
    private void onStartGameButtonClick() {
        System.out.println("click on button !");

        if (!hiraganaCheckBox.isSelected() && !katakanaCheckBox.isSelected()) {
            errorButtonMessage.setText("You need to select at least hiragana or katakana characters");
            return;
        } else {
            errorButtonMessage.setText("");
        }

        Scene gameScene = new Scene(new GamePageController(this.primaryStage, (int) this.kanaCountSlider.getValue(), this.hiraganaCheckBox.isSelected(), this.katakanaCheckBox.isSelected()));
        this.linkSceneWithCSSFile(gameScene, "Game");

        this.primaryStage.setScene(gameScene);
    }

    private void changeMaxSlider(boolean isChecked) {
        if (isChecked) {
            this.kanaCountSlider.setMax(this.kanaCountSlider.getMax() + 46);
        } else {
            this.kanaCountSlider.setMax(this.kanaCountSlider.getMax() - 46);
        }
    }
}
