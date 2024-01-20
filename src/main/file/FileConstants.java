package main.file;

public enum FileConstants {
    INTEGERS ("integers.txt"),
    FLOATS ("floats.txt"),
    STRINGS ("strings.txt");

    private final String fileName;
    FileConstants(String fileName){
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
