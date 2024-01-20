package main.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileDelete {
    private FileDelete(){}
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
        Path pathFileResult = FilePath.getPathToFileResult();
        Path pathInt = null;
        while(pathInt == null) {
            try {
                pathInt = Paths.get(FilePath.getPrefixNameFileResults() + FileConstants.INTEGERS.getFileName());
                Path pathFloat = Paths.get(FilePath.getPrefixNameFileResults() + FileConstants.FLOATS.getFileName());
                Path pathString = Paths.get(FilePath.getPrefixNameFileResults() + FileConstants.STRINGS.getFileName());

                try {
                    Files.deleteIfExists(pathFileResult.resolve(pathInt));
                    Files.deleteIfExists(pathFileResult.resolve(pathFloat));
                    Files.deleteIfExists(pathFileResult.resolve(pathString));
                } catch (IOException e) {
                    System.out.println("Файл не может быть удалён: " + e.getMessage());
                }
            } catch (InvalidPathException e) {
                String newPrefixName = ErrorHandling.inputPrefixName();
                FilePath.setPrefixNameFileResults(newPrefixName);
            }
        }
    }
}
