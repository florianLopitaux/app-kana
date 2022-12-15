package fr.projectGroup.appkana.Controller;

import fr.projectGroup.appkana.Core.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Timer;


/**
 * This class is the JavaFX controller of the 'game' page of the application.
 */
public class GamePageController extends VBox implements JavaFXControllable {
    // FIELDS
    private String playerName;

    private final Stage primaryStage;
    private final Set<GuessPane> guessPanesList;
    private final IntegerProperty playerScore;
    private final int nbKanaToGuess;
    private final boolean isHiraganaChecked, isKatakanaChecked;

    private final Timer timer;
    private final StopWatchTask stopWatchTask;

    @FXML
    Label scoreLabel;
    @FXML
    Label timerLabel;

    @FXML
    GridPane guessPaneContainer;


    // CONSTRUCTOR
    /**
     * The constructor of the GamePageController class.
     *
     * @param primaryStage the stage of the application launched.
     * @param nbKanaToGuess the number of kana to guess choose on the slider of the home page.
     * @param isHiraganaChecked the boolean value of the checkbox to know if we display hiragana characters.
     * @param isKatakanaChecked the boolean value of the checkbox to know if we display katakana characters.
     */
    public GamePageController(Stage primaryStage, int nbKanaToGuess, boolean isHiraganaChecked, boolean isKatakanaChecked) {
        this.primaryStage = primaryStage;
        this.guessPanesList = new HashSet<>();
        this.nbKanaToGuess = nbKanaToGuess;
        this.isHiraganaChecked = isHiraganaChecked;
        this.isKatakanaChecked = isKatakanaChecked;

        this.playerScore = new SimpleIntegerProperty(0);
        this.playerScore.addListener(event -> this.scoreLabel.setText("Score : " + this.playerScore.get() + " / " + this.nbKanaToGuess));

        this.loadFXMLFile("Game");

        this.stopWatchTask = new StopWatchTask(this.timerLabel);
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(stopWatchTask, 0, 1000);
    }


    // GETTERS
    /**
     * This method is the getter of guessPanesList attribute.
     *
     * @return the Set of all guess pane that the player has to guess.
     */
    public Set<GuessPane> getGuessPanesList() {
        return this.guessPanesList;
    }

    /**
     * This method is the getter of the playerScore attribute.
     *
     * @return the number of kana that the player correctly found.
     */
    public IntegerProperty getPlayerScore() {
        return this.playerScore;
    }


    // SETTER
    /**
     * This method is the setter of the playerName attribute.
     *
     * @param playerName the name of the player that he filled on the home page before.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    // METHODS
    /**
     * This method is called when the player finished to answer of all guess pane.
     * It switched the page and called the result page in passed all data of the game.
     */
    public void finishGame() {
        this.timer.cancel();

        final Scene resultScene = new Scene(new ResultPageController(primaryStage, this.playerScore.get(), this.nbKanaToGuess, this.isHiraganaChecked, this.isKatakanaChecked, this.stopWatchTask.getTime(), this.playerName));
        this.linkSceneWithCSSFile(resultScene, "Result");

        this.primaryStage.setScene(resultScene);
    }

    /**
     * This method is automatically called by JavaFX library and initialize or configure some things of the game page.
     */
    @FXML
    private void initialize() {
        this.scoreLabel.setText("Score : " + this.playerScore.get() + " / " + this.nbKanaToGuess);

        for (int row = 0; row < nbKanaToGuess / 6; ++row) {
            for (int column = 0; column < 6; ++column) {
                GuessPane guessPane = new GuessPane(this.generateNewKana(), this);
                this.guessPanesList.add(guessPane);
                this.guessPaneContainer.add(guessPane, column, row);
            }
        }

        for (int column = 0; column < nbKanaToGuess % 6; ++column) {
            GuessPane guessPane = new GuessPane(this.generateNewKana(), this);
            this.guessPanesList.add(guessPane);
            this.guessPaneContainer.add(guessPane, column, nbKanaToGuess / 6 + 1);
        }
    }

    /**
     * This method generate a new Kana object to build a guess pane on the initialize method to build the guess pane of the game.
     *
     * @return A new Kana object. Hiragana, katakana or both according to the checkbox selected.
     */
    private Kana generateNewKana() {
        Random rnd = new Random();
        KanaType currentKanaType = null;
        JapaneseSyllable currentJapaneseSyllable = JapaneseSyllable.values()[rnd.nextInt(46)];

        if (this.isHiraganaChecked && this.isKatakanaChecked) {
            switch (rnd.nextInt(2)) {
                case 0 -> currentKanaType = KanaType.HIRAGANA;
                case 1 -> currentKanaType = KanaType.KATAKANA;
            }
        } else if (this.isHiraganaChecked) {
            currentKanaType = KanaType.HIRAGANA;
        } else {
            currentKanaType = KanaType.KATAKANA;
        }

        return new Kana(currentKanaType, currentJapaneseSyllable);
    }
}
