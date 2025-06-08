package SOLID;

import java.util.HashMap;
import java.util.Map;

public class OCP_01 {

    // Abstraction
    public interface DiscountStrategy {
        double calculate(double amount);
    }

    // Concrete strategies
    public static class RegularDiscount implements DiscountStrategy {
        @Override
        public double calculate(double amount) {
            return amount * 0.1;
        }
    }

    public static class PremiumDiscount implements DiscountStrategy {
        @Override
        public double calculate(double amount) {
            return amount * 0.2;
        }
    }

    // Optionally add a new one, e.g., GoldDiscount
    public static class GoldDiscount implements DiscountStrategy {
        @Override
        public double calculate(double amount) {
            return amount * 0.3;
        }
    }

    // Calculator uses abstraction — no modification needed to add new types
    public static class DiscountCalculator {
        private final Map<String, DiscountStrategy> strategies = new HashMap<>();

        public void register(String customerType, DiscountStrategy strategy) {
            strategies.put(customerType, strategy);
        }

        public double calculateDiscount(String customerType, double amount) {
            DiscountStrategy strategy = strategies.get(customerType);
            if (strategy != null) {
                return strategy.calculate(amount);
            }
            return 0.0;
        }
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        calculator.register("Regular", new RegularDiscount());
        calculator.register("Premium", new PremiumDiscount());
        calculator.register("Gold", new GoldDiscount()); // ✅ new type added without modifying logic

        System.out.println("Regular Discount: " + calculator.calculateDiscount("Regular", 100.0));
        System.out.println("Premium Discount: " + calculator.calculateDiscount("Premium", 100.0));
        System.out.println("Gold Discount: " + calculator.calculateDiscount("Gold", 100.0));
    }
}
