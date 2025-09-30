package edu.javaschool.core_concepts.challenges.datastructures;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {
    private static int[] removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        // Using a temporary array and two pointers for in-place modification (if sorted)
        // Or using a Set for unsorted arrays (more general approach)
        java.util.Set<Integer> uniqueElements = new java.util.LinkedHashSet<>();
        for (int element : arr) {
            uniqueElements.add(element);
        }

        int[] result = new int[uniqueElements.size()];
        int i = 0;
        for (int element : uniqueElements) {
            result[i++] = element;
        }
        return result;
    }

    // Optimized for sorted arrays (in-place modification)
    private static int[] removeDuplicatesSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        // First, sort the array if it's not already sorted
        java.util.Arrays.sort(arr);
        System.out.println("Sorted Array: "+Arrays.toString(arr));

        int j = 0; // Pointer for the unique elements array
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("Step:: i:"+arr[i]+" i+1:"+arr[(i+1)]);
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[arr.length - 1]; // Add the last unique element
        System.out.println("removed duplicates: "+Arrays.toString(arr));

        // Create a new array with only unique elements
        int[] result = new int[j];
        System.arraycopy(arr, 0, result, 0, j);
        return result;
    }
    
    public static void main(String[] args) {
        int[] testArray1 = {1, 7, 7, 2, 2, 3, 5, 8, 4, 4, 5, 6, 6, 7};
        System.out.println("Original Array (Sorted): " + java.util.Arrays.toString(testArray1));
        int[] uniqueArraySorted = removeDuplicatesSorted(testArray1);
        System.out.println("Array after removing duplicates (Sorted Optimized): " + java.util.Arrays.toString(uniqueArraySorted));

        int[] testArray2 = {10, 3, 4, 54, 12, 6, 8, 3, 10, 4};
        System.out.println("Original Array (Unsorted): " + java.util.Arrays.toString(testArray2));
        int[] uniqueArray = removeDuplicates(testArray2);
        System.out.println("Array after removing duplicates (Using Set): " + java.util.Arrays.toString(uniqueArray));
        
        
    }
}
