package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public final class ErrorHandling {
    private ErrorHandling(){}
    public static void handleFileNotFoundError(FileNotFoundException e){
        System.out.println("Файл не был найден: " + e.getMessage());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите опции и имена существующих файлов через пробел: ");
        String line = scanner.nextLine();
        String[] args = line.split(" ");
        FileReader.readArgumentMethodMain(args);
    }
}
