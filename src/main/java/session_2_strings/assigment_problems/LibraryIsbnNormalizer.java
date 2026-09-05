package session_2_strings.assigment_problems;

/** Normalizes, validates, and formats an ISBN-style library code. */
public class LibraryIsbnNormalizer {
    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeCode(" pen2026004251 ")));
        System.out.println(validateAndFormat(normalizeCode("12N2026004251")));
    }

    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }
        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(code.charAt(index))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int index = 3; index < code.length(); index++) {
            if (!Character.isDigit(code.charAt(index))) {
                return "Invalid: code body must contain only digits";
            }
        }
        StringBuilder display = new StringBuilder();
        display.append('[').append(code.substring(0, 3)).append("] YEAR: ")
                .append(code, 3, 7).append(" | CATALOG: ").append(code.substring(7));
        return display.toString();
    }
}
