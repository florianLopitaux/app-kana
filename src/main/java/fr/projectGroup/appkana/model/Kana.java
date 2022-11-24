package fr.projectGroup.appkana.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Kana {
    // FIELDS
    private final JapaneseSyllable syllable;
    private final KanaType kanaType;


    // CONSTRUCTOR
    public Kana(KanaType kanaType, JapaneseSyllable syllable) {
        this.kanaType = kanaType;
        this.syllable = syllable;
    }


    // GETTER
    public KanaType getKanaType() {
        return this.kanaType;
    }

    public JapaneseSyllable getSyllable() {
        return this.syllable;
    }


    // METHODS

    @Override
    public String toString() {
        return "Kana[syllable=" + this.syllable + ", kanaType=" + kanaType + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(syllable, kanaType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Kana kana = (Kana) o;
        return this.syllable == kana.getSyllable() && this.kanaType == kana.getKanaType();
    }

    public ImageView getImage() {
        StringBuilder builder = new StringBuilder("/fr/projectGroup/appkana/img/");

        switch (this.kanaType) {
            case HIRAGANA -> builder.append("hiragana/");
            case KATAKANA -> builder.append("katakana/");
            case DAKUTEN -> builder.append("dakuten/");
        }

        builder.append(this.syllable.getRomanji()).append(".png");
        return new ImageView(new Image(String.valueOf(getClass().getResource(builder.toString()))));
    }
}
