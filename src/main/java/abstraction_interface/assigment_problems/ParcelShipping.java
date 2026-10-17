package abstraction_interface.assigment_problems;

import java.util.*;

public class ParcelShipping {
    interface Insurable {
        double insurance(double declaredValue);
    }
    static abstract class Parcel {
        final String label; final double weight, declared;
        Parcel(String l, double w, double d) { label = l; weight = w; declared = d; }
        abstract double charge();
        double insuranceAmount() {
            return (this instanceof Insurable i) ? i.insurance(declared) : 0;
        }
        static double standardCharge(double w) { return 40 + 10 * w; }
    }
    static class Standard extends Parcel {
        Standard(String l, double w, double d) { super(l, w, d); }
        double charge() { return standardCharge(weight); }
    }
    static class Express extends Parcel implements Insurable {
        Express(String l, double w, double d) { super(l, w, d); }
        double charge() { return 80 + 15 * weight; }
        public double insurance(double v) { return 0.02 * v; }
    }
    static class Fragile extends Parcel implements Insurable {
        Fragile(String l, double w, double d) { super(l, w, d); }
        double charge() { return standardCharge(weight) + 50; }
        public double insurance(double v) { return 0.02 * v; }
    }
    static Parcel create(String t, double w, double d) {
        return switch (t) {
            case "STANDARD" -> new Standard(t, w, d);
            case "EXPRESS" -> new Express(t, w, d);
            default -> new Fragile(t, w, d);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Parcel> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next(); double w = sc.nextDouble();
            list.add(create(t, w, sc.nextDouble()));
        }
        double grand = 0;
        for (Parcel p : list) {
            double c = p.charge(), ins = p.insuranceAmount(), tot = c + ins;
            grand += tot;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.label, c, ins, tot);
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grand);
    }
}
