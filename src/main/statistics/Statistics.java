package main.statistics;

import com.sun.security.jgss.GSSUtil;
import main.FilePathAndPrefixName;

public class Statistics {
    private static ModeStatistics modeStatistics;
    private static final IntegerStatistics integerStatistics = new IntegerStatistics();
    private static final DoubleStatistics doubleStatistics = new DoubleStatistics();
    private static final StringStatistics stringStatistics = new StringStatistics();

    public static void setModeStatistics(ModeStatistics modeStatistics) {
        Statistics.modeStatistics = modeStatistics;
    }

    public static ModeStatistics getModeStatistics() {
        return modeStatistics;
    }

    public static <T> void collect(T value){
        if(modeStatistics == ModeStatistics.SHORT) {
            collectNumberOfItems(value);
        } else if(modeStatistics == ModeStatistics.FULL){
            collectNumberOfItems(value);
            collectFullStatistics(value);
        }
    }

    private static <T> void collectFullStatistics(T value){
        if(value instanceof Integer){
            integerStatistics.collectFullStatistics(value);
        } else if(value instanceof Double){
            doubleStatistics.collectFullStatistics(value);
        } else if(value instanceof String) {
            stringStatistics.collectFullStatistics(value);
        }
    }

    private static <T> void collectNumberOfItems(T value){
        if(value instanceof Integer){
            int currentNumberInt = IntegerStatistics.getNumberOfInt();
            IntegerStatistics.setNumberOfInt(currentNumberInt + 1);
        } else if(value instanceof Double){
            int currentNumberDouble = DoubleStatistics.getNumberOfDouble();
            DoubleStatistics.setNumberOfDouble(currentNumberDouble + 1);
        } else if(value instanceof String) {
           int currentNumberString = StringStatistics.getNumberOfString();
           StringStatistics.setNumberOfString(currentNumberString + 1);
        }
    }

    public static void printToConsole(){
        String prefixName = FilePathAndPrefixName.getPrefixNameFileResults();
        if(modeStatistics == ModeStatistics.SHORT){
            printShortStatistics(prefixName);
        } else if(modeStatistics == ModeStatistics.FULL){
            printFullStatistics(prefixName);
        }
    }

    private static void printShortStatistics(String prefixName){
        int numItem = IntegerStatistics.getNumberOfInt();
        System.out.println("Количество элементов, записанных в файл " + prefixName + "integers.txt = " + numItem);

        int doubleItem = DoubleStatistics.getNumberOfDouble();
        System.out.println("Количество элементов, записанных в файл " + prefixName + "floats.txt = " + doubleItem);

        int stringItem = StringStatistics.getNumberOfString();
        System.out.println("Количество элементов, записанных в файл " + prefixName + "strings.txt = " + stringItem);
    }

    private static void printFullStatistics(String prefixName){
        System.out.println("\nПолная статистика для файла " + prefixName + "integers.txt");
        System.out.println("Количество элементов, записанных в файл: " + IntegerStatistics.getNumberOfInt());
        System.out.println("Минимальное значение: " + IntegerStatistics.getMinValueInt());
        System.out.println("Максимальное значение: " + IntegerStatistics.getMaxValueInt());
        System.out.println("Сумма всех элементов: " + IntegerStatistics.getSumOfInt());
        System.out.println("Среднее значение: " + IntegerStatistics.getAverageInt());

        System.out.println("\nПолная статистика для файла " + prefixName + "floats.txt");
        System.out.println("Количество элементов, записанных в файл: " + DoubleStatistics.getNumberOfDouble());
        System.out.println("Минимальное значение: " + DoubleStatistics.getMinValueDouble());
        System.out.println("Максимальное значение: " + DoubleStatistics.getMaxValueDouble());
        System.out.println("Сумма всех элементов: " + DoubleStatistics.getSumOfDouble());
        System.out.println("Среднее значение: " + DoubleStatistics.getAverageDouble());

        System.out.println("\nПолная статистика для файла " + prefixName + "strings.txt");
        System.out.println("Количество элементов, записанных в файл: " + StringStatistics.getNumberOfString());
        System.out.println("Размер самой короткой строки: " + StringStatistics.getSizeShortestString());
        System.out.println("Размер самой длинной строки: " + StringStatistics.getSizeLongestString());
    }
}























