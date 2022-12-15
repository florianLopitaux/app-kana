package fr.projectGroup.appkana.controller;

import fr.projectGroup.appkana.core.FileUtils;
import fr.projectGroup.appkana.core.PlayerScore;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * This class is the JavaFX controller of the 'result' page of the application.
 */
public class ResultPageController extends VBox implements JavaFXControllable {
    // FIELDS
    private final static int MAX_KANA_TO_GUESS = 92;
    private final Stage primaryStage;
    private final int nbKanaToGuess;
    private final boolean isHiraganaChecked, isKatakanaChecked;

    @FXML
    Label textResult;
    @FXML
    Label msgReward;


    // CONSTRUCTOR
    /**
     * The constructor of the ResultPageController class.
     *
     * @param primaryStage: The stage that corresponds to the window.
     * @param score: The score of the player that he does on the game.
     * @param nbKanaToGuess: The number of kana in the game page that the player had to guess.
     * @param isHiraganaChecked: if the player had enabled the hiragana.
     * @param isKatakanaChecked: if the player had enabled the katakana.
     * @param time: the time of the player in seconds.
     * @param playerName: The name of the player who played.
     */
    public ResultPageController(Stage primaryStage, int score, int nbKanaToGuess, boolean isHiraganaChecked, boolean isKatakanaChecked, int time, String playerName) {
        this.primaryStage = primaryStage;
        this.nbKanaToGuess = nbKanaToGuess;
        this.isHiraganaChecked = isHiraganaChecked;
        this.isKatakanaChecked = isKatakanaChecked;

        final double percentage = Math.round(((float)score / nbKanaToGuess) * 100);
        FileUtils.registerNewScore(new PlayerScore(playerName, this.computePlayerScore((double)score / nbKanaToGuess, time)));
        System.out.println(this.computePlayerScore((double)score / nbKanaToGuess, time));

        this.loadFXMLFile("Result");

        this.textResult.setText("Votre score : " + score + " / " + nbKanaToGuess + "\n(" + percentage + "%) en " + time + "s");

        if (percentage <= 25) {
            msgReward.setText("Tu n'es qu'au début de ton apprentissage :(");
        } else if (percentage <= 50) {
            msgReward.setText("Tu commences à y arriver mais il te reste beaucoup de progrès à faire");
        } else if (percentage <= 75) {
            msgReward.setText("Plutôt pas mal, tu n'as fait que quelques erreurs :)");
        } else {
            msgReward.setText("Super ! Tu es un pro des kana !");
        }
    }


    // METHODS
    /**
     * This method is automatically called by JavaFX library and initialize or configure some things of the result page.
     */
    @FXML
    private void initialize() {
        Image bgImage = new Image(String.valueOf(getClass().getResource("/fr/projectGroup/appkana/img/bg_appkana.png")));
        this.setBackground(new Background(new BackgroundImage(bgImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
    }

    /**
     * This method corresponding on the return home button function when it clicked which redirected to the home page.
     */
    @FXML
    private void onReturnHomeButtonClick() {
        Scene homeScene = new Scene(new HomePageController(this.primaryStage));
        this.linkSceneWithCSSFile(homeScene, "Home");

        this.primaryStage.setScene(homeScene);
    }

    /**
     * This method corresponding on the retry button function when it clicked which reload the game page with the same configuration.
     */
    @FXML
    private void onRetryButtonClick() {
        final Scene retryGameScene = new Scene(new GamePageController(this.primaryStage, this.nbKanaToGuess, this.isHiraganaChecked, this.isKatakanaChecked));
        this.linkSceneWithCSSFile(retryGameScene, "Game");

        this.primaryStage.setScene(retryGameScene);
    }

    /**
     * This method is the button function of the 'seeScoreRanking' button that uses to navigate on the Ranking page.
     */
    @FXML
    private void onSeeScoreRanking() {
        final Scene rankingPageScene = new Scene(new RankingPageController(this.primaryStage));
        this.linkSceneWithCSSFile(rankingPageScene, "Ranking");

        this.primaryStage.setScene(rankingPageScene);
    }

    /**
     * This method compute the final score of the player which take into account the time, the success percentage and the number of Kana to guess.
     *
     * @param percentage the success percentage on the format [0 ; 1].
     * @param time the time passed of the game.
     *
     * @return THe final score after compute with the custom mathematical formula
     */
    private double computePlayerScore(double percentage, int time) {
        return (double)Math.round((percentage * ((double)this.nbKanaToGuess / MAX_KANA_TO_GUESS) + 0.5/time) * 10000) / 100;
    }
}
