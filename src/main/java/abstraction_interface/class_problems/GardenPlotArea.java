package abstraction_interface.class_problems;

import java.util.*;

public class GardenPlotArea {
    static abstract class Plot {
        final String owner, shape;
        Plot(String owner, String shape) { this.owner = owner; this.shape = shape; }
        abstract double area();
    }
    static class Circle extends Plot {
        final double r;
        Circle(String o, double r) { super(o, "CIRCLE"); this.r = r; }
        double area() { return Math.PI * r * r; }
    }
    static class Rectangle extends Plot {
        final double l, w;
        Rectangle(String o, double l, double w) { super(o, "RECTANGLE"); this.l = l; this.w = w; }
        double area() { return l * w; }
    }
    static class Triangle extends Plot {
        final double b, h;
        Triangle(String o, double b, double h) { super(o, "TRIANGLE"); this.b = b; this.h = h; }
        double area() { return 0.5 * b * h; }
    }
    static Plot read(String shape, Scanner sc) {
        String owner = sc.next();
        return switch (shape) {
            case "CIRCLE" -> new Circle(owner, sc.nextDouble());
            case "RECTANGLE" -> new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
            default -> new Triangle(owner, sc.nextDouble(), sc.nextDouble());
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) plots.add(read(sc.next(), sc));
        double total = 0;
        for (Plot p : plots) {
            double a = p.area(); total += a;
            System.out.printf(Locale.US, "%s (%s): %.2f%n", p.owner, p.shape, a);
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}
