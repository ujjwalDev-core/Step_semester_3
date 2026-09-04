package string_array_basics.assigment_problems;

public class TypingSpeedTestAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int comparisonLength = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatch = -1;
        for (int index = 0; index < comparisonLength; index++) {
            if (original.charAt(index) == typed.charAt(index)) matched++;
            else if (firstMismatch == -1) firstMismatch = index;
        }
        matched -= Math.abs(original.length() - typed.length());
        matched = Math.max(0, matched);
        int totalCharacters = Math.max(original.length(), typed.length());
        double accuracy = totalCharacters == 0 ? 100.0 : matched * 100.0 / totalCharacters;
        if (firstMismatch == -1 && original.length() != typed.length()) {
            firstMismatch = comparisonLength;
        }
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, totalCharacters, accuracy);
        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            char expected = firstMismatch < original.length() ? original.charAt(firstMismatch) : '-';
            char actual = firstMismatch < typed.length() ? typed.charAt(firstMismatch) : '-';
            System.out.printf(" | First Mismatch at position %d ('%s' vs '%s')%n",
                    firstMismatch + 1, expected, actual);
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
