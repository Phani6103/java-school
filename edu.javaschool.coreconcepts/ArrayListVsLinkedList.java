import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        final int NUM_ELEMENTS = 10_000_000;

        // --- ArrayList Demonstration ---
        System.out.println("--- ArrayList Demonstration ---");
        List<String> arrayList = new ArrayList<>();

        long startTime = System.nanoTime();
        // Adding elements to the end (amortized O(1) - fast)
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            arrayList.add("Element" + i);
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList add to end (" + NUM_ELEMENTS + " elements): " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        // Accessing elements by index (O(1) - very fast)
        String element = arrayList.get(NUM_ELEMENTS / 2);
        endTime = System.nanoTime();
        System.out.println("ArrayList get by index (middle): " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        // Adding elements to the beginning (O(n) - slow, requires shifting all elements)
        arrayList.add(0, "New Element 0");
        endTime = System.nanoTime();
        System.out.println("ArrayList add to beginning: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        // Removing elements from the beginning (O(n) - slow, requires shifting all elements)
        arrayList.remove(0);
        endTime = System.nanoTime();
        System.out.println("ArrayList remove from beginning: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        // Removing elements from the end (O(1) - fast)
        arrayList.remove(arrayList.size() - 1);
        endTime = System.nanoTime();
        System.out.println("ArrayList remove from end: " + (endTime - startTime) / 1_000_000 + " ms");

        // --- LinkedList Demonstration ---
        System.out.println("\n--- LinkedList Demonstration ---");
        List<String> linkedList = new LinkedList<>();

        startTime = System.nanoTime();
        // Adding elements to the end (O(1) - fast)
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            linkedList.add("Element" + i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList add to end (" + NUM_ELEMENTS + " elements): " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        // Accessing elements by index (O(n) - slow, requires traversal)
        element = linkedList.get(NUM_ELEMENTS / 2);
        endTime = System.nanoTime();
        System.out.println("LinkedList get by index (middle): " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        // Adding elements to the beginning (O(1) - very fast)
        linkedList.add(0, "New Element 0"); // Using the List interface method
        endTime = System.nanoTime();
        System.out.println("LinkedList add to beginning: " + (endTime - startTime) / 1_000_000 + " ms");
        
        startTime = System.nanoTime();
        // Removing elements from the beginning (O(1) - very fast)
        linkedList.remove(0); // Using the List interface method
        endTime = System.nanoTime();
        System.out.println("LinkedList remove from beginning: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        // Removing elements from the end (O(1) - very fast)
        linkedList.remove(linkedList.size() - 1); // Using the List interface method
        endTime = System.nanoTime();
        System.out.println("LinkedList remove from end: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
