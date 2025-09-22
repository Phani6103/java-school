package advancedfoundations;

/*
 * Big O notitation
 Fastest → Slowest
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2^n) < O(n!)

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

       // O(n^2) - Quadratic Time Complexity
    // Example: Nested loops, Bubble Sort, Selection Sort, Insertion Sort
    public void on2(int[] arr) {
        System.out.println("O(n^2) Example: Nested loops (e.g., Bubble Sort conceptual).");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // System.out.print("(" + arr[i] + "," + arr[j] + ") "); // Example operation
            }
        }
        System.out.println("Completed O(n^2) operation.");
    }

    // O(2^n) - Exponential Time Complexity
    // Example: Recursive calculation of Fibonacci numbers without memoization
    public int o2n(int n) {
        System.out.println("O(2^n) Example: Recursive Fibonacci (very inefficient for large n).");
        if (n <= 1) {
            return n;
        }
        return o2n(n - 1) + o2n(n - 2);
    }

    // O(n!) - Factorial Time Complexity
    // Example: Traveling Salesperson Problem (brute force), permutations
    public void onFactorial(int n) {
        System.out.println("O(n!) Example: Generating permutations (conceptual).");
        // This is a placeholder as actual O(n!) implementation is complex and rarely used directly
        // for simple examples due to rapid growth.
        System.out.println("For n=" + n + ", a factorial operation would be extremely slow.");
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

        System.out.println("\n--- O(n^2) Example ---");
        bigONotation.on2(arr);

        System.out.println("\n--- O(2^n) Example (Fibonacci) ---");
        int fibN = 5; // Keep n small for O(2^n)
        System.out.println("Fibonacci for n=" + fibN + ": " + bigONotation.o2n(fibN));
    }
    
}
