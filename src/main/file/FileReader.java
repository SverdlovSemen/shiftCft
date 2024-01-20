package main.file;

import main.statistics.Statistics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class FileReader {
    private FileReader(){}

    public static void main(String[] args) {
        readArgumentMethodMain(args);
        if(Statistics.getModeStatistics() != null){
            Statistics.printToConsole();
        }
    }

    public static void readArgumentMethodMain(String[] args) {
        FilePath.processOutputPathAndPrefix(args);
        Statistics.processStatisticsOptions(args);
        FileDelete.decideDeleteOrNotFile(args);

        boolean fileTxtEnter = false;
        for (String arg : args) {
            if (arg.endsWith(".txt")) {
                fileTxtEnter = true;
                readFileAsString(arg);
            }
        }

        if (!fileTxtEnter) {
            ErrorHandling.handleFileNotFoundError(new FileNotFoundException());
        }
    }

    private static void readFileAsString(String inputFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(inputFile))) {
            String line = bufferedReader.readLine();

            while(line != null) {
                identifierLine(line);
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            ErrorHandling.handleFileNotFoundError(e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода вывода: " + e.getMessage());
        }
    }

    private static void identifierLine(String line){
        try {
            int intValue = Integer.parseInt(line);
            FileWriter.writeValueToFile(intValue, FileConstants.INTEGERS.getFileName());
            Statistics.collect(intValue);
            return;
        } catch(NumberFormatException e) {

        }
        try {
            double doubleValue = Double.parseDouble(line);
            FileWriter.writeValueToFile(doubleValue, FileConstants.FLOATS.getFileName());
            Statistics.collect(doubleValue);
            return;
        } catch(NumberFormatException e) {

        }

        if(line.matches("[a-zA-Zа-яА-Я ]*$") && !line.trim().isEmpty()) {
            FileWriter.writeValueToFile(line, FileConstants.STRINGS.getFileName());
            Statistics.collect(line);
        }
    }
}













