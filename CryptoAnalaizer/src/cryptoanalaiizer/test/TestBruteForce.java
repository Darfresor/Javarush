package cryptoanalaiizer.test;

import cryptoanalaiizer.model.Cipher;

import java.util.HashSet;

public class TestBruteForce {
    public static void main(String[] args) {

        HashSet<String> DICTIONARY = new HashSet<>();
        DICTIONARY.add("Это");
        DICTIONARY.add("он");
        DICTIONARY.add("тест");

        Cipher cipher = new Cipher();
        String result;
        String bestResult = "";
        int bestNumberOfMatches = 0;
        int numberOfMatches = 0;
        int finalkey = 0;
        for (int i = 0; i < 32; i++) {
            numberOfMatches = 0;
            result = cipher.decrypt("Яфр фжуф к рп струфрл!", i);
            String[] wordsinRelust = result.split("\\s+");
            for (String s : wordsinRelust) {
                if (DICTIONARY.contains(s)) {
                    System.out.printf("При работе с ключом = %d, слово \"%s\" найдено в словаре %n", i, s);
                    numberOfMatches++;
                }
            }
            if (numberOfMatches > bestNumberOfMatches) {
                bestNumberOfMatches = numberOfMatches;
                bestResult = result;
                finalkey = i;
            }
        }

        System.out.println("Наибольшое кол-во сопавдений = " + bestNumberOfMatches);
        System.out.println("При ключе  = " + finalkey);
        System.out.println(bestResult);


    }
}
