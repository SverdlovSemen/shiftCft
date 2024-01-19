package main.statistics;

public class IntegerStatistics implements CollectStatistics  {
    private static int numberOfInt = 0;
    private static Integer maxValueInt;
    private static Integer minValueInt;
    private static int sumOfInt;
    private static double averageInt;

    @Override
    public void collectFullStatistics(Object value) {
        Integer valueInt = (Integer) value;
        if(maxValueInt == null && minValueInt == null) {
            maxValueInt = valueInt;
            minValueInt = valueInt;
        } else if(valueInt > maxValueInt) {
            maxValueInt = valueInt;
        } else if(valueInt < minValueInt){
            minValueInt = valueInt;
        }

        sumOfInt += (Integer) valueInt;
        averageInt = sumOfInt / (double) numberOfInt;
    }

    public static int getNumberOfInt() {
        return numberOfInt;
    }

    public static void setNumberOfInt(int numberOfInt) {
        IntegerStatistics.numberOfInt = numberOfInt;
    }

    public static Integer getMaxValueInt() {
        return maxValueInt;
    }

    public static Integer getMinValueInt() {
        return minValueInt;
    }

    public static int getSumOfInt() {
        return sumOfInt;
    }

    public static double getAverageInt() {
        return averageInt;
    }
}
