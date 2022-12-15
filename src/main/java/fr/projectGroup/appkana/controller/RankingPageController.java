package fr.projectGroup.appkana.controller;

import fr.projectGroup.appkana.core.FileUtils;
import fr.projectGroup.appkana.core.PlayerScore;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;

/**
 * This class is the JavaFX controller of the 'result' page of the application.
 */
public class RankingPageController extends AnchorPane implements JavaFXControllable {
    // FIELDS
    Stage primaryStage;

    @FXML
    private VBox rankingContainer;


    // CONSTRUCTOR
    /**
     * The constructor of the RankingPageController
     *
     * @param primaryStage the stage of the application to change the current scene.
     */
    public RankingPageController(Stage primaryStage) {
        this.primaryStage = primaryStage;

        this.loadFXMLFile("Ranking");
    }


    // METHODS
    /**
     * This method is automatically called by JavaFX library and initialize or configure some things of the ranking page.
     */
    @FXML
    private void initialize() {
        Image bgImage = new Image(String.valueOf(getClass().getResource("/fr/projectGroup/appkana/img/bg_appkana.png")));
        this.setBackground(new Background(new BackgroundImage(bgImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));

        this.generateAllScore();
    }

    /**
     * This method is the button function of the 'BackHome' button to navigate to the Home page.
     */
    @FXML
    private void onBackHome() {
        final Scene homeScene = new Scene(new HomePageController(this.primaryStage));
        this.linkSceneWithCSSFile(homeScene, "Home");

        this.primaryStage.setScene(homeScene);
    }

    /**
     * This method generate the 10 best score registered and convert on Label to display on the page.
     * It called on the initialize method of this class.
     */
    private void generateAllScore() {
        final List<PlayerScore> playerScoreList = FileUtils.readAllScores();
        Collections.sort(playerScoreList);

        for (int i = 1; i <= 10; ++i) {
            final HBox container = new HBox();
            container.setAlignment(Pos.CENTER);
            container.spacingProperty().set(20);

            container.getChildren().add(new Label(String.valueOf(i)));
            container.getChildren().add(new Label(playerScoreList.get(playerScoreList.size() - i).getName()));
            container.getChildren().add(new Label(playerScoreList.get(playerScoreList.size() - i).getScore() + " pts"));

            this.rankingContainer.getChildren().add(container);
        }
    }
}
