package main.file;

import java.io.FileNotFoundException;
import java.util.Scanner;

public final class ErrorHandling {
    private ErrorHandling(){}
    public static void handleFileNotFoundError(FileNotFoundException e){
        System.out.println("Файл не был найден: " + e.getMessage());
        reInputMethodMain();
    }

    public static void exceptionInFilePath(Exception e){
        System.out.println("Не удалось создать путь к файлам, причина: " + e.getMessage());
        reInputMethodMain();
    }

    private static void reInputMethodMain(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите опции и имена существующих файлов через пробел: ");
        String line = scanner.nextLine();
        String[] args = line.split(" ");
        FileReader.readArgumentMethodMain(args);
    }

    public static String inputPathToFileResults(){
        System.out.println("Недопустимый путь. Пожалуйста введите допустимый путь: ");
        Scanner scanner = new Scanner(System.in);
        String relativePath = scanner.nextLine();
        return relativePath;
    }

    public static String inputPrefixName(){
        System.out.println("Недопустимый префикс для имён файлов. Пожалуйста введите допустимый префикс: ");
        Scanner scanner = new Scanner(System.in);
        String prefixName = scanner.nextLine();
        return prefixName;
    }
}
