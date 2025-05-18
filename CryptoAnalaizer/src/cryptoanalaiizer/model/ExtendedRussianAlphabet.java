package cryptoanalaiizer.model;

public enum ExtendedRussianAlphabet {
    A('А', 1),
    BE('Б', 2),
    VE('В', 3),
    GE('Г', 4),
    DE('Д', 5),
    YE('Е', 6),
    YO('Ё', 7),
    ZHE('Ж', 8),
    ZE('З', 9),
    I('И', 10),
    SHORT_I('Й', 11),
    KA('К', 12),
    EL('Л', 13),
    EM('М', 14),
    EN('Н', 15),
    O('О', 16),
    PE('П', 17),
    ER('Р', 18),
    ES('С', 19),
    TE('Т', 20),
    U('У', 21),
    EF('Ф', 22),
    HA('Х', 23),
    TSE('Ц', 24),
    CHE('Ч', 25),
    SHA('Ш', 26),
    SHCHA('Щ', 27),
    HARD_SIGN('Ъ', 28),
    YERU('Ы', 29),
    SOFT_SIGN('Ь', 30),
    EH('Э', 31),
    YU('Ю', 32),
    YA('Я', 33),
    DOT('.',34),
    COMMA(',',35),
    LEFT_GUILLEMET('«',36),
    RIGHT_GUILLEMET('»',37),
    DOUBLE_QUOTE('"',38),
    SINGLE_QUOTE('\'',39),
    COLON(':',40),
    EXCLAMATION('!',41),
    QUESTION('?',42),
    SPACE(' ',43);
    private final char cyrillicChar;
    private final int position;

    ExtendedRussianAlphabet(char cyrillicChar, int position) {
        this.cyrillicChar = cyrillicChar;
        this.position = position;
    }

    public char getCyrillicChar() {
        return cyrillicChar;
    }

    public int getPosition() {
        return position;
    }

    public static char[] cyrillicValues() {
        char[] cyrillicArray = new char[ExtendedRussianAlphabet.values().length];
        int num = 0;
        for (var letter : ExtendedRussianAlphabet.values()) {
            cyrillicArray[num] = letter.getCyrillicChar();
            num++;
        }
        return cyrillicArray;
    }
}
