package data_structure.assigment_problems;

import java.util.*;

/**
 * Input : n, then n names, then k.
 * Time  : O(n)    Extra space: O(n) for the rotated array.
 * Rotating one place at a time k times costs O(n * k); with k up to 10^9 that is far too slow,
 * and k % n removes the full turns so only n - 1 shifts of work are ever needed.
 */
public class DutyRosterRotation {
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] out = new String[n];
        for (int i = 0; i < n; i++) out[(i + shift) % n] = names[i];
        return out;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = sc.next();
        long k = sc.nextLong();
        System.out.println(Arrays.toString(rotateRoster(names, k)));
    }
}
