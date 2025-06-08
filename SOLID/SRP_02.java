package SOLID;

public class SRP_02 {

    // Employee class with only data-related methods
    public static class Employee {
        private int employeeID;
        private String designation;
        private double salary;

        public Employee(int employeeID, String designation, double salary) {
            this.employeeID = employeeID;
            this.designation = designation;
            this.salary = salary;
        }

        public String getDesignation() {
            return designation;
        }

        public int getEmployeeID() {
            return employeeID;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }

    // Service for salary-related operations
    public static class SalaryService {
        public void updateSalary(Employee employee, double newSalary) {
            employee.setSalary(newSalary);
            System.out.println("Salary updated for employee ID " + employee.getEmployeeID());
        }
    }

    // Service for email-related operations
    public static class EmailService {
        public void sendMail(Employee employee, String message) {
            // Simulate sending email
            System.out.println("Sending mail to employee with ID " + employee.getEmployeeID() + ": " + message);
        }
    }
}
