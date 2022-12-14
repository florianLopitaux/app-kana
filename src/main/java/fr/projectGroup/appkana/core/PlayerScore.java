package fr.projectGroup.appkana.core;

import java.util.Objects;

public class PlayerScore {
    // FIELDS
    private final String name;
    private final double score;


    // CONSTRUCTOR
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
    public int hashCode() {
        return Objects.hash(name, score);
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
}
