package main;

import main.statistics.ModeStatistics;
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

    public static void readArgumentMethodMain(String[] args){
        boolean fileTxtEnter = false;
        for (int i = 0; i < args.length; i++) {
            if(!args[i].contains(".txt")){
                switch(args[i]){
                    case "-o":
                        if(i==0 || (!args[i-1].equals("-p") && !args[i-1].equals("-o"))) {
                            FilePathAndPrefixName.setNameOfRelativePathToFileResults(args[i + 1]);
                            FileWriter.createDirectory();
                        }
                        break;
                    case "-p":
                        if(i==0 || (!args[i-1].equals("-p") && !args[i-1].equals("-o")))
                            FilePathAndPrefixName.setPrefixNameFileResults(args[i+1]);
                        break;
                    case "-s":
                        if((i==0 || (!args[i-1].equals("-p") && !args[i-1].equals("-o")))
                                && Statistics.getModeStatistics() != ModeStatistics.FULL)
                            Statistics.setModeStatistics(ModeStatistics.SHORT);
                        break;
                    case "-f":
                        if(i==0 || (!args[i-1].equals("-p") && !args[i-1].equals("-o")))
                            Statistics.setModeStatistics(ModeStatistics.FULL);
                        break;
                }
            }
        }
        Delete.decideDeleteOrNotFile(args);
        for (int i = 0; i < args.length; i++) {
            if(args[i].contains(".txt")) {
                fileTxtEnter = true;
                readFileAsString(args[i]);
            }
        }
        if(!fileTxtEnter)
            ErrorHandling.handleFileNotFoundError(new FileNotFoundException());
    }

    private static void readFileAsString(String inputFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(inputFile));) {
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
            FileWriter.writeValueToFile(intValue, "integers.txt");
            Statistics.collect(intValue);
            return;
        } catch(NumberFormatException e) {

        }
        try {
            double doubleValue = Double.parseDouble(line);
            FileWriter.writeValueToFile(doubleValue, "floats.txt");
            Statistics.collect(doubleValue);
            return;
        } catch(NumberFormatException e) {

        }

        if(line.matches("[a-zA-Zа-яА-Я ]*$") && !line.trim().isEmpty()) {
            FileWriter.writeValueToFile(line, "strings.txt");
            Statistics.collect(line);
        }
    }

}













