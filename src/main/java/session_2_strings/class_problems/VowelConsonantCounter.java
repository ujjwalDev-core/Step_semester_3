package session_2_strings.class_problems;

/** Counts letters in a title while ignoring spaces. */
public class VowelConsonantCounter {
    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }

    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int index = 0; index < text.length(); index++) {
            char character = Character.toLowerCase(text.charAt(index));
            if (character == ' ') {
                continue;
            }
            if (character == 'a' || character == 'e' || character == 'i'
                    || character == 'o' || character == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
}
