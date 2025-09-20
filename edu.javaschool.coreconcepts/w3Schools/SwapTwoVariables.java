package w3Schools;

public class SwapTwoVariables {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        System.out.println("Before swapping:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        // Method 1: Using a temporary variable
        int temp = x;
        x = y;
        y = temp;

        System.out.println("\nAfter swapping (Method 1 - using temp variable):");
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        // Reset values for Method 2
        x = 10;
        y = 20;

        // Method 2: Without using a temporary variable (arithmetic operations)
        // This method works only for integer types and can lead to overflow if numbers are very large.
        x = x + y; // x now becomes 30 (10 + 20)
        y = x - y; // y now becomes 10 (30 - 20)
        x = x - y; // x now becomes 20 (30 - 10)

        System.out.println("\nAfter swapping (Method 2 - without temp variable):");
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        // Reset values for Method 3
        x = 10;
        y = 20;

        // Method 3: Without using a temporary variable (bitwise XOR operator)
        // This method works for integer types and is generally more efficient than arithmetic operations.
        x = x ^ y; // x becomes 10 ^ 20 = 00001010 ^ 00010100 = 00011110 (30)
        y = x ^ y; // y becomes 30 ^ 20 = 00011110 ^ 00010100 = 00001010 (10)
        x = x ^ y; // x becomes 30 ^ 1
        System.out.println("\nAfter swapping (Method 3 - bitwise XOR operator):");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

}
