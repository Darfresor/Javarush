package cryptoanalaiizer.utils;

import java.nio.file.*;

public final class Validator {
    private Validator() {
    }

    ;

    public static boolean isValidKey(int key, char[] alphabet) {
        if(key> alphabet.length){
            System.err.println("Ошибка! Укажите ключ подходящей размерности");
            return false;
        }else{
            return true;
        }
    }

    public static boolean isFileExists(String filePath) {
        Path path =Path.of(filePath);
        if(Files.exists(path)){
            return true;
        }else{
            System.err.println("Ошибка! Указанный путь или файл не найден!");
            return false;
        }

    };

    public static boolean isValidExtension(String filePath) {
        Path path =Path.of(filePath);
        String fileName = String.valueOf(path.getFileName());
        if(fileName.matches(".*\\.(?i)(txt)$")){
            return true;
        }else{
            System.err.println("Ошибка! Можно работать только с txt файлами");
            return false;
        }
    }
}
