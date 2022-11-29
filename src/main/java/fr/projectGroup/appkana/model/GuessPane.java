package fr.projectGroup.appkana.model;

import fr.projectGroup.appkana.controller.GamePageController;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.util.Iterator;


public class GuessPane extends VBox {
    // FIELDS
    private final Kana kana;
    private TextField textField;


    // CONSTRUCTOR
    public GuessPane(Kana kana, GamePageController gamePageController) {
        this.setId("GuessPane");
        this.kana = kana;

        this.buildWidget(gamePageController);
    }


    // GETTER
    public TextField getTextField() {
        return this.textField;
    }


    // METHODS
    private void buildWidget(GamePageController gamePageController) {
        this.getChildren().add(this.kana.getImage());

        this.textField = new TextField();
        this.textField.setOnKeyPressed(event -> {
            if (!(event.getCode() == KeyCode.ENTER)) {
                return;
            }

            if (kana.getSyllable().getRomanji().equalsIgnoreCase(this.textField.getText())) {
                gamePageController.getPlayerScore().setValue(gamePageController.getPlayerScore().get() + 1);
                this.textField.setStyle("-fx-background-color: #06f606; -fx-highlight-text-fill: white");

            } else {
                this.textField.setStyle("-fx-background-color: red; -fx-text-fill: white");
            }

            this.textField.setDisable(true);
            if (this.isGameFinished(gamePageController)) {
                gamePageController.finishGame();
            }
        });

        this.getChildren().add(this.textField);
    }

    private boolean isGameFinished(GamePageController gamePageController) {
        Iterator<GuessPane> itGuessPane = gamePageController.getGuessPanesList().iterator();

        while (itGuessPane.hasNext()) {
            final GuessPane currentGuessPane = itGuessPane.next();

            if (!currentGuessPane.getTextField().isDisable()) {
                return false;
            }
        }

        return true;
    }
}
