package challenges.w3Schools;

public class RandomNumber {
    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int randomNumber = (int) (Math.random() * (max - min + 1));
        System.out.println("Random number between " + min + " and " + max + ": " + randomNumber);
    }
}
