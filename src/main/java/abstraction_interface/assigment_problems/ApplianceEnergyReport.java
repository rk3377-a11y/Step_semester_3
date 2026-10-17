package abstraction_interface.assigment_problems;

import java.util.*;

public class ApplianceEnergyReport {
    static final double RATE_PER_UNIT = 8;

    interface SaverMode {
        default double applySaver(double units) { return units * 0.75; }
    }
    static abstract class Appliance {
        final String label;
        Appliance(String l) { label = l; }
        abstract double watts();
        double units(double hours) { return watts() * hours / 1000.0; }
    }
    static class Fridge extends Appliance {
        Fridge(String l) { super(l); }
        double watts() { return 150; }
    }
    static class Ac extends Appliance implements SaverMode {
        Ac(String l) { super(l); }
        double watts() { return 1500; }
    }
    static class Tv extends Appliance {
        Tv(String l) { super(l); }
        double watts() { return 100; }
    }
    static class Washer extends Appliance implements SaverMode {
        Washer(String l) { super(l); }
        double watts() { return 500; }
    }
    static Appliance create(String t) {
        return switch (t) {
            case "FRIDGE" -> new Fridge(t);
            case "AC" -> new Ac(t);
            case "TV" -> new Tv(t);
            default -> new Washer(t);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        int done = 0;
        while (done < n && sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            done++;
            String[] p = line.split("\\s+");
            Appliance a = create(p[0]);
            double hours = Double.parseDouble(p[1]);
            boolean saver = p.length > 2 && p[2].equals("SAVER");
            double units = a.units(hours);
            if (saver) {
                if (a instanceof SaverMode sm) {
                    units = sm.applySaver(units);
                } else {
                    System.out.println(a.label + ": saver mode not supported");
                    continue;
                }
            }
            double cost = units * RATE_PER_UNIT;
            total += cost;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", a.label, units, cost);
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", total);
    }
}
