package challenges.w3Schools;

import java.util.stream.Stream;

public class CountVowelsInAString {
    public static void main(String[] args) {
        String input = "Hello, World!";
        int vowelCount = countVowels(input);
        System.out.println("Number of vowels in the string: " + vowelCount);

        vowelCount = countVowels2(input);
        System.out.println("Number of vowels in the string: " + vowelCount);
    }

    private static int countVowels(String input) {
        int count = 0;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }

        return count;
    }

    private static int countVowels2(String input) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        Stream<String> str = Stream.of(input.split(""));
        Stream<String> filtered = str.filter(p -> vowels.contains(p));
        count = (int) filtered.count();
        return count;
    }

}
