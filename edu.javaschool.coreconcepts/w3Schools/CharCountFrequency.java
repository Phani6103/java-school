package w3Schools;

import java.util.HashMap;

public class CharCountFrequency {
    public static void main(String[] args) {
        String text = "Hello, World!";
        char targetChar = 'l';

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == targetChar) {
                count++;
            }
        }

        System.out.println("The character '" + targetChar + "' appears " + count + " times in the text.");

        // Using HashMap lets implement the same
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        System.out.println("The character '" + targetChar + "' appears " + charCount.get(targetChar) + " times in the text.");
    }

}
