package w3Schools;

/**
 * A class that demonstrates how to reverse an integer.
 */
public class ReverseANumber {

    /**
     * Reverses the digits of an integer.
     *
     * @param number The integer to reverse.
     * @return The reversed integer.
     */
    public static int reverse(int number) {
        int reversed = 0;
        int originalNumber = number; // Keep original for potential overflow checks or logging

        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            reversed = reversed * 10 + digit;
            originalNumber /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int number = 12345;
        int reversed = reverse(number);
        System.out.println("Reversed number: " + reversed);
    }
}
