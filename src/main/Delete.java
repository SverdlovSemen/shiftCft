package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Delete {
    private Delete(){}
    public static void decideDeleteOrNotFile(String[] args){
        boolean deleteFiles = true;
        for (int i = 0; i < args.length; i++) {
            if(args[i].equals("-a") && i == 0
                    || (args[i].equals("-a") && !args[i-1].equals("-o") && !args[i-1].equals("-p"))){
                deleteFiles = false;
            }
        }
        if(deleteFiles){
            deleteFilesIfExists();
        }
    }

    public static void deleteFilesIfExists(){
        Path pathFileResult = FilePathAndPrefixName.getPathToFileResult();
        Path pathInt = Paths.get(FilePathAndPrefixName.getPrefixNameFileResults() + "integers.txt");
        Path pathFloat = Paths.get(FilePathAndPrefixName.getPrefixNameFileResults() + "floats.txt");
        Path pathString = Paths.get(FilePathAndPrefixName.getPrefixNameFileResults() + "strings.txt");

        try {
            Files.deleteIfExists(pathFileResult.resolve(pathInt));
            Files.deleteIfExists(pathFileResult.resolve(pathFloat));
            Files.deleteIfExists(pathFileResult.resolve(pathString));
        } catch (IOException e) {
            System.out.println("Файл не может быть удалён: " + e.getMessage());
        }
    }
}
