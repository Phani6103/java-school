package w3Schools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 2, 7, 8, 8, 3, 2};
        System.out.println("Original array: " + java.util.Arrays.toString(numbers));
        System.out.print("Duplicate elements: ");
        findDuplicatesUsingBruteForce(numbers);
        System.out.println("\nDuplicate elements (using HashSet): ");
        findDuplicatesUsingHashSet(numbers);
    }

    // Brute-force approach
    public static void findDuplicatesUsingBruteForce(int[] arr) {
        // Convert int[] to List<Integer> for easier removal, though this approach is inefficient.
        // A better brute-force would be to use a boolean array or just print and not modify the original list.
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr.length == arr.length) {
                    System.out.print(arr.length + " ");
                }
            }
        }
        System.out.println();
    }

    // Using HashSet for a more efficient approach
    public static void findDuplicatesUsingHashSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int number : arr) {
            if (!seen.add(number)) { // If add returns false, the element was already in the set
                duplicates.add(number);
            }
        }

        for (int duplicate : duplicates) {
            System.out.print(duplicate + " ");
        }
    }
}
