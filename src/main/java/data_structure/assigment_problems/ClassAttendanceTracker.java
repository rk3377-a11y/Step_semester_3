package data_structure.assigment_problems;

import java.util.*;

/**
 * Input : n, then n values (0 or 1).
 * Time  : O(n) in a single pass    Extra space: O(1)
 */
public class ClassAttendanceTracker {
    static int[] attendanceSummary(int[] days) {
        int present = 0, run = 0, longest = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                run++;
                if (run > longest) longest = run;
            } else {
                run = 0;
            }
        }
        return new int[]{present, longest};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) days[i] = sc.nextInt();
        int[] res = attendanceSummary(days);
        System.out.println("Present: " + res[0] + ", Longest streak: " + res[1]);
    }
}
