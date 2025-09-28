package advancedfoundations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    ================================================================================
    MEGA JAVA COLLECTIONS CHEAT SHEET
    ================================================================================

    | Data Structure   | Find/Search             | Insert/Add                         | Delete/Remove                     | Access (index/key) | Order Maintained? | Real-World Analogy              | When to Use                                              | Code Snippet |
    |------------------|-------------------------|------------------------------------|-----------------------------------|-------------------|------------------|---------------------------------|---------------------------------------------------------|--------------|
    | **ArrayList**    | O(n)                    | Amortized O(1) at end, O(n) middle | O(n)                              | O(1)              | ✅ Insertion order | 📚 Bookshelf with numbered slots | Fast random access, append-heavy operations             | List<String> list = new ArrayList<>(); list.add("A"); list.add("B"); System.out.println(list.get(1)); |
    | **LinkedList**   | O(n)                    | O(1) at head/tail, O(n) arbitrary  | O(1) at head/tail, O(n) arbitrary | O(n)              | ✅ Insertion order | 🚋 Train coaches linked together | Frequent insertions/removals at ends                    | LinkedList<String> ll = new LinkedList<>(); ll.addFirst("A"); ll.addLast("B"); System.out.println(ll.removeFirst()); |
    | **HashSet**      | O(1) avg, O(n) worst    | O(1) avg                           | O(1) avg                          | N/A               | ❌ Unordered      | 🗃️ Unique ID cards in a box       | Fast membership checks, enforce uniqueness              | Set<String> set = new HashSet<>(); set.add("A"); set.add("B"); System.out.println(set.contains("B")); |
    | **LinkedHashSet**| O(1) avg                | O(1) avg                           | O(1) avg                          | N/A               | ✅ Insertion order | 🧾 Guest list at a party           | Uniqueness + predictable iteration order                | Set<String> lhs = new LinkedHashSet<>(); lhs.add("A"); lhs.add("B"); System.out.println(lhs); |
    | **TreeSet**      | O(log n)                | O(log n)                           | O(log n)                          | N/A               | ✅ Sorted order   | 📈 Sorted filing cabinet           | Always need sorted unique elements                      | Set<Integer> ts = new TreeSet<>(); ts.add(5); ts.add(1); System.out.println(ts); |
    | **HashMap**      | O(1) avg, O(n) worst    | O(1) avg                           | O(1) avg                          | O(1) avg          | ❌ Unordered      | 📖 Dictionary                      | Fast key-value lookups                                 | Map<String,Integer> map = new HashMap<>(); map.put("a",1); System.out.println(map.get("a")); |
    | **LinkedHashMap**| O(1) avg                | O(1) avg                           | O(1) avg                          | O(1) avg          | ✅ Insertion order | 🗂️ Ordered dictionary              | Key-value lookups + maintain insertion order            | Map<String,Integer> lhm = new LinkedHashMap<>(); lhm.put("a",1); lhm.put("b",2); System.out.println(lhm); |
    | **TreeMap**      | O(log n)                | O(log n)                           | O(log n)                          | O(log n)          | ✅ Sorted by key  | 🏛️ Library catalog sorted by title | Need sorted key-value pairs                             | Map<Integer,String> tm = new TreeMap<>(); tm.put(2,"B"); tm.put(1,"A"); System.out.println(tm); |
    | **PriorityQueue**| O(n) search             | O(log n)                           | O(log n)                          | O(1) peek         | ❌ Unordered      | 🏥 Hospital emergency room          | Always retrieve min/max efficiently                     | PriorityQueue<Integer> pq = new PriorityQueue<>(); pq.add(5); pq.add(1); System.out.println(pq.poll()); |
    | **Stack**        | O(n) search             | O(1) push                          | O(1) pop                          | O(n)              | ✅ LIFO order     | 🍽️ Stack of plates                 | Last-in-first-out behavior                              | Stack<Integer> st = new Stack<>(); st.push(10); st.push(20); System.out.println(st.pop()); |
    | **ArrayDeque**   | O(n) search             | O(1) at both ends                  | O(1) at both ends                 | N/A               | ✅ Insertion order | 🚪 Double-ended queue              | Efficient queue/deque operations                        | Deque<String> dq = new ArrayDeque<>(); dq.addFirst("X"); dq.addLast("Y"); System.out.println(dq.pollFirst()); |
    
    ================================================================================
    JAVA LIST TYPES - VISUAL EXPLANATION
    ================================================================================

    1. ArrayList
    ------------
    - Backed by a dynamic array (resizes when full).
    - ✅ Fast random access (get(i)).
    - ❌ Slow inserts/removes in the middle (needs shifting).

    Visual:
    Index:   0     1     2     3     4
    Value: [ A ] [ B ] [ C ] [ D ] [ E ]

    Access by index → instant (jump directly).
    Insert at middle → shift everything right.

    Use case: Product catalog, student roll numbers.

    --------------------------------------------------------------------------------

    2. LinkedList
    -------------
    - Doubly-linked nodes (each node points to next & previous).
    - ✅ Fast inserts/removes at head/tail.
    - ❌ Slow access by index (must traverse nodes).

    Visual:
    HEAD → [A] ⇄ [B] ⇄ [C] ⇄ [D] ⇄ [E] ← TAIL

    Access index 3 → walk through A → B → C → D.
    Insert in middle → just rewire pointers.

    Use case: Queue or playlist (frequent add/remove at ends).

    --------------------------------------------------------------------------------

    3. Vector (Legacy)
    ------------------
    - Like ArrayList, but thread-safe (all methods synchronized).
    - ✅ Safe in multithreaded scenarios.
    - ❌ Slower than ArrayList due to locking overhead.

    Visual:
    [LOCK] → [ A ] [ B ] [ C ] [ D ]

    Use case: Rarely used today; replaced by modern concurrent collections.

    --------------------------------------------------------------------------------

    4. Stack
    --------
    - Extends Vector. LIFO (Last In, First Out).
    - ✅ push(), pop() in O(1).

    Visual:
    Top
    ↑
    [ D ]
    [ C ]
    [ B ]
    [ A ]

    Use case: Undo/Redo, browser history, function call stack.

    --------------------------------------------------------------------------------

    Side-by-Side Comparison
    -----------------------
    | Feature          | ArrayList | LinkedList | Vector | Stack |
    |------------------|-----------|------------|--------|-------|
    | Access by index  | O(1)      | O(n)       | O(1)   | O(n)  |
    | Insert at end    | O(1)*     | O(1)       | O(1)*  | O(1)  |
    | Insert in middle | O(n)      | O(n)       | O(n)   | N/A   |
    | Insert at head   | O(n)      | O(1)       | O(n)   | N/A   |
    | Thread-safe      | ❌        | ❌          | ✅      | ✅    |
    | Best for         | Random access | Frequent add/remove | Legacy MT | LIFO |

    * = Amortized (due to resizing)

    --------------------------------------------------------------------------------

    Real-World Analogies
    --------------------
    - ArrayList = 📚 Bookshelf (numbered slots, fast access, shifting is hard).
    - LinkedList = 🚋 Train (walk coach by coach, easy add/remove).
    - Vector = 📚 Bookshelf with a lock 🔒 (thread-safe).
    - Stack = 🍽️ Plate stack (last plate added is first removed).
    ================================================================================
