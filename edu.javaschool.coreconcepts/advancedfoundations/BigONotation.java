package advancedfoundations;

/*
 * Big O notitation
 */
public class BigONotation {
    // O(1) - Constant Time Complexity
    public void o1(int[] arr) {
        System.out.println("O(1) Example: Accessing the first element.");
        if (arr.length > 0) {
            System.out.println(arr[0]);
        }
    }

    // O(log n) - Logarithmic Time Complexity
    // Example: Binary Search
    public int ologn(int[] sortedArr, int target) {
        System.out.println("O(log n) Example: Binary Search.");
        int low = 0;
        int high = sortedArr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] == target) {
                return mid;
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Not found
    }

    // O(n) - Linear Time Complexity
    public void on(int[] arr) {
        System.out.println("O(n) Example: Iterating through an array.");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // O(n log n) - Linearithmic Time Complexity
    // Example: Merge Sort, Quick Sort
    public void onlogn(int[] arr) {
        System.out.println("O(n log n) Example: Sorting an array (conceptual, not actual sort implementation).");
        // A real O(n log n) sort would be more complex, e.g., Merge Sort.
        // This is just to illustrate the concept.
        java.util.Arrays.sort(arr); // Java's Arrays.sort for primitives is typically O(n log n)
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BigONotation bigONotation = new BigONotation();
        int[] arr = {1, 2, 3, 4, 5};
        bigONotation.o1(arr);
        int target = 3;
        int result = bigONotation.ologn(arr, target);
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found.");
        }
        bigONotation.on(arr);
        bigONotation.onlogn(arr);
    }
    
}
