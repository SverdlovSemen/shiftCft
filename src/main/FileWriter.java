package main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileWriter {
    private FileWriter(){}
    public static <T> void writeValueToFile(T value, String fileName){
        Path pathToFileResult = FilePathAndPrefixName.getPathToFileResult();
        String prefixNameFiles = FilePathAndPrefixName.getPrefixNameFileResults();
        Path filePath = pathToFileResult.resolve(prefixNameFiles + fileName);

        try(Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath.toFile(), true), StandardCharsets.UTF_8))) {

            writer.write(value + "\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createDirectory(){
        String relativePath = FilePathAndPrefixName.getNameOfRelativePathToFileResults();
        String currentDirectory = System.getProperty("user.dir");
        Path outputPath = Paths.get(currentDirectory, relativePath);

        if(!Files.exists(outputPath)) {
            try {
                Files.createDirectories(outputPath);
                FilePathAndPrefixName.setPathToFileResult(outputPath);
            } catch (IOException e) {
                System.out.println("Не удалось создать указанную директорию для файлов с результатами");
            }
        } else{
            FilePathAndPrefixName.setPathToFileResult(outputPath);
        }

    }
}

















