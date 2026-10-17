package data_structure.class_problems;

import java.util.*;

public class InPlaceReversal {
    static int[] parse(String line) {
        line = line.replace("[", "").replace("]", "").trim();
        if (line.isEmpty()) return new int[0];
        String[] p = line.split("[,\\s]+");
        int[] a = new int[p.length];
        for (int i = 0; i < p.length; i++) a[i] = Integer.parseInt(p[i]);
        return a;
    }
    static void reverse(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            int t = a[i]; a[i] = a[j]; a[j] = t;
            i++; j--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tokens = parse(sc.nextLine());
        reverse(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
