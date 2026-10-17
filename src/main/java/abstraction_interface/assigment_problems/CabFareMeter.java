package abstraction_interface.assigment_problems;

import java.util.*;

public class CabFareMeter {
    interface NightService {
        double NIGHT_SURCHARGE = 0.20;
        default double nightFare(double dayFare) { return dayFare * (1 + NIGHT_SURCHARGE); }
    }
    static abstract class Cab {
        static final double MIN_FARE = 100;   // shared by every cab
        final String label; final double km;
        Cab(String l, double km) { label = l; this.km = km; }
        abstract double ratePerKm();
        final double dayFare() { return Math.max(MIN_FARE, km * ratePerKm()); }
    }
    static class Mini extends Cab {
        Mini(String l, double km) { super(l, km); }
        double ratePerKm() { return 10; }
    }
    static class Sedan extends Cab implements NightService {
        Sedan(String l, double km) { super(l, km); }
        double ratePerKm() { return 14; }
    }
    static class Suv extends Cab implements NightService {
        Suv(String l, double km) { super(l, km); }
        double ratePerKm() { return 18; }
    }
    static Cab create(String t, double km) {
        return switch (t) {
            case "MINI" -> new Mini(t, km);
            case "SEDAN" -> new Sedan(t, km);
            default -> new Suv(t, km);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Cab cab = create(sc.next(), 0);          // placeholder replaced below
            String type = cab.label;
            double km = sc.nextDouble();
            String time = sc.next();
            cab = create(type, km);
            double fare = cab.dayFare();
            if (time.equals("NIGHT")) {
                if (cab instanceof NightService ns) {
                    fare = ns.nightFare(fare);
                } else {
                    System.out.println(cab.label + ": night service not available");
                    continue;
                }
            }
            total += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", cab.label, fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
