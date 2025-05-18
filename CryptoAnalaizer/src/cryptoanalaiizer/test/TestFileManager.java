package cryptoanalaiizer.test;

import cryptoanalaiizer.utils.FileManager;

public class TestFileManager {
    public static void main(String[] args) {
        String inText = FileManager.readFile("D:\\123.txt");
        System.out.println(inText);
        FileManager.writeFile(inText,"D:\\1234.docx");

    }
}
