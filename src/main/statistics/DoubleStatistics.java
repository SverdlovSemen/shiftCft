package main.statistics;

public class DoubleStatistics implements CollectStatistics {
    private static int numberOfDouble = 0;
    private static Double maxValueDouble;
    private static Double minValueDouble;
    private static double sumOfDouble;
    private static double averageDouble;

    public static int getNumberOfDouble(){return numberOfDouble;}

    public static void setNumberOfDouble(int numberOfDouble){DoubleStatistics.numberOfDouble = numberOfDouble;}

    @Override
    public void collectFullStatistics(Object value) {
        Double valueDouble = (Double) value;
        if(maxValueDouble == null && minValueDouble == null){
            maxValueDouble = valueDouble;
            minValueDouble = valueDouble;
        } else if(valueDouble > maxValueDouble){
            maxValueDouble = valueDouble;
        } else if(valueDouble < minValueDouble){
            minValueDouble = valueDouble;
        }

        sumOfDouble += valueDouble;
        averageDouble = sumOfDouble / numberOfDouble;
    }

    public static Double getMaxValueDouble() {
        return maxValueDouble;
    }

    public static Double getMinValueDouble() {
        return minValueDouble;
    }

    public static double getSumOfDouble() {
        return sumOfDouble;
    }

    public static double getAverageDouble() {
        return averageDouble;
    }
}
