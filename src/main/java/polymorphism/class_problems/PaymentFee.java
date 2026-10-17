package polymorphism.class_problems;

import java.util.*;

public class PaymentFee {
    static abstract class Payment {
        final String label; final double amount;
        Payment(String label, double amount) { this.label = label; this.amount = amount; }
        abstract double finalAmount();
    }
    static class Card extends Payment {
        Card(String l, double a) { super(l, a); }
        double finalAmount() { return amount * 1.02; }
    }
    static class Wallet extends Payment {
        Wallet(String l, double a) { super(l, a); }
        double finalAmount() { return amount * 1.01; }
    }
    static class BankTransfer extends Payment {
        BankTransfer(String l, double a) { super(l, a); }
        double finalAmount() { return amount; }
    }
    static Payment create(String t, double a) {
        return switch (t) {
            case "CARD" -> new Card(t, a);
            case "WALLET" -> new Wallet(t, a);
            default -> new BankTransfer(t, a);
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> list = new ArrayList<>();
        for (int i = 0; i < n; i++) { String t = sc.next(); list.add(create(t, sc.nextDouble())); }
        double total = 0;
        for (Payment p : list) {
            double f = p.finalAmount(); total += f;
            System.out.printf(Locale.US, "%s: %.2f%n", p.label, f);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
