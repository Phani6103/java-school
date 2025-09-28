public class OopsPrinciples {
    // Abstraction: Hiding the internal implementation and showing only the necessary features.
    // In Java, abstraction can be achieved using abstract classes and interfaces.

    // Abstract class example.
    // Making it static so it can be used in the static main method without an instance of OopsPrinciples.
    static abstract class Animal {
        // Abstract method (no implementation)
        public abstract void makeSound();

        // Concrete method (with implementation)
        public void sleep() {
            System.out.println("Zzz...");
        }
    }

    // Concrete class extending the abstract class
    static class Dog extends Animal {
        @Override
        // The @Override annotation indicates that this method is overriding a method in the superclass (Animal).
        public void makeSound() {
            System.out.println("Woof!");
        }
    }

    static class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Meow!");
        }
    }

    // Encapsulation: Bundling the data (attributes) and methods (functions) that operate on the data
    // into a single unit (class) and restricting direct access to some of an object's components.
    // This is typically achieved using access modifiers (private, public, protected).

    static class BankAccount {
        private String accountNumber;
        private double balance;

        public BankAccount(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        // Getter methods to access private data
        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        // Methods to modify private data (with validation)
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount + ", New balance: " + balance);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                System.out.println("Withdrew: " + amount + ", New balance: " + balance);
            } else if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        }
    }

    // Inheritance: The mechanism by which one class is allowed to inherit the features (fields and methods) of another class.
    // In Java, inheritance is achieved using the 'extends' keyword.

    // Base class (Parent class)
    static class Vehicle {
        protected String brand = "Generic"; // protected so subclasses can access it

        public void honk() {
            System.out.println("Tuut, tuut!");
        }
    }

    // Derived class (Child class) inheriting from Vehicle
    static class Car extends Vehicle {
        private String modelName = "Mustang"; // Car's own field

        public void displayCarInfo() {
            System.out.println("Brand: " + brand + ", Model: " + modelName);
        }
    }

    // Polymorphism: The ability of an object to take on many forms.
    // In Java, polymorphism is primarily achieved through method overriding and interfaces.

    // Method Overriding example (already seen with Animal and Dog/Cat makeSound methods).
    // Another example:
    static class Shape {
        public void draw() {
            System.out.println("Drawing a generic shape.");
        }
    }

    static class Circle extends Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a circle.");
        }
    }

    static class Rectangle extends Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a rectangle.");
        }
    }

    // Polymorphism example with Inteface
    interface ShapeInterface {
        void draw();

        default void describe() {
            System.out.println("This shape interface provides drawing behavior.");
        }

        static void printInterfaceInfo() {
            System.out.println("ShapeInterface combines abstract, default, and static methods.");
        }
    }

    static class CircleInterface implements ShapeInterface {
        @Override
        public void draw() {
            System.out.println("Drawing a circle using ShapeInterface implementation.");
        }
    }



    public static void main(String[] args) {
        System.out.println("--- Demonstrating Abstraction ---");
        // We can create objects of concrete classes Dog and Cat
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.makeSound(); // Calls the Dog's implementation
        myDog.sleep();     // Calls the Animal's implementation

        myCat.makeSound(); // Calls the Cat's implementation
        myCat.sleep();     // Calls the Animal's implementation

        // Animal myAnimal = new Animal(); // This would cause a compilation error because Animal is abstract.

        System.out.println("\n--- Demonstrating Encapsulation ---");
        // Create a BankAccount object
        BankAccount myAccount = new BankAccount("123456789", 500.00);

        // We can't access the balance directly, e.g., myAccount.balance = 10000; // This would be a compile error.
        // We must use the public methods to interact with the object's data.
        System.out.println("Account Number: " + myAccount.getAccountNumber());
        System.out.println("Initial Balance: " + myAccount.getBalance());

        myAccount.deposit(200.00);
        myAccount.withdraw(100.00);
        myAccount.deposit(-50.00); // Invalid deposit
        myAccount.withdraw(1000.00); // Insufficient funds
        
        System.out.println("Final Balance: " + myAccount.getBalance());

        Vehicle vehicle = new Vehicle();
        vehicle.honk();

        Car myCar = new Car();
        myCar.displayCarInfo();
        myCar.honk();

        System.out.println("\n--- Demonstrating Inheritance ---");
        Circle circle = new Circle();
        circle.draw();

        Rectangle rectangle = new Rectangle();
        rectangle.draw();

        System.out.println("\n--- Demonstrating Polymorphism with Inteface ---");
        // Polymorphism example with Inteface
        ShapeInterface myShapeInterface = new CircleInterface();
        myShapeInterface.draw();

        System.out.println("\n--- Demonstrating Overriding ---");
        // Overriding example

        Shape myShape = new Shape();
        myShape.draw();

        Circle myCircle = new Circle();
        myCircle.draw();

        Rectangle myRectangle = new Rectangle();
        myRectangle.draw();

        ShapeInterface circleInterface = new CircleInterface();
        circleInterface.draw();
        circleInterface.describe();
        ShapeInterface.printInterfaceInfo();
    }
}
