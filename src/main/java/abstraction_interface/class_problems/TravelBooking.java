package abstraction_interface.class_problems;

import java.util.*;

public class TravelBooking {
    static abstract class Booking {
        static final double BOOKING_FEE = 50;   // the ONLY place the fee is written
        final String label; final double km;
        Booking(String l, double km) { label = l; this.km = km; }
        abstract double baseFare();
        final double total() { return baseFare() + BOOKING_FEE; }
    }
    static class Bus extends Booking {
        Bus(String l, double km) { super(l, km); }
        double baseFare() { return 2 * km; }
    }
    static class Train extends Booking {
        Train(String l, double km) { super(l, km); }
        double baseFare() { return 1.5 * km; }
    }
    static class Flight extends Booking {
        Flight(String l, double km) { super(l, km); }
        double baseFare() { return 2500 + 4 * km; }
    }
    static Booking create(String t, double km) {
        return switch (t) {
            case "BUS" -> new Bus(t, km);
            case "TRAIN" -> new Train(t, km);
            default -> new Flight(t, km);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Booking> list = new ArrayList<>();
        for (int i = 0; i < n; i++) { String t = sc.next(); list.add(create(t, sc.nextDouble())); }
        for (Booking b : list) System.out.printf(Locale.US, "%s: %.2f%n", b.label, b.total());
    }
}
