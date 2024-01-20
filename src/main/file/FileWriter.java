package main.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public final class FileWriter {
    private FileWriter(){}
    public static <T> void writeValueToFile(T value, String fileName){
        Path filePath = tryFilePathResolve(fileName);

        try(Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath.toFile(), true), StandardCharsets.UTF_8))) {

            writer.write(value + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден при записи в файл: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Кодировка не поддерживается при записи в файл: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода вывода при записи в файл: " + e.getMessage());
        }
    }

    private static Path tryFilePathResolve(String fileName){
        Path pathToFileResult = FilePath.getPathToFileResult();
        String prefixNameFiles = FilePath.getPrefixNameFileResults();
        Path filePath = null;
        while (filePath == null) {
            try{
                filePath = pathToFileResult.resolve(prefixNameFiles + fileName);
            } catch(InvalidPathException e) {
                prefixNameFiles = ErrorHandling.inputPrefixName();
            }
        }
        FilePath.setPrefixNameFileResults(prefixNameFiles);
        return filePath;
    }
}

















