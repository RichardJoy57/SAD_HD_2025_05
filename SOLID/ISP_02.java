package SOLID;

public class ISP_02 {

    // Segregated interfaces
    public interface Workable {
        void work();
    }

    public interface Restable {
        void rest();
    }

    // Developer needs both: work and rest
    public static class Developer implements Workable, Restable {
        @Override
        public void work() {
            System.out.println("Developer is coding ...");
        }

        @Override
        public void rest() {
            System.out.println("Developer is making a break!");
        }
    }

    // Robot only needs to work
    public static class Robot implements Workable {
        @Override
        public void work() {
            System.out.println("Robot is working hard ...");
        }
    }

    // Now two different working cycles based on capabilities
    public static void workingCycle(Workable worker) {
        worker.work();
    }

    public static void restingCycle(Restable restable) {
        restable.rest();
    }

    public static void main(String[] args) {
        Developer dev = new Developer();
        Robot robot = new Robot();

        // Developer works and rests
        workingCycle(dev);
        restingCycle(dev);

        // Robot only works
        workingCycle(robot);
        // restingCycle(robot); // Not allowed, which is good!
    }
}
