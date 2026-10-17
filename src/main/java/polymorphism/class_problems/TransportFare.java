package polymorphism.class_problems;

import java.util.*;

public class TransportFare {
    static abstract class Journey {
        final String label; final double distance;
        Journey(String l, double d) { label = l; distance = d; }
        abstract double fare();
    }
    static class Bus extends Journey {
        Bus(String l, double d) { super(l, d); }
        double fare() { return Math.min(10, 2 + 0.10 * distance); }
    }
    static class Train extends Journey {
        Train(String l, double d) { super(l, d); }
        double fare() { return 3 + 0.15 * distance; }
    }
    static class Metro extends Journey {
        final double peak;
        Metro(String l, double d, double p) { super(l, d); peak = p; }
        double fare() { return (1.5 + 0.20 * distance) * peak; }
    }
    static Journey read(String t, Scanner sc) {
        double d = sc.nextDouble();
        return switch (t) {
            case "BUS" -> new Bus(t, d);
            case "TRAIN" -> new Train(t, d);
            default -> new Metro(t, d, sc.nextDouble());
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(read(sc.next(), sc));
        double total = 0;
        for (Journey j : list) {
            double f = j.fare(); total += f;
            System.out.printf(Locale.US, "%s: %.2f%n", j.label, f);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
