package edu.javaschool.core_concepts.advancedfoundations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;

public class MapTypeDS {
    // Map Interface
    // HashMap
    // TreeMap
    // LinkedHasMap
    // ConcurrentHasMap

    private static List<String> hashMap() {
        // HashMap:
        // - Stores key-value pairs.
        // - Implements the Map interface.
        // - Does not guarantee any order of its elements.
        // - Allows one null key and multiple null values.
        // - Is not synchronized (not thread-safe).
        // - Provides constant-time performance (O(1)) for basic operations like get and put,
        //   assuming the hash function disperses elements properly among the buckets.
        System.out.println("\n--- HashMap Demonstration ---");
        System.out.println("Use Case: General-purpose map where order is not important, and fast lookups/insertions are needed.");
        final HashMap<String, String> simpleMap = new HashMap<>();
        return populateAndReturnMap(simpleMap); 
    }

    private static List<String> mapHashMap() {
        // HashMap:
        // - Stores key-value pairs.
        // - Implements the Map interface.
        // - Does not guarantee any order of its elements.
        // - Allows one null key and multiple null values.
        // - Is not synchronized (not thread-safe).
        // - Provides constant-time performance (O(1)) for basic operations like get and put,
        //   assuming the hash function disperses elements properly among the buckets.
        System.out.println("\n--- Map (HashMap implementation) Demonstration ---");
        System.out.println("Use Case: Demonstrating polymorphism, where the specific implementation (HashMap) is hidden behind the Map interface.");
        final Map<String, String> simpleMap = new HashMap<>();
        return populateAndReturnMap(simpleMap);
    }

    private static List<String> treeMap() {
        // TreeMap:
        // - Stores key-value pairs in a sorted order based on the natural ordering of its keys,
        //   or by a Comparator provided at map creation time.
        // - Implements the Map interface and NavigableMap interface.
        // - Does not allow null keys (throws NullPointerException), but allows multiple null values.
        // - Is not synchronized (not thread-safe).
        // - Provides guaranteed log(n) time cost for the containsKey, get, put, and remove operations.
        // - Useful when you need to maintain a sorted order of keys.
        System.out.println("\n--- TreeMap Demonstration ---");
        System.out.println("Use Case: When you need keys to be stored in a sorted order (natural or custom comparator), e.g., for dictionaries, sorted lists of items.");
        final TreeMap<String, String> simpleMap = new TreeMap<>();
        return populateAndReturnMap(simpleMap);
    }
    private static List<String> mapTreeMap() {
        final Map<String, String> simpleMap = new TreeMap<>();
        System.out.println("\n--- Map (TreeMap implementation) Demonstration ---");
        System.out.println("Use Case: Demonstrating polymorphism with a TreeMap, useful when you need sorted keys but want to program to the interface.");
        return populateAndReturnMap(simpleMap);
    }
    
    private static List<String> linkedHashMap() {
        // LinkedHashMap:
        // - Stores key-value pairs in insertion order (or access order, if configured).
        // - Implements the Map interface.
        // - Maintains a doubly-linked list running through all of its entries.
        // - Allows one null key and multiple null values.
        // - Is not synchronized (not thread-safe).
        // - Provides nearly constant-time performance (O(1)) for basic operations like get and put,
        //   but iteration over the map requires time proportional to the size of the map plus the number of entries.
        // - Useful when you need to maintain the order of insertion or access.
        System.out.println("\n--- LinkedHashMap Demonstration ---");
        System.out.println("Use Case: When you need to preserve the insertion order of elements, e.g., for caches (LRU cache), or maintaining a sequence of operations.");
        final LinkedHashMap<String, String> simpleMap = new LinkedHashMap<>();
        return populateAndReturnMap(simpleMap);
    }
    
    private static List<String> mapLinkedHashMap() {
        final Map<String, String> simpleMap = new LinkedHashMap<>();
        System.out.println("\n--- Map (LinkedHashMap implementation) Demonstration ---");
        System.out.println("Use Case: Demonstrating polymorphism with a LinkedHashMap, useful when order preservation is key but you want to use the generic Map interface.");
        return populateAndReturnMap(simpleMap);
    }
    
