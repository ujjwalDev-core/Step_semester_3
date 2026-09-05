package session_2_strings.class_problems;

/** Normalizes, validates, and formats a bank transaction reference. */
public class BankTransactionReference {
    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeReference(" hdf03022600042 ")));
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));
    }

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }
        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(reference.charAt(index))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int index = 3; index < reference.length(); index++) {
            if (!Character.isDigit(reference.charAt(index))) {
                return "Invalid: reference body must contain only digits";
            }
        }
        StringBuilder display = new StringBuilder();
        display.append('[').append(reference.substring(0, 3)).append("] DATE: ")
                .append(reference, 3, 5).append('/').append(reference, 5, 7).append('/')
                .append(reference, 7, 9).append(" | SEQ: ").append(reference.substring(9));
        return display.toString();
    }
}
