package edu.javaschool.core_concepts.advancedfoundations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapTypeDS {
    // Map Interface
    // HashMap
    // TreeMap
    // LinkedHasMap
    // ConcurrentHasMap

    private static void hashMap() {
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
        populateAndPrintMap(simpleMap);
    }

    private static void mapHashMap() {
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
        populateAndPrintMap(simpleMap);
    }

    private static void treeMap() {
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
        populateAndPrintMap(simpleMap);
    }
    private static void mapTreeMap() {
        final Map<String, String> simpleMap = new TreeMap<>();
        populateAndPrintMap(simpleMap);
        System.out.println("\n--- Map (TreeMap implementation) Demonstration ---");
        System.out.println("Use Case: Demonstrating polymorphism with a TreeMap, useful when you need sorted keys but want to program to the interface.");
    }
    
    private static void linkedHashMap() {
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
        populateAndPrintMap(simpleMap);
    }
    
    private static void mapLinkedHashMap() {
        final Map<String, String> simpleMap = new LinkedHashMap<>();
        populateAndPrintMap(simpleMap);
        System.out.println("\n--- Map (LinkedHashMap implementation) Demonstration ---");
        System.out.println("Use Case: Demonstrating polymorphism with a LinkedHashMap, useful when order preservation is key but you want to use the generic Map interface.");
    }
    
    private static void concurrentHasMap() {
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
        populateAndPrintMap(simpleMap);
    }
    
    private static void mapConcurrentHasMap() {
        final Map<String, String> simpleMap = new ConcurrentHashMap<>();
        populateAndPrintMap(simpleMap);
        System.out.println("\n--- Map (ConcurrentHashMap implementation) Demonstration ---");
        System.out.println("Use Case: Demonstrating polymorphism with a ConcurrentHashMap, ideal for concurrent scenarios while programming to the Map interface.");
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

    private static void populateAndPrintMap(Map<String, String> simpleMap) {
        simpleMap.put("England", "London");
        simpleMap.put("India", "New Dehli");
        simpleMap.put("Austria", "Wien");
        simpleMap.put("Norway", "Oslo");
        simpleMap.put("Norway", "Oslo"); // Duplicate
        simpleMap.put("USA", "Washington DC");
        System.out.println(simpleMap.getClass().getName() + " " + simpleMap);
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
    }
}