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

    public static String reverseStringBigO(String str) {
        int length = str.length();
        char[] cha = str.toCharArray(); // work directly on char array
        int left = 0;
        int right = length - 1;

        while (left < right) {
            char temp = cha[left];
            cha[left] = cha[right];
            cha[right] = temp;
            left++;
            right--;
        }

        return new String(cha);
    }
    public static void main(String[] args) {
        String str = "1234567890";
        System.out.println(reverseString(str));
        System.out.println(reverseStringBuilder(str));
        System.out.println(reverseStringBuffer(str));
        System.out.println(reverseStringBigO(str));
    }
}
