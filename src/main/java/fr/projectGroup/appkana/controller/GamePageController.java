package fr.projectGroup.appkana.controller;

import fr.projectGroup.appkana.model.GuessPane;
import fr.projectGroup.appkana.model.JapaneseSyllable;
import fr.projectGroup.appkana.model.Kana;
import fr.projectGroup.appkana.model.KanaType;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Random;

public class GamePageController extends VBox {
    // FIELDS
    private final IntegerProperty playerScore;
    private final int nbKanaToGuess;
    private final boolean isHiraganaChecked, isKatakanaChecked;

    @FXML
    Label scoreLabel;

    @FXML
    GridPane guessPaneContainer;


    // CONSTRUCTOR
    public GamePageController(int nbKanaToGuess, boolean isHiraganaChecked, boolean isKatakanaChecked) {
        this.nbKanaToGuess = nbKanaToGuess;
        this.isHiraganaChecked = isHiraganaChecked;
        this.isKatakanaChecked = isKatakanaChecked;

        this.playerScore = new SimpleIntegerProperty(0);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/projectGroup/appkana/fxml/GamePageView.fxml"));
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
        this.scoreLabel.setText("Score : " + this.playerScore.get() + " / " + this.nbKanaToGuess);

        for (int row = 0; row < nbKanaToGuess / 6; ++row) {
            for (int column = 0; column < 6; ++column) {
                GuessPane guessPane = new GuessPane(this.generateNewKana());
                this.guessPaneContainer.add(guessPane, column, row);
            }
        }

        for (int column = 0; column < nbKanaToGuess % 6; ++column) {
            GuessPane guessPane = new GuessPane(this.generateNewKana());
            this.guessPaneContainer.add(guessPane, column, nbKanaToGuess / 6 + 1);
        }
    }

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
