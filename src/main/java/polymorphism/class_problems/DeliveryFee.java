package polymorphism.class_problems;

import java.util.*;

public class DeliveryFee {
    static abstract class Delivery {
        final String label; final double weight, distance;
        Delivery(String l, double w, double d) { label = l; weight = w; distance = d; }
        abstract double fee();
    }
    static class Standard extends Delivery {
        Standard(String l, double w, double d) { super(l, w, d); }
        double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
    }
    static class Express extends Delivery {
        Express(String l, double w, double d) { super(l, w, d); }
        double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
    }
    static class International extends Delivery {
        final double customs;
        International(String l, double w, double d, double c) { super(l, w, d); customs = c; }
        double fee() { return 25 + 2.00 * weight + 0.50 * distance + customs; }
    }
    static Delivery read(String t, Scanner sc) {
        double w = sc.nextDouble(), d = sc.nextDouble();
        return switch (t) {
            case "STANDARD" -> new Standard(t, w, d);
            case "EXPRESS" -> new Express(t, w, d);
            default -> new International(t, w, d, sc.nextDouble());
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(read(sc.next(), sc));
        double total = 0;
        for (Delivery d : list) {
            double f = d.fee(); total += f;
            System.out.printf(Locale.US, "%s: %.2f%n", d.label, f);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
