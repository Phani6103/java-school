package edu.javaschool.core_concepts.w3Schools;

public class FibonacciSequence {
    public static void main(String[] args) {
        int n = 10; // Number of terms to print
        System.out.println("Fibonacci sequence up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        System.out.println("Fibonacci sequence using iteration up to " + n + " terms:");
        printFibonacciIterative(n);
    }

    /**
     * Calculates the nth Fibonacci number using recursion.
     * F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2)
     *
     * @param n The index of the Fibonacci number to calculate.
     * @return The nth Fibonacci number.
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Prints the Fibonacci sequence up to n terms using an iterative approach.
     *
     * @param n The number of terms to print.
     */
    public static void printFibonacciIterative(int n) {
        if (n <= 0) {
            return;
        }
        int a = 0, b = 1;
        System.out.print(a + " ");
        if (n > 1) {
            System.out.print(b + " ");
        }
        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
        System.out.println();
    }

}
