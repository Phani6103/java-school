package advancedfoundations;

public class SealedClasses {
    // 1. Declaring a sealed interface
    sealed interface Shape permits Circle, Rectangle, Square {
        String getName();
    }

    // 2. Permitted classes must be declared final, sealed, or non-sealed
    final record Circle(double radius) implements Shape {
        @Override
        public String getName() {
            return "Circle";
        }
    }

    sealed interface Quadrilateral extends Shape permits Rectangle, Square {
        // Can add common methods for quadrilaterals
    }

    final record Rectangle(double length, double width) implements Quadrilateral {
        @Override
        public String getName() {
            return "Rectangle";
        }
    }

    // A non-sealed class allows further extension
    non-sealed class Square extends Rectangle implements Quadrilateral {
        public Square(double side) {
            super(side, side);
        }

        @Override
        public String getName() {
            return "Square";
        }
    }

    // A class that extends a non-sealed class (Square)
    class ColoredSquare extends Square {
        private String color;

        public ColoredSquare(double side, String color) {
            super(side);
            this.color = color;
        }

        @Override
        public String getName() {
            return color + " " + super.getName();
        }
    }


    public static void describeShape(Shape shape) {
        if (shape instanceof Circle c) {
            System.out.println("This is a Circle with radius " + c.radius() + ". Name: " + c.getName());
        } else if (shape instanceof Rectangle r) {
            // This will catch both Rectangle and Square because Square extends Rectangle
            System.out.println("This is a Rectangle with length " + r.length() + " and width " + r.width() + ". Name: " + r.getName());
        } else {
            // This 'else' is not strictly necessary if all permitted types are covered,
            // but it's good practice or for future extensions.
            System.out.println("Unknown shape: " + shape.getName());
        }
    }

    public static void main(String[] args) {
        // No enclosing instance needed for static main method
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        Shape square = new Square(3.0);

        describeShape(circle);
        describeShape(rectangle);
        describeShape(square);
    }
}
