package edu.javaschool.core_concepts.challenges.datastructures;

public class Factorial {

    private static int factorialValueReccursive(int val) {
        if (val == 0) {
            return 1;
        }
        if (val < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (val == 1) {
            return 1;
        }
        return val * factorialValueReccursive(val - 1);
    }

    private static int factorialValueIterative(int val) {
        if (val < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (val == 0 || val == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= val; i++) {
            result *= i;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("Factorial of 5 (Recursive): " + factorialValueReccursive(5));
        System.out.println("Factorial of 0 (Recursive): " + factorialValueReccursive(0));
        System.out.println("Factorial of 5 (Iterative): " + factorialValueIterative(5));
        System.out.println("Factorial of 0 (Iterative): " + factorialValueIterative(0));
        
    }
}
