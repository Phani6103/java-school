package basic;

public class record {
    // A simple record declaration
    record Point(int x, int y) {
        // Records automatically get:
        // - A canonical constructor (Point(int x, int y))
        // - Accessor methods (x(), y())
        // - equals(), hashCode(), and toString() implementations
    }

    // A record with custom methods
    record Rectangle(Point topLeft, Point bottomRight) {
        // Compact constructor for validation
        public Rectangle {
            if (topLeft.x() > bottomRight.x() || topLeft.y() > bottomRight.y()) {
                throw new IllegalArgumentException("Invalid rectangle coordinates");
            }
        }

        // Custom method
        public double width() {
            return bottomRight.x() - topLeft.x();
        }

        // Custom method
        public double height() {
            return bottomRight.y() - topLeft.y();
        }

        // Custom method
        public double area() {
            return width() * height();
        }
    }

    // A record with a static field and method
    record Circle(Point center, double radius) {
        static final double PI = Math.PI;

        public double circumference() {
            return 2 * PI * radius;
        }

        public static Circle unitCircle() {
            return new Circle(new Point(0, 0), 1.0);
        }
    }

    public static void main(String[] args) {
        // Using the Point record
        Point p1 = new Point(10, 20);
        System.out.println("Point p1: " + p1); // Uses auto-generated toString()
        System.out.println("p1.x(): " + p1.x());
        System.out.println("p1.y(): " + p1.y());

        Point p2 = new Point(10, 20);
        System.out.println("p1 equals p2? " + p1.equals(p2)); // Uses auto-generated equals()

        Point p3 = new Point(30, 40);
        System.out.println("p1 equals p3? " + p1.equals(p3));

        // Using the Rectangle record
        Rectangle rect1 = new Rectangle(new Point(10, 20), new Point(30, 40));
        System.out.println("Rectangle rect1: " + rect1);
        System.out.println("rect1.width(): " + rect1.width());
        System.out.println("rect1.height(): " + rect1.height());
        System.out.println("rect1.area(): " + rect1.area());
    }
}
