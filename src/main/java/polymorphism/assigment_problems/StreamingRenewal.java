package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.util.*;

public class StreamingRenewal {
    static abstract class Plan {
        final String name; final LocalDate start;
        Plan(String n, LocalDate s) { name = n; start = s; }
        abstract int validityDays();
        LocalDate renewalDate() { return start.plusDays(validityDays()); }
    }
    static class Basic extends Plan {
        Basic(String n, LocalDate s) { super(n, s); }
        int validityDays() { return 30; }
    }
    static class Standard extends Plan {
        Standard(String n, LocalDate s) { super(n, s); }
        int validityDays() { return 90; }
    }
    static class Premium extends Plan {
        Premium(String n, LocalDate s) { super(n, s); }
        int validityDays() { return 365; }
    }
    static Plan create(String t, String name, LocalDate s) {
        return switch (t) {
            case "BASIC" -> new Basic(name, s);
            case "STANDARD" -> new Standard(name, s);
            default -> new Premium(name, s);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next(); String name = sc.next();
            list.add(create(t, name, LocalDate.parse(sc.next())));
        }
        for (Plan p : list) System.out.println(p.name + ": " + p.renewalDate());
    }
}
