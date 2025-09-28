package edu.javaschool.core_concepts.advancedfoundations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTypeDS {
    // Map Interface
    // HashMap
    // TreeMap
    // LinkedHasMap
    // ConcurrentHasMap

    private static void hashMap() {
        final HashMap<String, String> simpleMap = new HashMap<>();
        simpleMap.put("England", "London");
        simpleMap.put("India", "New Dehli");
        simpleMap.put("Austria", "Wien");
        simpleMap.put("Norway", "Oslo");
        simpleMap.put("Norway", "Oslo"); // Duplicate
        simpleMap.put("USA", "Washington DC");
        System.out.println(simpleMap.getClass().getName() + " " + simpleMap);
    }

    private static void mapHashMap() {
        final Map<String, String> simpleMap = new HashMap<>();
        simpleMap.put("England", "London");
        simpleMap.put("India", "New Dehli");
        simpleMap.put("Austria", "Wien");
        simpleMap.put("Norway", "Oslo");
        simpleMap.put("Norway", "Oslo"); // Duplicate
        simpleMap.put("USA", "Washington DC");
        System.out.println(simpleMap.getClass().getName() + " " + simpleMap);
    }

    private static void treeMap() {
        final TreeMap<String, String> simpleMap = new TreeMap<>();
        simpleMap.put("England", "London");
        simpleMap.put("India", "New Dehli");
        simpleMap.put("Austria", "Wien");
        simpleMap.put("Norway", "Oslo");
        simpleMap.put("Norway", "Oslo"); // Duplicate
        simpleMap.put("USA", "Washington DC");
        System.out.println(simpleMap.getClass().getName() + " " + simpleMap);
    }
    private static void mapTreeMap() {
        final Map<String, String> simpleMap = new TreeMap<>();
        simpleMap.put("England", "London");
        simpleMap.put("India", "New Dehli");
        simpleMap.put("Austria", "Wien");
        simpleMap.put("Norway", "Oslo");
        simpleMap.put("Norway", "Oslo"); // Duplicate
        simpleMap.put("USA", "Washington DC");
        System.out.println(simpleMap.getClass().getName() + " " + simpleMap);
    }

    private static void linkedHashMap() {
        final LinkedHashMap<String, String> simpleMap = new LinkedHashMap<>();
        simpleMap.put("England", "London");
        simpleMap.put("India", "New Dehli");
        simpleMap.put("Austria", "Wien");
        simpleMap.put("Norway", "Oslo");
        simpleMap.put("Norway", "Oslo"); // Duplicate
        simpleMap.put("USA", "Washington DC");
        System.out.println(simpleMap.getClass().getName() + " " + simpleMap);
    }

    private static void mapLinkedHashMap() {
        final Map<String, String> simpleMap = new LinkedHashMap<>();
        simpleMap.put("England", "London");
        simpleMap.put("India", "New Dehli");
        simpleMap.put("Austria", "Wien");
        simpleMap.put("Norway", "Oslo");
        simpleMap.put("Norway", "Oslo"); // Duplicate
        simpleMap.put("USA", "Washington DC");
        System.out.println(simpleMap.getClass().getName() + " " + simpleMap);
    }

    public static void main(String[] args) {
        hashMap();
        mapHashMap();

        treeMap();
        mapTreeMap();
        
        linkedHashMap();
        mapLinkedHashMap();
    }
    
}