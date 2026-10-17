package polymorphism.assigment_problems;

import java.util.*;

public class FestivalBonus {
    static abstract class Employee {
        final String name; final double salary;
        Employee(String n, double s) { name = n; salary = s; }
        abstract double bonus();
    }
    static class FullTime extends Employee {
        FullTime(String n, double s) { super(n, s); }
        double bonus() { return salary * 0.10; }
    }
    static class PartTime extends Employee {
        PartTime(String n, double s) { super(n, s); }
        double bonus() { return salary * 0.05; }
    }
    static class Intern extends Employee {
        Intern(String n, double s) { super(n, s); }
        double bonus() { return 2000; }
    }
    static Employee create(String t, String name, double s) {
        return switch (t) {
            case "FULLTIME" -> new FullTime(name, s);
            case "PARTTIME" -> new PartTime(name, s);
            default -> new Intern(name, s);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next(); String name = sc.next();
            list.add(create(t, name, sc.nextDouble()));
        }
        double total = 0;
        for (Employee e : list) {
            double b = e.bonus(); total += b;
            System.out.printf(Locale.US, "%s: %.2f%n", e.name, b);
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}
