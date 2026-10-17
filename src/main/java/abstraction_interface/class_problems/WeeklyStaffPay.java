package abstraction_interface.class_problems;

import java.util.*;

public class WeeklyStaffPay {
    static abstract class Staff {
        final String name;
        Staff(String name) { this.name = name; }
        abstract double pay();
    }
    static class FullTime extends Staff {
        final double salary;
        FullTime(String n, double s) { super(n); salary = s; }
        double pay() { return salary; }
    }
    static class Hourly extends Staff {
        final double hours, rate;
        Hourly(String n, double h, double r) { super(n); hours = h; rate = r; }
        double pay() {
            return hours <= 40 ? hours * rate : 40 * rate + (hours - 40) * 1.5 * rate;
        }
    }
    static class Intern extends Staff {
        final double stipend;
        Intern(String n, double s) { super(n); stipend = s; }
        double pay() { return stipend; }
    }
    static Staff read(String t, Scanner sc) {
        String name = sc.next();
        return switch (t) {
            case "FULLTIME" -> new FullTime(name, sc.nextDouble());
            case "HOURLY" -> new Hourly(name, sc.nextDouble(), sc.nextDouble());
            default -> new Intern(name, sc.nextDouble());
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Staff> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(read(sc.next(), sc));
        double total = 0;
        for (Staff s : list) {
            double p = s.pay(); total += p;
            System.out.printf(Locale.US, "%s: %.2f%n", s.name, p);
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}
