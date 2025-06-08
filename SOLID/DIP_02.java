package SOLID;

public class DIP_02 {

    // Abstraction
    public interface Notification {
        void doNotify();
    }

    // Low-level module depends on the abstraction
    public static class EmailNotification implements Notification {
        @Override
        public void doNotify() {
            System.out.println("Sending notification via email!");
        }
    }

    // High-level module also depends on the abstraction
    public static class Employee {
        private Notification notification;

        public Employee(Notification notification) {
            this.notification = notification;
        }

        public void notifyEmployee() {
            notification.doNotify();
        }
    }

    public static void main(String[] args) {
        Notification notification = new EmailNotification();  // Abstraction used here
        Employee employee = new Employee(notification);       // Injected via constructor
        employee.notifyEmployee();                            // Works via interface
    }
}
