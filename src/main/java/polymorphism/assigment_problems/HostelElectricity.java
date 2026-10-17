package polymorphism.assigment_problems;

import java.util.*;

public class HostelElectricity {
    static abstract class Room {
        final String label; final double units;
        Room(String l, double u) { label = l; units = u; }
        abstract double bill();
    }
    static class Single extends Room {
        Single(String l, double u) { super(l, u); }
        double bill() { return 8 * units; }
    }
    static class Shared extends Room {
        final int occupants;
        Shared(String l, double u, int o) { super(l, u); occupants = o; }
        double bill() { return 6 * units / occupants; }
    }
    static class Ac extends Room {
        Ac(String l, double u) { super(l, u); }
        double bill() { return 10 * units + 200; }
    }
    static Room read(String t, Scanner sc) {
        double u = sc.nextDouble();
        return switch (t) {
            case "SINGLE" -> new Single(t, u);
            case "SHARED" -> new Shared(t, u, sc.nextInt());
            default -> new Ac(t, u);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(read(sc.next(), sc));
        double total = 0;
        for (Room r : list) {
            double b = r.bill(); total += b;
            System.out.printf(Locale.US, "%s: %.2f%n", r.label, b);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
