package cryptoanalaiizer.test;

import cryptoanalaiizer.model.DefaultRussianAlphabet;
import cryptoanalaiizer.utils.Validator;

public class TestValidator {
    public static void main(String[] args) {
        boolean isValidKey = Validator.isValidKey(10, DefaultRussianAlphabet.cyrillicValues());
        System.out.printf("Проверка доступности сдвига: ключ %d находится в состоянии %b %n", 10, isValidKey);
        isValidKey = Validator.isValidKey(36, DefaultRussianAlphabet.cyrillicValues());
        System.out.printf("Проверка доступности сдвига: ключ %d находится в состоянии %b %n", 36, isValidKey);
        boolean isFileExists = Validator.isFileExists("D:\\123.txt");
        System.out.printf("Проверка существования файла: файл по пути  \"%s\" находится в состоянии %b %n", "D:\\123.txt", isFileExists);
        isFileExists = Validator.isFileExists("D:\\999.txt");
        System.out.printf("Проверка существования файла: файл по пути  \"%s\" находится в состоянии %b %n", "D:\\123.txt", isFileExists);
        boolean isValidExtension  = Validator.isValidExtension("D:\\999.txt");
        System.out.printf("Проверка расширения файла: файл по пути  \"%s\" имеет расширение в состоянии %b %n", "D:\\999.txt", isValidExtension);
        isValidExtension  = Validator.isValidExtension("D:\\999.TXT");
        System.out.printf("Проверка расширения файла: файл по пути  \"%s\" имеет расширение в состоянии %b %n", "D:\\999.TXT", isValidExtension);
        isValidExtension  = Validator.isValidExtension("D:\\999.pdf");
        System.out.printf("Проверка расширения файла: файл по пути  \"%s\" имеет расширение в состоянии %b %n", "D:\\999.pdf", isValidExtension);
    }
}
