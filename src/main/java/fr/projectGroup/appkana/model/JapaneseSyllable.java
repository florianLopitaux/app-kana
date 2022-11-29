/**
 * Enumerate which contains all japanese syllable with parameters (alphabetic order and syllable translate in romanji)
 *
 * @author nathanReboul
 */

package fr.projectGroup.appkana.model;

public enum JapaneseSyllable {
    // FIELDS
    A(0, "a"), I(1, "i"), U(2, "u"), E(3, "e"), O(4, "o"),
    KA(5, "ka"), KI(6, "ki"), KU(7, "ku"), KE(8, "ke"), KO(9, "ko"),
    SA(10, "sa"), SHI(11, "shi"), SU(12, "su"), SE(13, "se"), SO(14, "so"),
    TA(15, "ta"), CHI(16, "chi"), TSU(17, "tsu"), TE(18, "te"), TO(19, "to"),
    NA(20, "na"), NI(21, "ni"), NU(22, "nu"), NE(23, "ne"), NO(24, "no"),
    HA(25, "ha"), HI(26, "hi"), FU(27, "fu"), HE(28, "he"), HO(29, "ho"),
    MA(30, "ma"), MI(31, "mi"), MU(32, "mu"), ME(33, "me"), MO(34, "mo"),
    YA(35, "ya"), YU(36, "yu"), YO(37, "yo"),
    RA(38, "ra"), RI(39, "ri"), RU(40, "ru"), RE(42, "re"), RO(43, "ro"),
    WA(44, "wa"), WO(45, "wo"),
    N(46, "n");


    private final int position;
    private final String romanji;

    // CONSTRUCTOR
    private JapaneseSyllable(int position, String romanji) {
        this.position = position;
        this.romanji = romanji;
    }

    // GETTER
    /**
     * Getter of the 'position' attribute.
     * @return Integer: the position of syllable on the japanese alphabetic order (named 'Gojuuon')
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Getter of the 'romaji' attribute.
     * @return String: the syllable write in latin alphabet (named 'romanji')
     */
    public String getRomanji() {
        return this.romanji;
    }
}
