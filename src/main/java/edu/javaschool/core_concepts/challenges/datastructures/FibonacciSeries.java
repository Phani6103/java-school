package edu.javaschool.core_concepts.challenges.datastructures;

public class FibonacciSeries {
    private static String fibonacciSeries(int val) {
        if (val==0)return "0";
        if (val==1) return "0";
        if (val==2)return "01";

        int[] arr = new int[val];
        arr[0]=0;
        arr[1]=1;
        for (int i=2; i<=val-1; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
        return java.util.Arrays.toString(arr);
    }

    private static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    private static String fibonacciSeriesRecursive(int val) {
        if (val <= 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val; i++) {
            sb.append(fibonacciRecursive(i));
            if (i < val - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(fibonacciSeries(7));
        System.out.println(fibonacciSeriesRecursive(7));
    }
     
}