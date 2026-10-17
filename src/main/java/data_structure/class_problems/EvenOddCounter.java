package data_structure.class_problems;

import java.util.*;

public class EvenOddCounter {
    static int[] parse(String line) {
        line = line.replace("[", "").replace("]", "").trim();
        if (line.isEmpty()) return new int[0];
        String[] p = line.split("[,\\s]+");
        int[] a = new int[p.length];
        for (int i = 0; i < p.length; i++) a[i] = Integer.parseInt(p[i]);
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = parse(sc.nextLine());
        int even = 0, odd = 0;
        for (int x : nums) { if (x % 2 == 0) even++; else odd++; }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
