package fr.projectGroup.appkana.core;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.TimerTask;

/**
 * This class is a task that we give of a Timer Thread to count the time of the player on Game Page.
 */
public class StopWatchTask extends TimerTask {
    // FIELDS
    private final Label timerLabel;

    private int seconds;
    private int minutes;


    // CONSTRUCTOR

    /**
     * This constructor instantiates the task to initialize some attributes.
     *
     * @param timerLabel the Label of the Game page that display the timer.
     */
    public StopWatchTask(Label timerLabel) {
        this.timerLabel = timerLabel;

        this.seconds = 0;
        this.minutes = 0;
    }


    // METHODS

    /**
     * This method compute and return the total time passed in seconds.
     *
     * @return The total time passed in seconds.
     */
    public int getTime() {
        return this.minutes * 60 + this.seconds;
    }

    /**
     * This method is the run method inherited of the TimerTask class.
     * It counts everytime the time passed and update the label.
     */
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
