package string_array_basics.assigment_problems;

public class MovieReviewWordLengthProfiler {
    public static void classifyWordLengths(String review) {
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        for (String word : review.trim().split("\\s+")) {
            int length = word.replaceAll("[^A-Za-z]", "").length();
            if (length == 0) continue;
            if (length <= 4) shortWords++;
            else if (length <= 8) mediumWords++;
            else longWords++;
        }
        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortWords, mediumWords, longWords);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
