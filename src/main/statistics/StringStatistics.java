package main.statistics;

public class StringStatistics implements CollectStatistics {
    private static int numberOfString;
    private static Integer sizeShortestString;
    private static Integer sizeLongestString;

    public static int getNumberOfString(){return numberOfString;}
    public static void setNumberOfString(int numberOfString){
        StringStatistics.numberOfString = numberOfString;
    }

    public static Integer getSizeShortestString() {
        return sizeShortestString;
    }

    public static Integer getSizeLongestString() {
        return sizeLongestString;
    }

    @Override
    public void collectFullStatistics(Object value) {
        String string = (String) value;
        if(sizeLongestString == null && sizeShortestString == null){
            sizeLongestString = string.length();
            sizeShortestString = string.length();
        } else if(string.length() > sizeLongestString) {
            sizeLongestString = string.length();
        } else if (string.length() < sizeShortestString){
            sizeShortestString = string.length();
        }
    }
}
