package edu.javaschool.core_concepts.challenges.datastructures;

public class SumOfDigitsOfNumber {

    public static int sumOfDigits(int val) {
        int sum = 0;
        if (val == 0) return sum;
        while (val > 0 ) {
            sum += val%10;
            val = val/10;
        }
        return sum;
    }

    public static int sumOfDigitsUsingRecursion(int val) {
        if (val == 0) return 0;
        return (val % 10) + sumOfDigitsUsingRecursion(val / 10);
    }

    public static int sumOfDigitsUsingString(int val) {
        String s = String.valueOf(val);
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }
    
    public static int sumOfDigitsUsingStreams(int val) {
        return String.valueOf(val)
                .chars()
                .map(Character::getNumericValue)
                .reduce(0, Integer::sum);
    }
    
    

    public static void main(String[] args) {
     int count = sumOfDigits(1234567890);
     System.out.println(count);

     int countRec = sumOfDigitsUsingRecursion(1234567890);
     System.out.println(countRec);

     int countStr = sumOfDigitsUsingString(1234567890);
     System.out.println(countStr);

     int countStreams = sumOfDigitsUsingStreams(1234567890);
     System.out.println(countStreams);
     
     
    }
}
