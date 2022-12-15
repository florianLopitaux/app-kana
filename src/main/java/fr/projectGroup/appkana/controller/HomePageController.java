package fr.projectGroup.appkana.controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * This class is the JavaFX controller of the 'home' page of the application.
 */
public class HomePageController extends BorderPane implements JavaFXControllable {
    // FIELDS
    private final Stage primaryStage;

    @FXML
    private TextField playerNameTextField;

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

    /**
     * The constructor of the HomePageController class.
     *
     * @param primaryStage the stage of the application to change the current scene.
     */
    public HomePageController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.loadFXMLFile("Home");
    }


    // METHODS
    /**
     * This method is automatically called by JavaFX library and initialize or configure some things of the home page.
     */
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

    /**
     * This method is button function of the 'StartGame' button which launch the game with the correct configuration selected by the user.
     */
    @FXML
    private void onStartGameButtonClick() {
        System.out.println("click on button !");

        if (!hiraganaCheckBox.isSelected() && !katakanaCheckBox.isSelected()) {
            errorButtonMessage.setText("You need to select at least hiragana or katakana characters");
            return;
        } else {
            errorButtonMessage.setText("");
        }

        final GamePageController gamePageController = new GamePageController(this.primaryStage, (int) this.kanaCountSlider.getValue(), this.hiraganaCheckBox.isSelected(), this.katakanaCheckBox.isSelected());
        gamePageController.setPlayerName(this.playerNameTextField.getText());

        final Scene gameScene = new Scene(gamePageController);
        this.linkSceneWithCSSFile(gameScene, "Game");

        this.primaryStage.setScene(gameScene);
    }

    /**
     * This method is the method called to update the max value of the slider on the home page when we selected a checkbox.
     *
     * @param isChecked the boolean value to know if the checkbox event is an activation or a deselection.
     */
    private void changeMaxSlider(boolean isChecked) {
        if (isChecked) {
            this.kanaCountSlider.setMax(this.kanaCountSlider.getMax() + 46);
        } else {
            this.kanaCountSlider.setMax(this.kanaCountSlider.getMax() - 46);
        }
    }
}