*/



public class BigONotationByDataStructures {

    // Write a function that will return the response of the dataStructure explaining how the BigONotation value given for it.
    // Example: ArrayList with Find/search is O(n). Will write a code to prove that.
    public static void arraylist() {
        
        // Create and fill ArrayList
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");

        // 1. Access by index -> O(1)
        String fruit = list.get(2); // Directly fetch element at index 2
        System.out.println("Element at index 2: " + fruit);

        // 2. Search by value -> O(n)
        boolean hasMango = list.contains("Mango"); // must scan entire list
        boolean hasCherry = list.contains("Cherry"); // may find earlier
        System.out.println("Contains Mango? " + hasMango);
        System.out.println("Contains Cherry? " + hasCherry);

        // 3. Show how indexOf() works -> O(n)
        int index = list.indexOf("Date");
        System.out.println("Index of Date: " + index);

        // --- When to Use ArrayList (and when not to) ---
        System.out.println("\n--- When to Use ArrayList (and when not to) ---");

        // GOOD FIT: When you need fast random access by index.
        // Analogy: A numbered bookshelf. Getting the 5th book is instant.
        System.out.println("\n**Good Fit Example: A list of students in numbered seats.**");
        List<String> students = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "David"));
        System.out.println("Students: " + students);
        // Fast O(1) access: "Who is in seat #2?"
        System.out.println("Student in seat #2 is: " + students.get(2));
        // Fast amortized O(1) add at the end: "A new student, Eve, takes the last seat."
        students.add("Eve");
        System.out.println("After Eve joins: " + students);

        // BAD FIT: When you frequently add or remove elements from the beginning or middle.
        // Analogy: A line at a ticket counter. When the first person leaves, everyone has to step forward.
        System.out.println("\n**Bad Fit Example: A queue of people waiting for a service.**");
        // Using ArrayList for a queue is inefficient.
        List<String> queue = new ArrayList<>(List.of("Person1", "Person2", "Person3", "Person4"));
        System.out.println("Initial queue: " + queue);
        // Slow O(n) removal from the front: "Serve the first person."
        // This requires shifting Person2, Person3, and Person4 one position to the left.
        // For a large list, this is very slow.
        String servedPerson = queue.remove(0);
        System.out.println("Served: " + servedPerson);
        System.out.println("Updated queue: " + queue);
        System.out.println("For this 'queue' scenario, a LinkedList or ArrayDeque would be much more efficient.");

        // --- ArrayList Large Scale Demonstration (10 Million Records) ---
        System.out.println("\n--- ArrayList Large Scale Demonstration (10 Million Records) ---");
        final int LARGE_NUMBER_OF_ELEMENTS = 10_000_000;
        List<String> largeList = new ArrayList<>();

        // 1. Add 10 Million records to the end: Amortized O(1) - Should be fast
        // We are just adding to the end of the internal array. It's fast because there's no need to shift existing elements.
        // Occasionally, the array resizes (an O(n) operation), but this happens so rarely that the average time is O(1).
        long startTime = System.nanoTime();
        for (int i = 0; i < LARGE_NUMBER_OF_ELEMENTS; i++) {
            largeList.add("Element" + i);
        }
        long endTime = System.nanoTime();
        System.out.printf("1. Add %d elements to end (Amortized O(1)): %,d ms%n", LARGE_NUMBER_OF_ELEMENTS, (endTime - startTime) / 1_000_000);

        // 2. Add an element to the beginning: O(n) - Should be very slow
        // To add an element at index 0, all existing elements must be shifted one position to the right.
        startTime = System.nanoTime();
        largeList.add(0, "New First Element");
        endTime = System.nanoTime();
        System.out.printf("2. Add ONE element to beginning (O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);

        // 3. Add 1000 elements to the beginning: O(k*n) - Should be extremely slow
        // Each add(0,...) is O(n), so doing it 1000 times is very costly.
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            largeList.add(0, "New Element" + i);
        }
        endTime = System.nanoTime();
        System.out.printf("3. Add 1000 elements to beginning (k * O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);

        // 4. Add element to the middle: O(n) - Should be slow
        // Must shift all elements from the middle to the end.
        startTime = System.nanoTime();
        largeList.add(largeList.size() / 2, "New Middle Element");
        endTime = System.nanoTime();
        System.out.printf("4. Add ONE element to middle (O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);

        // 5. Get by index: O(1) - Should be extremely fast
        // ArrayList can calculate the memory address and jump directly to the index.
        startTime = System.nanoTime();
        String middleElement = largeList.get(largeList.size() / 2);
        endTime = System.nanoTime();
        System.out.printf("5. Get by index from middle (O(1)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 6. Search by Value (worst case): O(n) - Should be slow
        // Must scan the list from the beginning.
        startTime = System.nanoTime();
        boolean found = largeList.contains("NonExistentElement");
        endTime = System.nanoTime();
        System.out.printf("6. Search for element by value (O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);

        // 7. Remove an element by index in the middle: O(n) - Should be slow
        // Must shift all elements from the middle to the end to fill the gap.
        startTime = System.nanoTime();
        largeList.remove(largeList.size() / 2);
        endTime = System.nanoTime();
        System.out.printf("7. Remove element by index from middle (O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);

        // 8. Remove an element by value in the middle: O(n) - Should be slow
        // This is O(n) for two reasons: first it has to find the element (O(n)), then it has to shift the remaining elements (O(n)).
        startTime = System.nanoTime();
        largeList.remove("Element" + LARGE_NUMBER_OF_ELEMENTS / 2);
        endTime = System.nanoTime();
        System.out.printf("8. Remove element by value from middle (O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);
    }

    public static void linkedlist() {
        // --- LinkedList Large Scale Demonstration (10 Million Records) ---
        System.out.println("\n--- LinkedList Large Scale Demonstration (10 Million Records) ---");
        final int LARGE_NUMBER_OF_ELEMENTS = 10_000_000;
        LinkedList<String> largeLinkedList = new LinkedList<>();

        // 1. Add 10 Million records to the end: O(1) - Should be fast
        // LinkedList maintains pointers to its head and tail, so adding to the end is a direct operation.
        long startTime = System.nanoTime();
        for (int i = 0; i < LARGE_NUMBER_OF_ELEMENTS; i++) {
            largeLinkedList.addLast("Element" + i);
        }
        long endTime = System.nanoTime();
        System.out.printf("1. Add %d elements to end (O(1)): %,d ms%n", LARGE_NUMBER_OF_ELEMENTS, (endTime - startTime) / 1_000_000);

        // 2. Add an element to the beginning: O(1) - Should be extremely fast
        // Similar to adding to the end, LinkedList has a direct pointer to the head.
        startTime = System.nanoTime();
        largeLinkedList.addFirst("New First Element");
        endTime = System.nanoTime();
        System.out.printf("2. Add ONE element to beginning (O(1)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 3. Add 1000 elements to the beginning: O(k) - Should be very fast
        // Each addFirst is O(1), so this is not dependent on the list size 'n'.
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            largeLinkedList.addFirst("New Element" + i);
        }
        endTime = System.nanoTime();
        System.out.printf("3. Add 1000 elements to beginning (k * O(1)): %,d ms%n", (endTime - startTime) / 1_000_000);

        // 4. Add element to the middle: O(n) - Should be slow
        // Must traverse half the list to find the insertion point.
        startTime = System.nanoTime();
        largeLinkedList.add(largeLinkedList.size() / 2, "New Middle Element");
        endTime = System.nanoTime();
        System.out.printf("4. Add ONE element to middle (O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);

        // 5. Get by index (middle): O(n) - Should be slow
        // To get an element by index, LinkedList must traverse from the head or tail.
        startTime = System.nanoTime();
        String middleElement = largeLinkedList.get(LARGE_NUMBER_OF_ELEMENTS / 2);
        endTime = System.nanoTime();
        System.out.printf("5. Get by index from middle (O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);

        // 6. Search by Value (worst case): O(n) - Should be slow
        // Must scan the list from the beginning.
        startTime = System.nanoTime();
        boolean found = largeLinkedList.contains("NonExistentElement");
        endTime = System.nanoTime();
        System.out.printf("6. Search for element by value (O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);

        // 7. Remove an element by index in the middle: O(n) - Should be slow
        // Must traverse half the list to find the element to remove.
        startTime = System.nanoTime();
        largeLinkedList.remove(largeLinkedList.size() / 2);
        endTime = System.nanoTime();
        System.out.printf("7. Remove element by index from middle (O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);

        // 8. Remove an element by value in the middle: O(n) - Should be slow
        // Must traverse the list to find the element to remove.
        startTime = System.nanoTime();
        largeLinkedList.remove("Element" + LARGE_NUMBER_OF_ELEMENTS / 2);
        endTime = System.nanoTime();
        System.out.printf("8. Remove element by value from middle (O(n)): %,d ms%n", (endTime - startTime) / 1_000_000);
    }

    public static void treeSet() {
        /*
            Add 10 Million records to the end
            Add an element to the beginning
            Add 1000 elements to the beginning
            Add element to the middle
            Get by index
            Seach by Value
            remove an element by index in the middle somwhere
            remove an element by value in the middle somewhere/
         */
        System.out.println("\n--- TreeSet Large Scale Demonstration (10 Million Records) ---");
        final int LARGE_NUMBER_OF_ELEMENTS = 10_000_000;
        Set<Integer> largeTreeSet = new java.util.TreeSet<>();

        // 1. Add 10 Million records: O(log n) - Should be slower than HashSet but still reasonable
        // Adding elements to a TreeSet involves maintaining a balanced binary search tree.
        // Each insertion requires traversing the tree, which is O(log n).
        long startTime = System.nanoTime();
        for (int i = 0; i < LARGE_NUMBER_OF_ELEMENTS; i++) {
            largeTreeSet.add(i);
        }
        long endTime = System.nanoTime();
        System.out.printf("1. Add %d elements (O(log n)): %,d ms%n", LARGE_NUMBER_OF_ELEMENTS, (endTime - startTime) / 1_000_000);

        // 2. Add an element (already present): O(log n) - Should be fast
        // TreeSet checks for existence by traversing the tree.
        startTime = System.nanoTime();
        largeTreeSet.add(LARGE_NUMBER_OF_ELEMENTS / 2); // Add an existing element
        endTime = System.nanoTime();
        System.out.printf("2. Add existing element (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 3. Add a new element: O(log n) - Should be fast
        startTime = System.nanoTime();
        largeTreeSet.add(LARGE_NUMBER_OF_ELEMENTS + 1);
        endTime = System.nanoTime();
        System.out.printf("3. Add new unique element (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 4. Get by index: N/A for TreeSet (it's a Set, not a List)
        System.out.println("4. Get by index: N/A for TreeSet (ordered by value, not index)");

        // 5. Search by Value (contains): O(log n) - Should be very
        startTime = System.nanoTime();
        boolean found = largeTreeSet.contains(LARGE_NUMBER_OF_ELEMENTS / 2);
        endTime = System.nanoTime();
        System.out.printf("5. Search for element by value (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 6. Remove an element: O(log n) - Should be fast
        startTime = System.nanoTime();
        largeTreeSet.remove(LARGE_NUMBER_OF_ELEMENTS / 2);
        endTime = System.nanoTime();
        System.out.printf("6. Remove element by value (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 7. Remove a non-existent element: O(log n) - Should be fast
        startTime = System.nanoTime();
        largeTreeSet.remove(LARGE_NUMBER_OF_ELEMENTS + 2);
        endTime = System.nanoTime();
        System.out.printf("7. Remove non-existent element by value (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));
        
        // 8. Iterate through elements (in sorted order): O(n) - Should be reasonable
        // Iteration order is guaranteed to be ascending order of the elements.
        startTime = System.nanoTime();
        int count = 0;
        for (Integer element : largeTreeSet) {
            count++;
            if (count > 10) break; // Just print first few to avoid massive output
        }
        endTime = System.nanoTime();
        System.out.printf("8. Iterate through first 10 elements (O(n) for full iteration): %,d ns (nanoseconds)%n", (endTime - startTime));

    }

    public static void hashSet() {
        /*
         *  Add 10 Million records to the end
            Add an element to the beginning
            Add 1000 elements to the beginning
            Add element to the middle
            Get by index
            Seach by Value
            remove an element by index in the middle somwhere
            remove an element by value in the middle somewhere
         */
        // 
        System.out.println("\n--- HashSet Large Scale Demonstration (10 Million Records) ---");
        final int LARGE_NUMBER_OF_ELEMENTS = 10_000_000;
        Set<String> largeHashSet = new java.util.HashSet<>();

        // 1. Add 10 Million records: O(1) average - Should be fast
        // Adding elements to a HashSet involves calculating a hash code and placing the element in a bucket.
        // On average, this is O(1). Worst case (hash collisions) can be O(n).
        long startTime = System.nanoTime();
        for (int i = 0; i < LARGE_NUMBER_OF_ELEMENTS; i++) {
            largeHashSet.add("Element" + i);
        }
        long endTime = System.nanoTime();
        System.out.printf("1. Add %d elements (O(1) avg): %,d ms%n", LARGE_NUMBER_OF_ELEMENTS, (endTime - startTime) / 1_000_000);

        // 2. Add an element (already present): O(1) average - Should be fast
        // HashSet checks for existence using hash code and equals method.
        startTime = System.nanoTime();
        largeHashSet.add("Element" + (LARGE_NUMBER_OF_ELEMENTS / 2)); // Add an existing element
        endTime = System.nanoTime();
        System.out.printf("2. Add existing element (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 3. Add a new element: O(1) average - Should be fast
        startTime = System.nanoTime();
        largeHashSet.add("New Unique Element");
        endTime = System.nanoTime();
        System.out.printf("3. Add new unique element (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 4. Get by index: N/A for HashSet
        System.out.println("4. Get by index: N/A for HashSet (unordered collection)");

        // 5. Search by Value (contains): O(1) average - Should be extremely fast
        // This is the primary strength 
        startTime = System.nanoTime();
        boolean found = largeHashSet.contains("Element" + (LARGE_NUMBER_OF_ELEMENTS / 2));
        endTime = System.nanoTime();
        System.out.printf("5. Search for element by value (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 6. Search for non-existent element by value (contains): O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        boolean notFound = largeHashSet.contains("NonExistentElement");
        endTime = System.nanoTime();
        System.out.printf("6. Search for non-existent element by value (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 7. Remove an element by value: O(1) average - Should be extremely fast
        // Similar to contains, removal uses hash code and equals.
        startTime = System.nanoTime();
        largeHashSet.remove("Element" + (LARGE_NUMBER_OF_ELEMENTS / 2));
        endTime = System.nanoTime();
        System.out.printf("7. Remove element by value (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 8. Remove a non-existent element: O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        largeHashSet.remove("AnotherNonExistentElement");
        endTime = System.nanoTime();
        System.out.printf("8. Remove non-existent element by value (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));
        
    }

    public static void linkedHashSet() {
    /*       
        Add 10 Million records to the end
        Add an element to the beginning
        Add 1000 elements to the beginning
        Add element to the middle
        Get by index
        Seach by Value
        remove an element by index in the middle somwhere
        remove an element by value in the middle somewhere
    * */
        System.out.println("\n--- LinkedHashSet Large Scale Demonstration (10 Million Records) ---");
        final int LARGE_NUMBER_OF_ELEMENTS = 10_000_000;
        Set<String> largeLinkedHashSet = new java.util.LinkedHashSet<>();

        // 1. Add 10 Million records: O(1) average - Should be fast
        // LinkedHashSet maintains a hash table for O(1) average time complexity for add, contains, remove,
        // and a doubly-linked list for maintaining insertion order.
        long startTime = System.nanoTime();
        for (int i = 0; i < LARGE_NUMBER_OF_ELEMENTS; i++) {
            largeLinkedHashSet.add("Element" + i);
        }
        long endTime = System.nanoTime();
        System.out.printf("1. Add %d elements (O(1) avg): %,d ms%n", LARGE_NUMBER_OF_ELEMENTS, (endTime - startTime) / 1_000_000);

        // 2. Add an element (already present): O(1) average - Should be fast
        startTime = System.nanoTime();
        largeLinkedHashSet.add("Element" + (LARGE_NUMBER_OF_ELEMENTS / 2)); // Add an existing element
        endTime = System.nanoTime();
        System.out.printf("2. Add existing element (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 3. Add a new element: O(1) average - Should be fast
        startTime = System.nanoTime();
        largeLinkedHashSet.add("New Unique Element Linked");
        endTime = System.nanoTime();
        System.out.printf("3. Add new unique element (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 4. Get by index: N/A for LinkedHashSet
        System.out.println("4. Get by index: N/A for LinkedHashSet (unordered collection, but maintains insertion order for iteration)");

        // 5. Search by Value (contains): O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        boolean found = largeLinkedHashSet.contains("Element" + (LARGE_NUMBER_OF_ELEMENTS / 2));
        endTime = System.nanoTime();
        System.out.printf("5. Search for element by value (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 6. Search for non-existent element by value (contains): O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        boolean notFound = largeLinkedHashSet.contains("NonExistentElementLinked");
        endTime = System.nanoTime();
        System.out.printf("6. Search for non-existent element by value (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 7. Remove an element by value: O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        largeLinkedHashSet.remove("Element" + (LARGE_NUMBER_OF_ELEMENTS / 2));
        endTime = System.nanoTime();
        System.out.printf("7. Remove element by value (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 8. Remove a non-existent element: O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        largeLinkedHashSet.remove("AnotherNonExistentElementLinked");
        endTime = System.nanoTime();
        System.out.printf("8. Remove non-existent element by value (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));
    }

    public static void hashMap() {
    /*
        Add 10 Million records to the end
        Add an element to the beginning
        Add 1000 elements to the beginning
        Add element to the middle
        Get by index
        Seach by Value
        remove an element by index in the middle somwhere
        remove an element by value in the middle somewhere
    */
        System.out.println("\n--- HashMap Large Scale Demonstration (10 Million Records) ---");
        final int LARGE_NUMBER_OF_ELEMENTS = 10_000_000;
        Map<String,String> largeHashMap = new java.util.HashMap<>();

        // 1. Add 10 Million records: O(1) average - Should be fast
        long startTime = System.nanoTime();
        for (int i = 0; i < LARGE_NUMBER_OF_ELEMENTS; i++) {
            largeHashMap.put("Key" + i, "Value" + i);
        }
        long endTime = System.nanoTime();
        System.out.printf("1. Add %d elements (O(1) avg): %,d ms%n", LARGE_NUMBER_OF_ELEMENTS, (endTime - startTime) / 1_000_000);

        // 2. Update an existing element: O(1) average - Should be fast
        startTime = System.nanoTime();
        largeHashMap.put("Key" + (LARGE_NUMBER_OF_ELEMENTS / 2), "UpdatedValue");
        endTime = System.nanoTime();
        System.out.printf("2. Update existing element (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 3. Add a new element: O(1) average - Should be fast
        startTime = System.nanoTime();
        largeHashMap.put("NewKey", "NewValue");
        endTime = System.nanoTime();
        System.out.printf("3. Add new unique element (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 4. Get by key: O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        String value = largeHashMap.get("Key" + (LARGE_NUMBER_OF_ELEMENTS / 2));
        endTime = System.nanoTime();
        System.out.printf("4. Get by key (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 5. Check for existence of key (containsKey): O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        boolean containsKey = largeHashMap.containsKey("Key" + (LARGE_NUMBER_OF_ELEMENTS / 4));
        endTime = System.nanoTime();
        System.out.printf("5. Check containsKey (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 6. Check for existence of value (containsValue): O(n) - Can be slow
        // This requires iterating through all values.
        startTime = System.nanoTime();
        boolean containsValue = largeHashMap.containsValue("NonExistentValue");
        endTime = System.nanoTime();
        System.out.printf("6. Check containsValue (O(n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 7. Remove an element by key: O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        largeHashMap.remove("Key" + (LARGE_NUMBER_OF_ELEMENTS / 2));
        endTime = System.nanoTime();
        System.out.printf("7. Remove element by key (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 8. Remove a non-existent element: O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        largeHashMap.remove("NonExistentKey");
        endTime = System.nanoTime();
        System.out.printf("8. Remove non-existent element by key (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));
    }

    public static void linkedHashMap() {
        /*
            Add 10 Million records to the end
            Add an element to the beginning
            Add 1000 elements to the beginning
            Add element to the middle
            Get by index
            Seach by Value
            remove an element by index in the middle somwhere
            remove an element by value in the middle somewhere
        */
        System.out.println("\n--- LinkedHashMap Large Scale Demonstration (10 Million Records) ---");
        final int LARGE_NUMBER_OF_ELEMENTS = 10_000_000;
        Map<String,String> largeLinkedHashMap = new java.util.LinkedHashMap<>();

        // 1. Add 10 Million records: O(1) average - Should be fast
        // LinkedHashMap maintains a hash table for O(1) average time complexity for put, get, remove,
        // and a doubly-linked list for maintaining insertion order (or access order if configured).
        long startTime = System.nanoTime();
        for (int i = 0; i < LARGE_NUMBER_OF_ELEMENTS; i++) {
            largeLinkedHashMap.put("Key" + i, "Value" + i);
        }
        long endTime = System.nanoTime();
        System.out.printf("1. Add %d elements (O(1) avg): %,d ms%n", LARGE_NUMBER_OF_ELEMENTS, (endTime - startTime) / 1_000_000);

        // 2. Update an existing element: O(1) average - Should be fast
        startTime = System.nanoTime();
        largeLinkedHashMap.put("Key" + (LARGE_NUMBER_OF_ELEMENTS / 2), "UpdatedValueLinked");
        endTime = System.nanoTime();
        System.out.printf("2. Update existing element (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 3. Add a new element: O(1) average - Should be fast
        startTime = System.nanoTime();
        largeLinkedHashMap.put("NewKeyLinked", "NewValueLinked");
        endTime = System.nanoTime();
        System.out.printf("3. Add new unique element (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 4. Get by key: O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        String value = largeLinkedHashMap.get("Key" + (LARGE_NUMBER_OF_ELEMENTS / 2));
        endTime = System.nanoTime();
        System.out.printf("4. Get by key (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 5. Check for existence of key (containsKey): O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        boolean containsKey = largeLinkedHashMap.containsKey("Key" + (LARGE_NUMBER_OF_ELEMENTS / 4));
        endTime = System.nanoTime();
        System.out.printf("5. Check containsKey (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 6. Check for existence of value (containsValue): O(n) - Can be slow
        // This requires iterating through all values.
        startTime = System.nanoTime();
        boolean containsValue = largeLinkedHashMap.containsValue("NonExistentValueLinked");
        endTime = System.nanoTime();
        System.out.printf("6. Check containsValue (O(n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 7. Remove an element by key: O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        largeLinkedHashMap.remove("Key" + (LARGE_NUMBER_OF_ELEMENTS / 2));
        endTime = System.nanoTime();
        System.out.printf("7. Remove element by key (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 8. Remove a non-existent element: O(1) average - Should be extremely fast
        startTime = System.nanoTime();
        largeLinkedHashMap.remove("NonExistentKeyLinked");
        endTime = System.nanoTime();
        System.out.printf("8. Remove non-existent element by key (O(1) avg): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 9. Iterate through elements (in insertion order): O(n) - Should be reasonable
        // This is a key feature of LinkedHashMap.
        startTime = System.nanoTime();
        int count = 0;
        for (Map.Entry<String, String> entry : largeLinkedHashMap.entrySet()) {
            count++;
            if (count > 10) break; // Just print first few to avoid massive output
        }
        endTime = System.nanoTime();
        System.out.printf("9. Iterate through first 10 elements (O(n) for full iteration): %,d ns (nanoseconds)%n", (endTime - startTime));
    }

    public static void treeMap() {
        /*
            Add 10 Million records to the end
            Add an element to the beginning
            Add 1000 elements to the beginning
            Add element to the middle
            Get by index
            Seach by Value
            remove an element by index in the middle somwhere
            remove an element by value in the middle somewhere
        */
        System.out.println("\n--- TreeMap Large Scale Demonstration (10 Million Records) ---");
        final int LARGE_NUMBER_OF_ELEMENTS = 10_000_000;
        Map<Integer, String> largeTreeMap = new java.util.TreeMap<>();

        // 1. Add 10 Million records: O(log n) - Should be slower than HashMap but still reasonable
        // Adding elements to a TreeMap involves maintaining a balanced binary search tree.
        // Each insertion requires traversing the tree, which is O(log n).
        long startTime = System.nanoTime();
        for (int i = 0; i < LARGE_NUMBER_OF_ELEMENTS; i++) {
            largeTreeMap.put(i, "Value" + i);
        }
        long endTime = System.nanoTime();
        System.out.printf("1. Add %d elements (O(log n)): %,d ms%n", LARGE_NUMBER_OF_ELEMENTS, (endTime - startTime) / 1_000_000);

        // 2. Update an existing element: O(log n) - Should be fast
        startTime = System.nanoTime();
        largeTreeMap.put(LARGE_NUMBER_OF_ELEMENTS / 2, "UpdatedValueTreeMap");
        endTime = System.nanoTime();
        System.out.printf("2. Update existing element (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 3. Add a new element: O(log n) - Should be fast
        startTime = System.nanoTime();
        largeTreeMap.put(LARGE_NUMBER_OF_ELEMENTS + 1, "NewValueTreeMap");
        endTime = System.nanoTime();
        System.out.printf("3. Add new unique element (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 4. Get by key: O(log n) - Should be fast
        startTime = System.nanoTime();
        String value = largeTreeMap.get(LARGE_NUMBER_OF_ELEMENTS / 2);
        endTime = System.nanoTime();
        System.out.printf("4. Get by key (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 5. Check for existence of key (containsKey): O(log n) - Should be fast
        startTime = System.nanoTime();
        boolean containsKey = largeTreeMap.containsKey(LARGE_NUMBER_OF_ELEMENTS / 4);
        endTime = System.nanoTime();
        System.out.printf("5. Check containsKey (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 6. Check for existence of value (containsValue): O(n) - Can be slow
        // This requires iterating through all values.
        startTime = System.nanoTime();
        boolean containsValue = largeTreeMap.containsValue("NonExistentValueTreeMap");
        endTime = System.nanoTime();
        System.out.printf("6. Check containsValue (O(n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 7. Remove an element by key: O(log n) - Should be fast
        startTime = System.nanoTime();
        largeTreeMap.remove(LARGE_NUMBER_OF_ELEMENTS / 2);
        endTime = System.nanoTime();
        System.out.printf("7. Remove element by key (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 8. Remove a non-existent element: O(log n) - Should be fast
        startTime = System.nanoTime();
        largeTreeMap.remove(LARGE_NUMBER_OF_ELEMENTS + 2);
        endTime = System.nanoTime();
        System.out.printf("8. Remove non-existent element by key (O(log n)): %,d ns (nanoseconds)%n", (endTime - startTime));

        // 9. Iterate through elements (in sorted order by key): O(n) - Should be reasonable
        // Iteration order is guaranteed to be ascending order of the keys.
        startTime = System.nanoTime();
        int count = 0;
        for (Map.Entry<Integer, String> entry : largeTreeMap.entrySet()) {
            count++;
            if (count > 10) break; // Just print first few to avoid massive output
        }
        endTime = System.nanoTime();
        System.out.printf("9. Iterate through first 10 elements (O(n) for full iteration): %,d ns (nanoseconds)%n", (endTime - startTime));
    }




    public static void main(String[] args) {
        arraylist();
        linkedlist();
        hashSet();
        linkedHashSet();
        treeSet();
        hashMap();
        linkedHashMap();
        treeMap();
    }
}
