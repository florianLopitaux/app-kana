package fr.projectGroup.appkana.test;

import fr.projectGroup.appkana.Core.JapaneseSyllable;
import fr.projectGroup.appkana.Core.Kana;
import fr.projectGroup.appkana.Core.KanaType;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class KanaTest {
    @Test
    public void testInstantiation() {
        Assertions.assertDoesNotThrow(() -> new Kana(KanaType.HIRAGANA, JapaneseSyllable.E));
        Assertions.assertDoesNotThrow(() -> new Kana(KanaType.KATAKANA, JapaneseSyllable.CHI));
    }

    @Test
    public void testGetters() {
        final Kana kana = new Kana(KanaType.HIRAGANA, JapaneseSyllable.FU);

        Assertions.assertEquals(kana.getKanaType(), KanaType.HIRAGANA);
        Assertions.assertEquals(kana.getSyllable(), JapaneseSyllable.FU);
    }

    @Test
    public void testToStringAndEquals() {
        final Kana kana = new Kana(KanaType.KATAKANA, JapaneseSyllable.MO);

        Assertions.assertEquals(kana.toString(), "Kana[syllable=MO, kanaType=KATAKANA]");
        Assertions.assertEquals(kana, new Kana(KanaType.KATAKANA, JapaneseSyllable.MO));
    }
}
