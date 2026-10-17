package abstraction_interface.assigment_problems;

import java.util.*;

public class MovieTicketCounter {
    static abstract class Ticket {
        static final double CONVENIENCE_FEE = 20;   // written once
        final String label; final int count;
        Ticket(String l, int c) { label = l; count = c; }
        abstract double price();
        final double amount() { return count * (price() + CONVENIENCE_FEE); }
    }
    static class Regular extends Ticket {
        Regular(String l, int c) { super(l, c); }
        double price() { return 150; }
    }
    static class Premium extends Ticket {
        Premium(String l, int c) { super(l, c); }
        double price() { return 250; }
    }
    static class Recliner extends Ticket {
        Recliner(String l, int c) { super(l, c); }
        double price() { return 400; }
    }
    static Ticket create(String t, int c) {
        return switch (t) {
            case "REGULAR" -> new Regular(t, c);
            case "PREMIUM" -> new Premium(t, c);
            default -> new Recliner(t, c);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> list = new ArrayList<>();
        for (int i = 0; i < n; i++) { String t = sc.next(); list.add(create(t, sc.nextInt())); }
        double total = 0;
        for (Ticket t : list) {
            double a = t.amount(); total += a;
            System.out.printf(Locale.US, "%s: %.2f%n", t.label, a);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