    private static List<String> concurrentHasMap() {
        // ConcurrentHashMap:
        // - A thread-safe implementation of the Map interface.
        // - Designed for high-concurrency applications.
        // - Does not allow null keys or null values.
        // - Provides better scalability than synchronized maps (like Hashtable or Collections.synchronizedMap).
        // - Achieves thread safety by internally segmenting the map and locking only portions of it during updates,
        //   allowing concurrent reads and writes to different segments.
        // - Provides constant-time performance (O(1)) for basic operations like get and put, on average.
        // - Iteration reflects the state of the map at the time the iterator was created.
        System.out.println("\n--- ConcurrentHashMap Demonstration ---");
        System.out.println("Use Case: In multi-threaded environments where multiple threads need to access and modify the map concurrently without external synchronization, e.g., shared caches, thread-safe counters.");
        final ConcurrentHashMap<String, String> simpleMap = new ConcurrentHashMap<>();
        return populateAndReturnMap(simpleMap);
    }
    
    private static List<String> mapConcurrentHasMap() {
        final Map<String, String> simpleMap = new ConcurrentHashMap<>();
        System.out.println("\n--- Map (ConcurrentHashMap implementation) Demonstration ---");
        System.out.println("Use Case: Demonstrating polymorphism with a ConcurrentHashMap, ideal for concurrent scenarios while programming to the Map interface.");
        return populateAndReturnMap(simpleMap);
    }

    private static List<String> synchronizedMap() {
        // SynchronizedMap (using Collections.synchronizedMap):
        // - Creates a synchronized (thread-safe) wrapper around an existing Map.
        // - All access to the backing map must be accomplished through the returned map.
        // - Achieves thread safety by synchronizing on the map object itself for every method call.
        // - Can lead to contention and reduced performance in high-concurrency scenarios
        //   because only one thread can access the map at a time (global lock).
        // - Allows null keys and null values if the underlying map allows them (e.g., HashMap).
        System.out.println("\n--- Synchronized Map Demonstration ---");
        System.out.println("Use Case: When you need a thread-safe map but are using an older Java version or have simple concurrency needs where a global lock is acceptable.");
        Map<String, String> regularHashMap = new HashMap<>();
        Map<String, String> synchronizedMap = Collections.synchronizedMap(regularHashMap);
        return populateAndReturnMap(synchronizedMap);
    }

    // Implement a method to use these above different maps and explain the differences clearly with this return outputs.
    private static void mapInterface() {
        // Map Interface:
        // - Represents a mapping from keys to values.
        // - A map cannot contain duplicate keys; each key can map to at most one value.
        // - Provides methods for basic operations (put, get, remove, containsKey, containsValue, size, isEmpty),
        //   bulk operations (putAll, clear), and collection views (keySet, values, entrySet).
        // - Implementations typically provide different guarantees regarding order, null keys/values, and thread-safety.
        // - Common implementations include HashMap, TreeMap, LinkedHashMap, and ConcurrentHashMap.
        
        System.out.println("\n--- Map Interface Demonstration ---");
        System.out.println("Demonstrating Map Interface (using HashMap as an example):");
        Map<String, String> map = new HashMap<>();
        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
        System.out.println("Map: " + map);
        System.out.println("Value for Key1: " + map.get("Key1"));
        System.out.println("Contains Key2: " + map.containsKey("Key2"));
        System.out.println("Map size: " + map.size());
        System.out.println("Is map empty: " + map.isEmpty());
        map.remove("Key1");
        System.out.println("Map after removing Key1: " + map);
        System.out.println("--------------------------------------------------");
    }

