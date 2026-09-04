package string_array_basics.assigment_problems;

public class TrafficSignalStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("No Signal Readings");
            return;
        }
        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
        char currentColor = longestColor;
        int currentLength = 1;
        for (int index = 1; index < signalLog.length(); index++) {
            if (signalLog.charAt(index) == currentColor) currentLength++;
            else {
                currentColor = signalLog.charAt(index);
                currentLength = 1;
            }
            if (currentLength > longestLength) {
                longestColor = currentColor;
                longestLength = currentLength;
            }
        }
        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, longestLength);
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}
