package abstraction_interface.assigment_problems;

import java.util.*;

public class CollegeFeeCounter {
    interface BusUser { }   // marker: this student uses the college bus

    static abstract class Student {
        static final double TRANSPORT_FEE = 12000;   // written once
        final String name;
        Student(String name) { this.name = name; }
        abstract double tuitionAndExtras();
        final double totalFee() {
            return tuitionAndExtras() + (this instanceof BusUser ? TRANSPORT_FEE : 0);
        }
    }
    static class DayScholar extends Student implements BusUser {
        DayScholar(String n) { super(n); }
        double tuitionAndExtras() { return 40000; }
    }
    static class Hosteller extends Student {
        Hosteller(String n) { super(n); }
        double tuitionAndExtras() { return 40000 + 60000; }
    }
    static class Scholar extends Student implements BusUser {
        Scholar(String n) { super(n); }
        double tuitionAndExtras() { return 20000; }
    }
    static Student create(String t, String name) {
        return switch (t) {
            case "DAY_SCHOLAR" -> new DayScholar(name);
            case "HOSTELLER" -> new Hosteller(name);
            default -> new Scholar(name);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) { String t = sc.next(); list.add(create(t, sc.next())); }
        double total = 0;
        for (Student s : list) {
            double f = s.totalFee(); total += f;
            System.out.printf(Locale.US, "%s: %.2f%n", s.name, f);
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}