    private static <T extends Map<String, String>> List<String> populateAndReturnMap(T simpleMap) {
        if (simpleMap instanceof HashMap) {
            ((HashMap<String, String>) simpleMap).put(null, "Null Value"); // HashMap allows null key
            simpleMap.put("Italy", null); // HashMap allows null values

        } else if (simpleMap instanceof ConcurrentHashMap) {
            // ConcurrentHashMap does not allow null keys or values
            // ((ConcurrentHashMap<String, String>) simpleMap).put(null, "Null Value"); // Throws NullPointerException
            // ((ConcurrentHashMap<String, String>) simpleMap).put("NullKey", null); // Throws NullPointerException
        } else if (simpleMap instanceof TreeMap) {
            // TreeMap does not allow null keys
            // ((TreeMap<String, String>) simpleMap).put(null, "Null Value"); // Throws NullPointerException
            simpleMap.put("Italy", null); // TreeMap allows null values
        } else if (simpleMap instanceof LinkedHashMap) {
            ((LinkedHashMap<String, String>) simpleMap).put(null, "Null Value"); // LinkedHashMap allows null key
            simpleMap.put("Italy", null); // LinkedHashMap allows null values
        } else if (simpleMap.getClass().getName().contains("SynchronizedMap")) { // Check for the internal class name
            // Collections.synchronizedMap allows null keys and values if the underlying map does.
            // The populateAndReturnMap method is designed to add specific keys and values.
            // For a synchronized map, the underlying map (e.g., HashMap) would handle nulls.
            // We've already handled the population for synchronizedMap in its dedicated method.
            // This branch is mostly for type checking and to avoid issues if it were to be populated here.
            simpleMap.put("Italy", null); 
            simpleMap.put(null, "Null Value");
        }

        simpleMap.put("England", "London");
        simpleMap.put("Germany", "Berlin");
        simpleMap.put("France", "Paris");
        simpleMap.put("India", "New Dehli");
        simpleMap.put("Austria", "Wien");
        simpleMap.put("Norway", "Oslo");
        simpleMap.put("Norway", "Oslo"); // Duplicate
        simpleMap.put("USA", "Washington DC");
        System.out.println("--------------------------------------------------");
        return simpleMap.keySet().stream().toList();
    }

    private static void diffConcurrentHashAndHashMap() {
        // Explain with an example with multiple threads
        System.out.println("\n--- ConcurrentHashMap vs. HashMap in Multi-threading ---");
        System.out.println("Use Case: Demonstrating thread-safety differences when multiple threads modify a map.");

        // Scenario 1: HashMap (not thread-safe)
        System.out.println("\n--- Using HashMap (Not Thread-Safe) ---");
        Map<String, Integer> hashMap = new HashMap<>();
        Runnable hashMapTask = () -> {
            for (int i = 0; i < 1000; i++) {
                hashMap.put(Thread.currentThread().getName() + "-" + i, i);
            }
        };

        Thread t1 = new Thread(hashMapTask, "HashMap-Thread-1");
        Thread t2 = new Thread(hashMapTask, "HashMap-Thread-2");
        Thread t3 = new Thread(hashMapTask, "HashMap-Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("HashMap final size: " + hashMap.size());
        // Expected: 3000, but often less due to lost updates or ConcurrentModificationException
        // if iteration was involved during modification.
        // For simple put operations, size might be 3000, but internal state could be corrupted.
        // Accessing elements might lead to unexpected behavior or infinite loops.
        System.out.println("Note: HashMap is not thread-safe. Its size might be inconsistent or operations could fail in a real concurrent scenario.");


        // Scenario 2: ConcurrentHashMap (thread-safe)
        System.out.println("\n--- Using ConcurrentHashMap (Thread-Safe) ---");
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Runnable concurrentHashMapTask = () -> {
            for (int i = 0; i < 1000; i++) {
                concurrentHashMap.put(Thread.currentThread().getName() + "-" + i, i);
            }
        };

        Thread ct1 = new Thread(concurrentHashMapTask, "ConcurrentHashMap-Thread-1");
        Thread ct2 = new Thread(concurrentHashMapTask, "ConcurrentHashMap-Thread-2");
        Thread ct3 = new Thread(concurrentHashMapTask, "ConcurrentHashMap-Thread-3");

        ct1.start();
        ct2.start();
        ct3.start();

        try {
            ct1.join();
            ct2.join();
            ct3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("ConcurrentHashMap final size: " + concurrentHashMap.size());
        // Expected: 3000. ConcurrentHashMap handles concurrent modifications safely.
        System.out.println("Note: ConcurrentHashMap is thread-safe and ensures data consistency in concurrent environments.");
        System.out.println("--------------------------------------------------");

        
    }

    public static void main(String[] args) {
        mapInterface(); // Demonstrate the interface first

        hashMap();
        mapHashMap();

        treeMap();
        mapTreeMap();

        linkedHashMap();
        mapLinkedHashMap();

        concurrentHasMap();
        mapConcurrentHasMap();

        diffConcurrentHashAndHashMap();


        synchronizedMap();
    }
}