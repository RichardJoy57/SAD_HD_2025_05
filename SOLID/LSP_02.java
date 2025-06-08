package SOLID;

public class LSP_02 {

    // Base class for all birds
    public static abstract class Bird {
        public void eat() {
            System.out.println("The bird is eating...");
        }
    }

    // Interface for flying capability
    public interface Flyable {
        void fly();
    }

    // Flying bird
    public static class Sparrow extends Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("The sparrow is flying...");
        }
    }

    // Non-flying bird
    public static class Penguin extends Bird {
        public void swim() {
            System.out.println("The penguin is swimming...");
        }
    }

    // Only works with birds that can fly
    public static void move(Flyable bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Flyable sparrow = new Sparrow();
        move(sparrow);

        Bird penguin = new Penguin();
        // move(penguin); 

        // You can still call penguin-specific behavior
        if (penguin instanceof Penguin) {
            ((Penguin) penguin).swim();
        }
    }
}
