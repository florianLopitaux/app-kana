package fr.projectGroup.appkana.test;

import fr.projectGroup.appkana.Core.JapaneseSyllable;
import fr.projectGroup.appkana.Core.KanaType;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EnumsTest {
    @Test
    public void testKanaTypeEnum() {
        Assertions.assertEquals(KanaType.values().length, 2);

        Assertions.assertNotNull(KanaType.HIRAGANA);
        Assertions.assertNotNull(KanaType.KATAKANA);
    }

    @Test
    public void testGettersJapaneseSyllableEnum() {
        Assertions.assertEquals(JapaneseSyllable.values().length, 46);

        Assertions.assertEquals(JapaneseSyllable.NI.getRomanji(), "ni");
        Assertions.assertEquals(JapaneseSyllable.U.getPosition(), 2);
    }
}
