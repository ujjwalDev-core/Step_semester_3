package string_array_basics.class_problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char character : text.toCharArray()) {
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }
        for (char character : text.toCharArray()) {
            if (frequencies.get(character) == 1) return character;
        }
        return '\0';
    }

    public static void main(String[] args) {
        for (String text : new String[]{"swiss", "aabbcc"}) {
            char result = findFirstNonRepeatingChar(text);
            System.out.println(result == '\0' ? "No Non-Repeating Character Found" :
                    "First Non-Repeating Character: '" + result + "'");
        }
    }
}
