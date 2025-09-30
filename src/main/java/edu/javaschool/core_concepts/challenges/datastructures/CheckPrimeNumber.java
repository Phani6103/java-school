package edu.javaschool.core_concepts.challenges.datastructures;

import java.util.stream.IntStream;

public class CheckPrimeNumber {

    private static boolean checkPrimeNbr(int val) {
        if (val <= 0) return false;
        if (val == 1 || val == 2) return true;
        if (val%2 == 0) return false;
        int counter=0;
        for ( int i =3; i < Math.sqrt(val); i=i+2) {
            counter++;
            System.out.println("Value : "+val+" Counter:  " +counter +" Sqrt: "+Math.sqrt(val));
            if (val%i ==0) return false;
        }
        return true;
    }

    private static boolean isPrimeOptimized(int n) {
        if (n <= 1) return false; // 0 and 1 are not prime numbers
        if (n <= 3) return true;  // 2 and 3 are prime numbers
        if (n % 2 == 0 || n % 3 == 0) return false; // Divisible by 2 or 3, not prime
        int counter=0;

        // Check for prime numbers from 5 onwards
        // All primes greater than 3 can be expressed in the form 6k ± 1
        for (int i = 5; i * i <= n; i = i + 6) {
            counter++;
            System.out.println("Value : "+n+" Counter:  " +counter +" Sqrt: "+Math.sqrt(n));
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimeUsingStreams(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        // Check for factors from 5 up to sqrt(number)
        // Only need to check numbers of the form 6k ± 1
        return IntStream.iterate(5, i -> i * i <= number, i -> i + 6)
                .noneMatch(i -> number % i == 0 || number % (i + 2) == 0);
    }
    
    
    public static void main(String[] args) {
        System.out.println(checkPrimeNbr(10093));
        System.out.println(isPrimeOptimized(10093));
        System.out.println(isPrimeUsingStreams(10093));
        
        
    }
}
