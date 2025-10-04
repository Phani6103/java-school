package edu.javaschool.core_concepts.challenges.datastructures;

import java.util.Arrays;
import java.util.List;

public class Pythagarus {
    private static boolean pythagarus( List<Integer> numbers) {
        int len = numbers.size();
        numbers.sort((a, b) -> a - b);
        boolean isValid = false;
        for (int i=len-1; i >=2; i--) {
            for ( int j=len-2; j>=2; j--) {
                if (Math.pow(numbers.get(i), 2) == Math.pow(numbers.get(j), 2) + Math.pow(numbers.get(j-1), 2)) {
                    return isValid = true;
                }
            }
        }
        return isValid;
    }


    public static void main(String[] args) {
        boolean isValid = pythagarus(Arrays.asList(5,1,3,2,4));
        System.out.println(isValid);
    }
}