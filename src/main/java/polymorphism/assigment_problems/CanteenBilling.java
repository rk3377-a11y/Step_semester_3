package polymorphism.assigment_problems;

import java.util.*;

public class CanteenBilling {
    static abstract class Customer {
        final String label; final double bill;
        Customer(String l, double b) { label = l; bill = b; }
        abstract double finalAmount();
    }
    static class Student extends Customer {
        Student(String l, double b) { super(l, b); }
        double finalAmount() { return bill * 0.90; }
    }
    static class Staff extends Customer {
        Staff(String l, double b) { super(l, b); }
        double finalAmount() { return bill * 0.95; }
    }
    static class Guest extends Customer {
        Guest(String l, double b) { super(l, b); }
        double finalAmount() { return bill + 10; }
    }
    static Customer create(String t, double b) {
        return switch (t) {
            case "STUDENT" -> new Student(t, b);
            case "STAFF" -> new Staff(t, b);
            default -> new Guest(t, b);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) { String t = sc.next(); list.add(create(t, sc.nextDouble())); }
        double total = 0;
        for (Customer c : list) {
            double f = c.finalAmount(); total += f;
            System.out.printf(Locale.US, "%s: %.2f%n", c.label, f);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
