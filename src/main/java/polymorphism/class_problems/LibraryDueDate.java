package polymorphism.class_problems;

import java.time.LocalDate;
import java.util.*;

public class LibraryDueDate {
    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    static abstract class Item {
        final String title;
        Item(String title) { this.title = title; }
        abstract int borrowDays();
        LocalDate dueDate() { return CURRENT_DATE.plusDays(borrowDays()); }
    }
    static class Book extends Item {
        Book(String t) { super(t); }
        int borrowDays() { return 14; }
    }
    static class Dvd extends Item {
        Dvd(String t) { super(t); }
        int borrowDays() { return 7; }
    }
    static class Magazine extends Item {
        Magazine(String t) { super(t); }
        int borrowDays() { return 3; }
    }
    static Item create(String type, String title) {
        return switch (type) {
            case "BOOK" -> new Book(title);
            case "DVD" -> new Dvd(title);
            default -> new Magazine(title);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Item> items = new ArrayList<>();
        while (items.size() < n && sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            int sp = line.indexOf(' ');
            String type = line.substring(0, sp);
            String title = line.substring(sp + 1).trim().replace("\"", "");
            items.add(create(type, title));
        }
        for (Item it : items) System.out.println(it.title + ": " + it.dueDate());
    }
}
