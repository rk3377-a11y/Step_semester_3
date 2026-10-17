package abstraction_interface.class_problems;

import java.util.*;

public class LibraryLateFine {
    static abstract class Item {
        final String title; final int daysLate;
        Item(String t, int d) { title = t; daysLate = d; }
        abstract double fine();
    }
    static class Book extends Item {
        Book(String t, int d) { super(t, d); }
        double fine() { return 2.0 * daysLate; }
    }
    static class Dvd extends Item {
        Dvd(String t, int d) { super(t, d); }
        double fine() { return Math.min(50.0, 5.0 * daysLate); }
    }
    static class Magazine extends Item {
        Magazine(String t, int d) { super(t, d); }
        double fine() { return 1.0 * daysLate; }
    }
    static Item create(String type, String title, int d) {
        return switch (type) {
            case "BOOK" -> new Book(title, d);
            case "DVD" -> new Dvd(title, d);
            default -> new Magazine(title, d);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = sc.next(); String title = sc.next();
            list.add(create(t, title, sc.nextInt()));
        }
        double total = 0;
        for (Item it : list) {
            double f = it.fine(); total += f;
            System.out.printf(Locale.US, "%s: %.2f%n", it.title, f);
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}
