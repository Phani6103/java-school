package edu.javaschool.core_concepts.challenges.datastructures;

public class Palindrome {
    private static boolean isPalindrome(String str) {
        int len = str.length();
        if (len%2 == 0) {
            return false;
        } else {
            int left = 0;
            int right = len - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));    
    }
}
