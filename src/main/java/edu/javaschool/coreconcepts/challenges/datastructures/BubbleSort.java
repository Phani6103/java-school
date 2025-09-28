package challenges.datastructures;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        // [10, 3, 4, 54, 12, 6, 8]
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(12, 3, 4, 6, 15, 22));
        System.out.println("Before Sorting");
        for (int item : unsortedList) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Bubble Sort implementation
        int n = unsortedList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.println("Step i: "+ i + " j: "+ j);
                if (unsortedList.get(j) > unsortedList.get(j + 1)) {
                    // Swap elements
                    int temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(j + 1));
                    unsortedList.set(j + 1, temp);
                    System.out.println(unsortedList);
                }
            }
        }

        System.out.println("After Sorting");
        for (int item : unsortedList) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
