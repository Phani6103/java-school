package w3Schools;

public class CountWords {
    public static void main(String[] args) {
        String sentence = "This is a sample sentence to count words.";
        int wordCount = countWords(sentence);
        System.out.println("The sentence is: \"" + sentence + "\"");
        System.out.println("Number of words: " + wordCount);

        String anotherSentence = "  Hello   world !  ";
        wordCount = countWords(anotherSentence);
        System.out.println("\nThe sentence is: \"" + anotherSentence + "\"");
        System.out.println("Number of words: " + wordCount);

        String emptySentence = "";
        wordCount = countWords(emptySentence);
        System.out.println("\nThe sentence is: \"" + emptySentence + "\"");
        System.out.println("Number of words: " + wordCount);

        String punctuationSentence = "One, two, three.";
        wordCount = countWords(punctuationSentence);
        System.out.println("\nThe sentence is: \"" + punctuationSentence + "\"");
        System.out.println("Number of words: " + wordCount);
    }

    /**
     * Counts the number of words in a given string.
     * Words are separated by one or more spaces.
     *
     * @param sentence The input string.
     * @return The number of words in the string.
     */
    public static int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        // Trim leading/trailing spaces and split by one or more spaces
        String[] words = sentence.trim().split("\\s+");

        // If the trimmed string is empty (e.g., "   "), split will return an array with one empty string.
        // In that case, the word count should be 0.
        if (words.length == 1 && words[0].isEmpty()) {
            return 0;
        }

        return words.length;
    }

}
