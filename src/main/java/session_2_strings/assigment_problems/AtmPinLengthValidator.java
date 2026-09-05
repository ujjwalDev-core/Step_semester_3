package session_2_strings.assigment_problems;

/** Performs the requested length-only PIN check. */
public class AtmPinLengthValidator {
    public static void main(String[] args) {
        checkPinLength("482");
        checkPinLength("4820");
    }

    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
}
