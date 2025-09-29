package edu.javaschool.core_concepts.challenges.datastructures;

public class ReverseString {
    public static String reverseString(String str) {
        char[] newArr = new char[str.length()];
        char[] arr = str.toCharArray();
        int index = 0;
        for (int i = str.length() -1 ; i >= 0; i-- ) {
            newArr[index] = arr[i];
            index++;
        }
        return new String(newArr);
    }

    public static String reverseStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseStringBuffer(String str) {
        return new StringBuffer(str).reverse().toString();
    }
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(reverseString(str));
        System.out.println(reverseStringBuilder(str));
        System.out.println(reverseStringBuffer(str));
    }
}
