package fr.projectGroup.appkana.core;

import java.util.Objects;

/**
 * @param name FIELDS
 */
public record PlayerScore(String name, double score) {
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
}
