package fr.projectGroup.appkana.model;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class GuessPane extends VBox {
    // FIELDS
    private final Kana kana;
    private TextField textField;


    // CONSTRUCTOR
    public GuessPane(Kana kana) {
        this.setId("GuessPane");
        this.setAlignment(Pos.CENTER);

        this.kana = kana;

        this.buildWidget();
    }


    // METHODS
    private void buildWidget() {
        this.getChildren().add(this.kana.getImage());

        this.textField = new TextField();
        this.textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (kana.getSyllable().getRomanji().equalsIgnoreCase(this.textField.getText())) {
                    System.out.println("bien joué");
                } else {
                    System.out.println("pas bien joué");
                }
            }
        });

        this.getChildren().add(this.textField);
    }
}
