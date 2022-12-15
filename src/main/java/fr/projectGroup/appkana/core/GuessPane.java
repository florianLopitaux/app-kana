package fr.projectGroup.appkana.core;

import fr.projectGroup.appkana.controller.GamePageController;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.util.Iterator;


/**
 * This class that corresponds to the Vbox on the Game Page with the image of the kana and the text-field to the user answer.
 */
public class GuessPane extends VBox {
    // FIELDS
    private final Kana kana;
    private TextField textField;


    // CONSTRUCTOR
    /**
     * The constructor of the GuessPane class.
     *
     * @param kana: the kana to guess.
     * @param gamePageController: the JavaFX controller of the game page that the GuessPane is in.
     */
    public GuessPane(Kana kana, GamePageController gamePageController) {
        this.setId("GuessPane");
        this.kana = kana;

        this.buildWidget(gamePageController);
    }


    // GETTER
    /**
     * The getter of the 'textField' attribute.
     *
     * @return TextField: The textField where the user can write the syllable.
     */
    public TextField getTextField() {
        return this.textField;
    }


    // METHODS
    /**
     * This method create and set configuration of the widget inside the GuessPane (VBox).
     *
     * @param gamePageController: the JavaFX controller of the game page that the GuessPane is in.
     */
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

    /**
     * This method check if the user response to all guessPane to know if the game is finish.
     *
     * @param gamePageController: the JavaFX controller of the game page that the GuessPane is in.
     * @return boolean: true if the game is finish, false else.
     */
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
