package w3Schools;

public class AddTwoNumbers {
    int a;
    int b;
    int sum;
    
    public AddTwoNumbers(int a, int b) {
        this.a = a;
        this.b = b;
        this.sum = a + b;
    }
    public static void main(String[] args) {
        var myClass = new AddTwoNumbers(10, 20);
        System.out.println(myClass.sum);
    }
        
}
