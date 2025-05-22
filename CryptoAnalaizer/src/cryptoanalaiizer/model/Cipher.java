package cryptoanalaiizer.model;

import java.util.HashMap;
import java.util.HashSet;

public class Cipher {
    private char[] alphabet;
    private HashSet<Character> alphabetSet;
    private HashMap<Character, Integer> alphabetMap;

    public Cipher() {
        initAlphabet();
    }

    private void initAlphabet() {
        alphabet = DefaultRussianAlphabet.cyrillicValues();
        alphabetSet = DefaultRussianAlphabet.getAlphabetSet();
        alphabetMap = DefaultRussianAlphabet.getAlphabetMap();
    }

    public String encrypt(String text, int shift) {
        char[] inputChars = text.toCharArray();
        char[] encryptedChars = new char[inputChars.length];
        int originalPos = 0;
        int newPosition = 0;
        for (int i = 0; i < inputChars.length; i++) {
            if (alphabetSet.contains(inputChars[i])
                    || alphabetSet.contains(Character.toUpperCase(inputChars[i]))
            ) {
                originalPos = alphabetMap.get(Character.toUpperCase(inputChars[i]));
                newPosition = (originalPos + shift) % alphabet.length;
                if (!Character.isUpperCase(inputChars[i])) {
                    encryptedChars[i] = Character.toLowerCase(alphabet[newPosition]);
                } else {
                    encryptedChars[i] = alphabet[newPosition];
                }
            } else {
                encryptedChars[i] = inputChars[i];
            }
        }
        return new String(encryptedChars);
    }

    public String decrypt(String text, int shift) {
        char[] inputChars = text.toCharArray();
        char[] decryptedChars = new char[inputChars.length];
        int originalPos = 0;
        int newPosition = 0;
        for (int i = 0; i < inputChars.length; i++) {
            if (alphabetSet.contains(inputChars[i])
                    || alphabetSet.contains(Character.toUpperCase(inputChars[i]))
            ) {
                originalPos = alphabetMap.get(Character.toUpperCase(inputChars[i]));
                newPosition = (originalPos - shift + alphabet.length) % alphabet.length;
                if (!Character.isUpperCase(inputChars[i])) {
                    decryptedChars[i] = Character.toLowerCase(alphabet[newPosition]);
                } else {
                    decryptedChars[i] = alphabet[newPosition];
                }
            } else {
                decryptedChars[i] = inputChars[i];
            }
        }
        return new String(decryptedChars);
    }

    public char[] getAlphabet() {
        return alphabet;
    }
}
