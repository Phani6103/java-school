package edu.javaschool.core_concepts.challenges.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MaxMinInArray {
    private static Map<String, Integer> maxMinValuesInArray(int[] arr) {
        int minVal = 0;
        int maxVal = 0;
        for (int currVal : arr) {
            if (currVal < minVal || minVal == 0) minVal = currVal;
            if (currVal > maxVal || maxVal == 0) maxVal = currVal;
        }      
        Map<String, Integer> result = new HashMap<>();
            result.put("Min", (int) minVal);
            result.put("Max", (int) maxVal);
        return result;
    }

    private static Map<String, Integer> maxMinValuesInArrayUsingTreeSet(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int value : arr) {
            treeSet.add(value);
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("Min", treeSet.first());
        result.put("Max", treeSet.last());
        return result;
    }


    public static void main(String[] args) {
        int[] testArray = {10, 3, 4, 54, 12, 6, 8};
        Map<String, Integer> result = maxMinValuesInArray(testArray);
        System.out.println("Min value: " + result.get("Min"));
        System.out.println("Max value: " + result.get("Max"));

        Map<String, Integer> resultTreeSet = maxMinValuesInArrayUsingTreeSet(testArray);
        System.out.println("Min value (TreeSet): " + resultTreeSet.get("Min"));
        System.out.println("Max value (TreeSet): " + resultTreeSet.get("Max"));
    }
}
