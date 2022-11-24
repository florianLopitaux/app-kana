package fr.projectGroup.appkana.model;

public enum JapaneseSyllable {
    // FIELDS
    A(0), I(1), U(2), E(3), O(4),
    KA(5), KI(6), KU(7), KE(8), KO(9),
    SA(10), SHI(11), SU(12), SE(13), SO(14),
    TA(15), CHI(16), TSU(17), TE(18), TO(19),
    NA(20), NI(21), NU(22), NE(23), NO(24),
    HA(25), HI(26), FU(27), HE(28), HO(29),
    MA(30), MI(31), MU(32), ME(33), MO(34),
    YA(35), YU(36), YO(37),
    RA(38), RI(39), RU(40), RE(42), RO(43),
    WA(44), WO(45),
    N(46);


    private final int position;

    // CONSTRUCTOR
    private JapaneseSyllable(int position) {
        this.position = position;
    }

    // GETTER
    public int getPosition() {
        return this.position;
    }
}
