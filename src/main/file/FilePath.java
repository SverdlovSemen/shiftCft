package main.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public final class FilePath {
    private FilePath(){}
    private static String nameOfRelativePathToFileResults = "";
    private static String prefixNameFileResults = "";
    private static Path pathToFileResult = Paths.get(System.getProperty("user.dir"));

    public static void processOutputPathAndPrefix(String[] args){
        for (int i = 0; i < args.length; i++) {
            switch(args[i]){
                case "-o":
                    processOutputPath(args, i);
                    break;
                case "-p":
                    processOutputPrefix(args, i);
                    break;
            }
        }
    }

    private static void processOutputPath(String[] args, int index){
        if(index == 0 || (!args[index-1].equals("-p") && !args[index-1].equals("-o"))){
            setNameOfRelativePathToFileResults(args[index + 1]);
            createDirectory();
        }
    }

    private static void processOutputPrefix(String[] args, int index){
        if(index==0 || (!args[index-1].equals("-p") && !args[index-1].equals("-o"))) {
            FilePath.setPrefixNameFileResults(args[index + 1]);
        }
    }

    public static void createDirectory(){
        String relativePath = getNameOfRelativePathToFileResults();
        String currentDirectory = System.getProperty("user.dir");
        Path outputPath = null;

        while(outputPath == null) {
            try {
                outputPath = Paths.get(currentDirectory, relativePath);
            } catch (InvalidPathException e) {
                relativePath =  ErrorHandling.inputPathToFileResults();
            }
        }

        if(!Files.exists(outputPath)) {
            try {
                Files.createDirectories(outputPath);
                FilePath.setPathToFileResult(outputPath);
            } catch (IOException e) {
                System.out.println("Не удалось создать указанную директорию для файлов с результатами");
            }
        } else{
            FilePath.setPathToFileResult(outputPath);
        }
    }

    public static void setNameOfRelativePathToFileResults(String nameOfRelativePathToFileResults){
        FilePath.nameOfRelativePathToFileResults = nameOfRelativePathToFileResults;
    }

    public static String getNameOfRelativePathToFileResults() {
        return nameOfRelativePathToFileResults;
    }

    public static void setPrefixNameFileResults(String prefixNameFileResults){
        FilePath.prefixNameFileResults = prefixNameFileResults;
    }

    public static String getPrefixNameFileResults() {
        return prefixNameFileResults;
    }

    public static void setPathToFileResult(Path pathToFileResult){
        FilePath.pathToFileResult = pathToFileResult;
    }

    public static Path getPathToFileResult(){
        return pathToFileResult;
    }
}
