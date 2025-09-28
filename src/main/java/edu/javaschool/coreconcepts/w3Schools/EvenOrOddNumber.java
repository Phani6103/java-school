package w3Schools;

public class EvenOrOddNumber {
    public static void main(String[] args) {
        int number = 10; // You can change this number to test
        
        if (number % 2 == 0) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }

        number = 7; // Another example
        if (number % 2 == 0) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }
    }

}
