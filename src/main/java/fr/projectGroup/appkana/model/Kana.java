/**
 * Class that implement a generic kana (hiragana and katakana).
 *
 * @author florianLopitaux
 */

package fr.projectGroup.appkana.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Kana {
    // FIELDS
    private final JapaneseSyllable syllable;
    private final KanaType kanaType;


    // CONSTRUCTOR

    /**
     * Constructor of the Kana class
     *
     * @param kanaType: the type of the kana instantiate.
     * @param syllable: the syllable of the kana instantiate.
     */
    public Kana(KanaType kanaType, JapaneseSyllable syllable) {
        this.kanaType = kanaType;
        this.syllable = syllable;
    }


    // GETTERS

    /**
     * The getter of 'kanatype' attribute.
     *
     * @return KanaType: the kana type (hiragana et katakan) of this object.
     */
    public KanaType getKanaType() {
        return this.kanaType;
    }

    /**
     * The getter of 'syllable' attribute.
     *
     * @return JapaneseSyllable: the syllable of this kana object.
     */
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

    /**
     * This method lets to get the image FXML object of the kana with correct kana type and syllable.
     *
     * @return ImageView: The image JavaFX object.
     */
    public ImageView getImage() {
        StringBuilder builder = new StringBuilder("/fr/projectGroup/appkana/img/");

        switch (this.kanaType) {
            case HIRAGANA -> builder.append("hiragana/hiragana_");
            case KATAKANA -> builder.append("katakana/katakana_");
        }

        builder.append(this.syllable.getRomanji()).append(".png");

        ImageView image = new ImageView(new Image(String.valueOf(getClass().getResource(builder.toString()))));
        image.setFitWidth(150);
        image.setFitHeight(150);

        return image;
    }
}
