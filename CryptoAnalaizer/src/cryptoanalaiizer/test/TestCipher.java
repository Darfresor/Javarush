package cryptoanalaiizer.test;

import cryptoanalaiizer.model.Cipher;
import cryptoanalaiizer.model.DefaultRussianAlphabet;

import java.util.Arrays;

public class TestCipher {
    public static void main(String[] args) {
        System.out.print("Базовый алфавит = ");
        System.out.println(Arrays.toString(DefaultRussianAlphabet.cyrillicValues()));
        System.out.print("Базовый алфавит  в HashSet= ");
        System.out.println(DefaultRussianAlphabet.getAlphabetSet());
        System.out.print("Базовый алфавит  в HashMap= ");
        System.out.println(DefaultRussianAlphabet.getAlphabetMap());

        Cipher cipher = new Cipher();
        System.out.println(cipher.getAlphabet());
        System.out.println("------------------------------");
        System.out.println("--Шифровка--");
        String forEncrypt ="АБВГ!";
        System.out.printf("Подаем текст: %n"+forEncrypt+"%n");
        System.out.printf("результат шифрования: %n"+cipher.encrypt(forEncrypt,2)+"%n");
        String forEncrypt2 = "Это тест и он простой!";
        System.out.printf("Подаем текст: %n" + forEncrypt2 + "%n");
        System.out.printf("результат шифрования: %n" + cipher.encrypt(forEncrypt2, 2) + "%n");
        System.out.println("------------------------------");
        System.out.println("--Дешифровка--");
        String fordecrypto = "Яфр фжуф к рп струфрл!";
        System.out.printf("Подаем текст: %n" + fordecrypto + "%n");
        System.out.printf("результат дешифрования: %n" + cipher.decrypt(fordecrypto, 2) + "%n");



    }
}
