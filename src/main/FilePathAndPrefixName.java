package main;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class FilePathAndPrefixName {
    private FilePathAndPrefixName(){}
    private static String nameOfRelativePathToFileResults = "";
    private static String prefixNameFileResults = "";
    private static Path pathToFileResult = Paths.get(System.getProperty("user.dir"));
    public static void setNameOfRelativePathToFileResults(String nameOfRelativePathToFileResults){
        FilePathAndPrefixName.nameOfRelativePathToFileResults = nameOfRelativePathToFileResults;
    }

    public static String getNameOfRelativePathToFileResults() {
        return nameOfRelativePathToFileResults;
    }

    public static void setPrefixNameFileResults(String prefixNameFileResults){
        FilePathAndPrefixName.prefixNameFileResults = prefixNameFileResults;
    }

    public static String getPrefixNameFileResults() {
        return prefixNameFileResults;
    }

    public static void setPathToFileResult(Path pathToFileResult){
        FilePathAndPrefixName.pathToFileResult = pathToFileResult;
    }

    public static Path getPathToFileResult(){
        return pathToFileResult;
    }
}
