package abstraction_interface.class_problems;

import java.util.*;

public class ElectricityBilling {
    static abstract class Connection {
        final String label; final double units;
        Connection(String l, double u) { label = l; units = u; }
        abstract double bill();
    }
    static class Home extends Connection {
        Home(String l, double u) { super(l, u); }
        double bill() { return units <= 100 ? 5 * units : 500 + 7 * (units - 100); }
    }
    static class Shop extends Connection {
        Shop(String l, double u) { super(l, u); }
        double bill() { return 8 * units + 100; }
    }
    static class Factory extends Connection {
        Factory(String l, double u) { super(l, u); }
        double bill() { return Math.max(1000, 6 * units); }
    }
    static Connection create(String t, double u) {
        return switch (t) {
            case "HOME" -> new Home(t, u);
            case "SHOP" -> new Shop(t, u);
            default -> new Factory(t, u);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Connection> list = new ArrayList<>();
        for (int i = 0; i < n; i++) { String t = sc.next(); list.add(create(t, sc.nextDouble())); }
        double total = 0;
        for (Connection c : list) {
            double b = c.bill(); total += b;
            System.out.printf(Locale.US, "%s: %.2f%n", c.label, b);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
