package fr.projectGroup.appkana.core;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.TimerTask;

public class StopWatchTask extends TimerTask {
    // FIELDS
    private final Label timerLabel;

    private int seconds;
    private int minutes;


    // CONSTRUCTOR
    public StopWatchTask(Label timerLabel) {
        this.timerLabel = timerLabel;

        this.seconds = 0;
        this.minutes = 0;
    }


    @Override
    public void run() {
        this.seconds++;

        if (this.seconds >= 60) {
            this.minutes++;
            this.seconds = 0;
        }

        Platform.runLater(() -> {
            this.timerLabel.setText(this.minutes + "m " + this.seconds + "s");
        });
    }
}
