package edu.javaschool.core_concepts.challenges.datastructures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountVowelsAndConsonents {
    public static Map<String, Integer> countVowelsAndConsonants(String str) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        int vowelsCount = 0;
        int consonantsCount = 0;

        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if (vowels.contains(ch)) vowelsCount++;
                else consonantsCount++;
            }
        }

        Map<String, Integer> counts = new HashMap<>();
        counts.put("Vowels", vowelsCount);
        counts.put("Consonants", consonantsCount);
        return counts;
    }


    public static Map<String, Integer> countVowelsAndConsonantsUsingStreams(String str) {
        String lowerCaseStr = str.toLowerCase();
        long vowelsCount = lowerCaseStr.chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
        long consonantsCount = lowerCaseStr.chars()
                .filter(c -> c >= 'a' && c <= 'z') // Ensure it's an alphabet
                .filter(c -> "aeiou".indexOf(c) == -1)
                .count();

        return new HashMap<String, Integer>() {{
            put("Vowels", (int) vowelsCount);
            put("Consonants", (int) consonantsCount);
        }};
    }

    public static Map<String, Integer> countVowelsAndConsonantsOptimized(String str) {
        int vowelsCount = 0;
        int consonantsCount = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') { // Only consider alphabetic characters
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelsCount++;
                } else {
                    consonantsCount++;
                }
            }
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("Vowels", vowelsCount);
        result.put("Consonants", consonantsCount);
        return result;
    }

    public static void main(String[] args) {
        String testString = "Hello World";
        Map<String, Integer> result1 = countVowelsAndConsonants(testString);
        System.out.println("Method 1 (List.of): " + result1);

        Map<String, Integer> result2 = countVowelsAndConsonantsUsingStreams(testString);
        System.out.println("Method 2 (Streams): " + result2);

        Map<String, Integer> result3 = countVowelsAndConsonantsOptimized(testString);
        System.out.println("Method 3 (Optimized): " + result3);    }
}
