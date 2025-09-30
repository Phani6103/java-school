package edu.javaschool.core_concepts.challenges.datastructures;

public class AnagramCheck {

    private static boolean anagramCheck(String a, String b) {
        if (a.length() != b.length()) return false;
        for (char aChar : a.toCharArray()) {
            if (b.indexOf(aChar) == -1) return false;
        }
        return true;
    }

    private static boolean anagramCheckStreams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        // Convert strings to char arrays, sort them, and compare
        char[] charArrayA = a.toCharArray();
        char[] charArrayB = b.toCharArray();

        java.util.Arrays.sort(charArrayA);
        java.util.Arrays.sort(charArrayB);

        return java.util.Arrays.equals(charArrayA, charArrayB);
    }

    private static boolean anagramCheckOptimized(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] charCounts = new int[256]; // Assuming ASCII characters

        for (char c : a.toCharArray()) {
            charCounts[c]++;
        }

        for (char c : b.toCharArray()) {
            charCounts[c]--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean anagramCheckUsingStreams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        // Count character frequencies for string a
        java.util.Map<Integer, Long> charCountsA = a.chars()
                .boxed()
                .collect(java.util.stream.Collectors.groupingBy(
                        java.util.function.Function.identity(),
                        java.util.stream.Collectors.counting()
                ));

        // Count character frequencies for string b
        java.util.Map<Integer, Long> charCountsB = b.chars()
                .boxed()
                .collect(java.util.stream.Collectors.groupingBy(
                        java.util.function.Function.identity(),
                        java.util.stream.Collectors.counting()
                ));

        return charCountsA.equals(charCountsB);
    }
    
    public static void main(String[] args) {
        System.out.println(anagramCheck("listen", "silent")); // true
        System.out.println(anagramCheck("hello", "world"));  // false
        System.out.println(anagramCheck("anagram", "nagaram")); // true
        System.out.println(anagramCheck("rat", "car"));     // false
        
    }
}
