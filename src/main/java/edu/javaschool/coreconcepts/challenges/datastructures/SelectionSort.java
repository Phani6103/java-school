package challenges.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> unsortedArray = new ArrayList<>(Arrays.asList(13, 5, 7, 8, 1, 2, 4, 6));
        for (int el: unsortedArray) {
            System.out.print(el + " ");
        }
        System.out.println();

        List<Integer> sortedArray = sortedArray(unsortedArray);

        sortedArray.forEach(el -> {
            System.out.print(el + " ");
        });
    }

    private static List<Integer> sortedArray(List<Integer> unsortedList) {
        var n = unsortedList.size();
        for (int i=0; i < n -1; i++) {
            var currentI = 0;
            var currentJ = 0;
            for (int j=0; j < n - i -1; j++) {
                if (unsortedList.get(i) > unsortedList.get(j)){
                    // remember i and j positions
                    currentI = i;
                    currentJ = j;
                }
            }
            var temp = unsortedList.get(currentI);
            unsortedList.set(currentI, unsortedList.get(currentJ));
            unsortedList.set(i, temp);
        }
        return unsortedList;
    }


}
