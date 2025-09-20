package advancedfoundations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class datastructures {
    // Write advancted types like HashMap, Set, Queue, Stack etc.
    /** Visual representation of the Hierarchy of dataStructures.
     * 
      Iterable
        ↑
        Collection
        ├── List
        │     ├── ArrayList, LinkedList, Vector, Stack
        │
        ├── Set
        │     ├── HashSet, LinkedHashSet, TreeSet, EnumSet
        │
        ├── Queue
        │     ├── PriorityQueue, ArrayDeque, LinkedList
        │
        └── Deque
                ├── ArrayDeque, LinkedList

        Map (separate, not extending Collection)
        ├── HashMap, LinkedHashMap, TreeMap, Hashtable, WeakHashMap, EnumMap
     */

    public static void main(String[] args) {
        // HashMap Example
        System.out.println("--- HashMap Example ---");
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 88);
        studentScores.put("Charlie", 92);
        System.out.println("Student Scores: " + studentScores);
        System.out.println("Alice's score: " + studentScores.get("Alice"));
        studentScores.put("Bob", 90); // Update Bob's score
        System.out.println("Updated Student Scores: " + studentScores);
        studentScores.remove("Charlie");
        System.out.println("Student Scores after removing Charlie: " + studentScores);
        System.out.println("Contains Bob? " + studentScores.containsKey("Bob"));
        System.out.println("Size of map: " + studentScores.size());

        // HashSet Example
        System.out.println("\n--- HashSet Example ---");
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("David");
        uniqueNames.add("Eve");
        uniqueNames.add("Frank");
        uniqueNames.add("David"); // Adding duplicate, will not be added
        System.out.println("Unique Names: " + uniqueNames);
        System.out.println("Contains Eve? " + uniqueNames.contains("Eve"));
        uniqueNames.remove("Frank");
        System.out.println("Unique Names after removing Frank: " + uniqueNames);
        System.out.println("Size of set: " + uniqueNames.size());

        // LinkedList (as a List) Example
        System.out.println("\n--- LinkedList (as a List) Example ---");
        LinkedList<String> shoppingList = new LinkedList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        shoppingList.add("Butter");
        System.out.println("Shopping List: " + shoppingList);
        System.out.println("First item: " + shoppingList.getFirst());
        System.out.println("Last item: " + shoppingList.getLast());
        shoppingList.addFirst("Sugar");
        shoppingList.addLast("Coffee");
        System.out.println("Updated Shopping List: " + shoppingList);
        shoppingList.removeFirst();
        shoppingList.removeLast();
        System.out.println("Updated Shopping List after removing first and last: " + shoppingList);
        System.out.println("Contains Bread? " + shoppingList.contains("Bread"));
        System.out.println("Size of list: " + shoppingList.size());

        //PriorityQueue
        System.out.println("\n--- PriorityQueue Example ---");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(5);
        priorityQueue.offer(2);
        priorityQueue.offer(8);
        priorityQueue.offer(1);
        System.out.println("Priority Queue: " + priorityQueue);
        System.out.println("Peek: " + priorityQueue.peek());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Updated Priority Queue: " + priorityQueue);
        System.out.println("Size of priority queue: " + priorityQueue.size());


        //Queue
        System.out.println("\n--- Queue Example ---");
        Queue<String> queue = new LinkedList<>();
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");
        System.out.println("Queue: " + queue);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Updated Queue: " + queue);
        System.out.println("Size of queue: " + queue.size());

        //Stack
        System.out.println("\n--- Stack Example ---");
        Stack<String> stack = new Stack<>();
        stack.push("Durian");
        stack.push("Elderberry");
        stack.push("Fig");
        System.out.println("Stack: " + stack);
        System.out.println("Peek: " + stack.peek());
    }
}