package session_2_strings.assigment_problems;

/** Reverses every word while retaining the sentence's word order. */
public class WordReversalEncoder {
    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }

    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < words.length; index++) {
            StringBuilder reversedWord = new StringBuilder();
            for (int character = words[index].length() - 1; character >= 0; character--) {
                reversedWord.append(words[index].charAt(character));
            }
            if (index > 0) {
                result.append(' ');
            }
            result.append(reversedWord);
        }
        return result.toString();
    }
}
