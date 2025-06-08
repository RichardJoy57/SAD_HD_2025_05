package SOLID;

// Only one public class — matches filename OCP_02.java
public class OCP_02 {

    public static abstract class Shape {
        public abstract double getArea();
    }

    public static class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double getArea() {
            return side * side;
        }
    }

    public static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    public static class AreaCalculator {
        public double getArea(Shape shape) {
            return shape.getArea();
        }
    }

    // Optional test
    public static void main(String[] args) {
        AreaCalculator calc = new AreaCalculator();
        Shape square = new Square(4);
        Shape circle = new Circle(3);

        System.out.println("Square Area: " + calc.getArea(square));
        System.out.println("Circle Area: " + calc.getArea(circle));
    }
}
