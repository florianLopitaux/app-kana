package fr.projectGroup.appkana.Core;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * This class stored the final score and data of a player during a game.
 */
public class PlayerScore implements Comparable<PlayerScore> {
    // FIELDS
    private String name;
    private double score;


    // CONSTRUCTOR
    /**
     * This constructor instantiates the data of the player game.
     *
     * @param name
     * @param score
     */
    public PlayerScore(String name, double score) {
        this.name = name;
        this.score = score;
    }


    // GETTERS

    /**
     * This method is the getter of the name attribute.
     *
     * @return the name of the player that he filled of the start of the game on the home page.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method is the getter of the score attribute.
     *
     * @return the final score of the game compute with the result page controller method.
     */
    public double getScore() {
        return this.score;
    }


    // METHODS
    /**
     * This method is the toString method inherited of the Object class.
     *
     * @return The String representation of the object.
     */
    @Override
    public String toString() {
        return "PlayerScore[name=" + this.name + ", score=" + this.score + "]";
    }

    /**
     * This method is the equals method inherited of the Object class.
     *
     * @param o the other object that we want check with the actual instantiation.
     * @return true if the same object or false else.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final PlayerScore other = (PlayerScore) o;
        return Double.compare(other.score, this.score) == 0 && Objects.equals(this.name, other.name);
    }

    /**
     * This method is the compareTo method inherited of the Comparable interface.
     *
     * @param other the object to be compared.
     * @return the comparison of the two scores of the objects.
     */
    @Override
    public int compareTo(PlayerScore other) {
        return Double.compare(this.score, other.getScore());
    }

    /**
     * This static method is an implementation of bubble sort to a List of PlayerScore object.
     *
     * @param playerScoreList The list that we want sorted.
     */
    public static void BubbleSort(List<PlayerScore> playerScoreList) {
        for (int i = 0; i < playerScoreList.size(); ++i) {
            for (int j = 0; j < playerScoreList.size() - i - 1; ++j) {
                if (playerScoreList.get(j).getScore() > playerScoreList.get(j + 1).getScore()) {
                    Collections.swap(playerScoreList, j, j + 1);
                }
            }
        }
    }
}
