package fr.projectGroup.appkana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

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
    private Slider kanaCountSlider;
    @FXML
    private Label kanaCountLabel;

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

        this.dakutenCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                this.kanaCountSlider.setMax(this.kanaCountSlider.getMax() + 25);
            } else {
                this.kanaCountSlider.setMax(this.kanaCountSlider.getMax() - 25);
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

        System.out.println("Launch game !");
    }

    private void changeMaxSlider(boolean isChecked) {
        if (isChecked) {
            this.kanaCountSlider.setMax(this.kanaCountSlider.getMax() + 46);
        } else {
            this.kanaCountSlider.setMax(this.kanaCountSlider.getMax() - 46);
        }
    }
}
