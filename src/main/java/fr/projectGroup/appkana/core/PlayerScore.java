package fr.projectGroup.appkana.core;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PlayerScore implements Comparable<PlayerScore> {
    // FIELDS
    private String name;
    private double score;


    // CONSTURCTOR
    public PlayerScore(String name, double score) {
        this.name = name;
        this.score = score;
    }


    // GETTERS
    public String getName() {
        return this.name;
    }

    public double getScore() {
        return this.score;
    }


    // METHODS
    @Override
    public String toString() {
        return "PlayerScore[name=" + this.name + ", score=" + this.score + "]";
    }

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

    @Override
    public int compareTo(PlayerScore other) {
        return Double.compare(this.score, other.getScore());
    }

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
