package data_structure.assigment_problems;

import java.util.*;

/**
 * Input : n, then n scores.
 * Time  : O(n), single pass, no sorting      Extra space: O(1)
 * Sorting first would cost O(n log n) time (and O(1)-O(n) space depending on the sort),
 * and it would also modify the array, which the problem forbids.
 */
public class SecondBestScore {
    static int secondHighest(int[] scores) {
        int highest = -1, second = -1;
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;
            }
        }
        return second;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        System.out.println(secondHighest(scores));
    }
}
