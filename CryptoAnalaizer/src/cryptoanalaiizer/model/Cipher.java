package cryptoanalaiizer.model;

public class Cipher {
    private char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }
//TODO стоит использовать вместо массива hashMap, чтобы ускорить поиск и не перебирать каждый раз по 30 строк?
    //По идее тут решается проблема значений, так как ключи а и А будут разные, но значения у обоих может быть 1.
    public String encrypt(String text, int shift) {
        String alphabetStr = new String(alphabet);
        char[] inputChars = text.toCharArray();
        char[] encryptedChars = new char[inputChars.length];
        int originalPos = 0;
        int newPosition = 0;
        for (int i = 0; i < inputChars.length; i++){
            boolean isFindCharInAlphabet = false;
            originalPos = alphabetStr.indexOf(inputChars[i]);
            if(originalPos!=-1) {
                newPosition = (originalPos + shift) % alphabet.length;
                encryptedChars[i] = alphabet[newPosition];
                continue;
            };
            originalPos = alphabetStr.indexOf(Character.toUpperCase(inputChars[i]));
            if(originalPos!=-1){
                newPosition = (originalPos + shift) % alphabet.length;
                encryptedChars[i] = Character.toLowerCase(alphabet[newPosition]);
                isFindCharInAlphabet = true;
            }
            if (!isFindCharInAlphabet) {
                encryptedChars[i] = inputChars[i];
            }
        }
        return new String(encryptedChars);
    }

    ;

    public String decrypt(String encryptedText, int shift) {
        String alphabetStr = new String(alphabet);
        char[] inputChars = encryptedText.toCharArray();
        char[] decryptedChars = new char[inputChars.length];
        int originalPos = 0;
        int newPosition = 0;
        for (int i = 0; i < inputChars.length; i++){
            boolean isFindCharInAlphabet = false;
            originalPos = alphabetStr.indexOf(inputChars[i]);
            if(originalPos!=-1) {
                newPosition = (originalPos - shift+alphabet.length) % alphabet.length;
                decryptedChars[i] = alphabet[newPosition];
                continue;
            };
            originalPos = alphabetStr.indexOf(Character.toUpperCase(inputChars[i]));
            if(originalPos!=-1){
                newPosition = (originalPos - shift+alphabet.length) % alphabet.length;
                decryptedChars[i] = Character.toLowerCase(alphabet[newPosition]);
                isFindCharInAlphabet = true;
            }
            if (!isFindCharInAlphabet) {
                decryptedChars[i] = inputChars[i];
            }
        }
        return new String(decryptedChars);
    }

    ;

    /*
    public String brut(String text, int shift) {
        char[] inputChars = text.toCharArray();
        char[] encryptedChars = new char[inputChars.length];
        boolean isFindCharInAlphabet = false;
        for (int i = 0; i < inputChars.length; i++) {
            isFindCharInAlphabet = false;
            for (int j = 0; j < alphabet.length-1; j++) {
                if (inputChars[i] == Character.toLowerCase(alphabet[j])) {
                    encryptedChars[i] = Character.toLowerCase(alphabet[j + shift]);
                    isFindCharInAlphabet = true;
                    break;
                }
                ;
                if (inputChars[i] == alphabet[j]) {
                    encryptedChars[i] = alphabet[j + shift];
                    isFindCharInAlphabet = true;
                    break;
                }
                ;

            }
            ;
            if (!isFindCharInAlphabet) {
                encryptedChars[i] = inputChars[i];
            }
        }
        return new String(encryptedChars);
    }
    */


    public char[] getAlphabet() {
        return alphabet;
    }
}
