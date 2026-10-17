package polymorphism.assigment_problems;

import java.util.*;

public class ParkingCharge {
    static abstract class Vehicle {
        final String label; final int hours;
        Vehicle(String l, int h) { label = l; hours = h; }
        abstract double charge();
    }
    static class Bike extends Vehicle {
        Bike(String l, int h) { super(l, h); }
        double charge() { return 10.0 * hours; }
    }
    static class Car extends Vehicle {
        Car(String l, int h) { super(l, h); }
        double charge() { return 30.0 + 20.0 * (hours - 1); }
    }
    static class Truck extends Vehicle {
        Truck(String l, int h) { super(l, h); }
        double charge() { return Math.max(100.0, 50.0 * hours); }
    }
    static Vehicle create(String t, int h) {
        return switch (t) {
            case "BIKE" -> new Bike(t, h);
            case "CAR" -> new Car(t, h);
            default -> new Truck(t, h);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < n; i++) { String t = sc.next(); list.add(create(t, sc.nextInt())); }
        double total = 0;
        for (Vehicle v : list) {
            double c = v.charge(); total += c;
            System.out.printf(Locale.US, "%s: %.2f%n", v.label, c);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
