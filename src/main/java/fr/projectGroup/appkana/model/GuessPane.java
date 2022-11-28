package fr.projectGroup.appkana.model;

import fr.projectGroup.appkana.controller.GamePageController;
import javafx.beans.property.IntegerProperty;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.util.Set;

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
            } else {
                System.out.println("Mauvaise syllabe");
            }

            this.textField.setDisable(true);
            if (this.isGameFinished(gamePageController)) {
                gamePageController.finishGame();
            }
        });

        this.getChildren().add(this.textField);
    }

    private boolean isGameFinished(GamePageController gamePageController) {
        for (GuessPane currentGuessPane : gamePageController.getGuessPanesList()) {
            if (!currentGuessPane.getTextField().isDisable()) {
                return false;
            }
        }

        return true;
    }
}
