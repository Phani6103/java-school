package edu.javaschool.core_concepts.challenges.datastructures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TwoSumProblem {
    private static int[] twoSumProblem(int[] arr, int target) {
        List<Integer> arrayList = Arrays.stream(arr).boxed().toList();
        // ListIterator<Integer> arrayListIterator = arrayList.listIterator();
        int[] indexes = new int[2];

        for (int i = 0; i < arrayList.size() - 1; i++) {
            int indexVal = arrayList.indexOf(Math.abs(arrayList.get(i)-target));
            if (indexVal >= 0) {
                indexes[0] = i;
                indexes[1] = indexVal;
                break;
            }
        }
        return indexes;
    }

    private static int[] twoSumProblemOptimized(int[] nums, int target) {
        java.util.Map<Integer, Integer> numMap = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    private static int[] twoSumProblemBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    private static int[] twoSumProblemSorted(int[] nums, int target) {
        // First, sort the array. This approach changes the original indices.
        // If original indices are required, store pairs of (value, original_index) and sort them.
        // For simplicity, this example assumes returning indices of the sorted array or that original indices are not strictly required.
        // If original indices are strictly required, the optimized HashMap approach is generally better.

        // To preserve original indices, we can create an array of pairs (value, original_index)
        class Pair {
            int value;
            int index;

            Pair(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }

        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a.value, b.value));

        int left = 0;
        int right = pairs.length - 1;

        while (left < right) {
            int currentSum = pairs[left].value + pairs[right].value;
            if (currentSum == target) {
                return new int[]{pairs[left].index, pairs[right].index};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    private static int[] twoSumProblemUsingStreams(int[] nums, int target) {
        return IntStream.range(0, nums.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.length)
                        .filter(j -> nums[i] + nums[j] == target)
                        .mapToObj(j -> new int[]{i, j}))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No two sum solution"));
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumProblem(new int[]{2,17,-7,15, 7}, 9)));
        System.out.println(Arrays.toString(twoSumProblemOptimized(new int[]{2, 17, -7, 15, 7}, 9)));
        System.out.println(Arrays.toString(twoSumProblemBruteForce(new int[]{2, 17, -7, 15, 7}, 9)));
        System.out.println(Arrays.toString(twoSumProblemSorted(new int[]{2, 17, -7, 15, 7}, 9)));
        System.out.println(Arrays.toString(twoSumProblemUsingStreams(new int[]{2, 17, -7, 15, 7}, 9)));
        
    }
}
