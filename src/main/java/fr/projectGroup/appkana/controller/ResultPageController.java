/**
 * This class is the JavaFX controller of the 'result' page of the application.
 *
 * @author FlorianLopitaux
 */

package fr.projectGroup.appkana.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ResultPageController extends VBox implements JavaFXControllable {
    // FIELDS
    private final Stage primaryStage;
    private final int nbKanaToGuess;
    private final boolean isHiraganaChecked, isKatakanaChecked;

    @FXML
    Label textResult;
    @FXML
    Label msgReward;


    // CONSTRUCTOR
    /**
     * The constructor of the
     *
     * @param primaryStage
     * @param playerScore
     * @param nbKanaToGuess
     * @param isHiraganaChecked
     * @param isKatakanaChecked
     */
    public ResultPageController(Stage primaryStage, int playerScore, int nbKanaToGuess, boolean isHiraganaChecked, boolean isKatakanaChecked) {
        this.primaryStage = primaryStage;
        this.nbKanaToGuess = nbKanaToGuess;
        this.isHiraganaChecked = isHiraganaChecked;
        this.isKatakanaChecked = isKatakanaChecked;

        final double percentage = Math.round(((float)playerScore / nbKanaToGuess) * 100);

        this.loadFXMLFile("Result");

        this.textResult.setText("Votre score : " + playerScore + " / " + nbKanaToGuess + "\n(" + percentage + "%)");

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
    @FXML
    private void initialize() {
        Image bgImage = new Image(String.valueOf(getClass().getResource("/fr/projectGroup/appkana/img/bg_appkana.png")));
        this.setBackground(new Background(new BackgroundImage(bgImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
    }

    @FXML
    private void onReturnHomeButtonClick() {
        Scene homeScene = new Scene(new HomePageController(this.primaryStage));
        this.linkSceneWithCSSFile(homeScene, "Home");

        this.primaryStage.setScene(homeScene);
    }

    @FXML
    private void onRetryButtonClick() {
        Scene retryGameScene = new Scene(new GamePageController(this.primaryStage, this.nbKanaToGuess, this.isHiraganaChecked, this.isKatakanaChecked));
        this.linkSceneWithCSSFile(retryGameScene, "Game");

        this.primaryStage.setScene(retryGameScene);
    }
}
