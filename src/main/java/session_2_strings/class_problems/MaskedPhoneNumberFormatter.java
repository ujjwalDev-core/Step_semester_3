package session_2_strings.class_problems;

/** Masks all but the last four digits of a valid phone number. */
public class MaskedPhoneNumberFormatter {
    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }

    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int index = 0; index < phone.length(); index++) {
            if (!Character.isDigit(phone.charAt(index))) {
                return "Invalid phone number";
            }
        }
        StringBuilder maskedPhone = new StringBuilder("XXXXXX" + phone.substring(6));
        maskedPhone.insert(6, '-');
        return maskedPhone.toString();
    }
}
