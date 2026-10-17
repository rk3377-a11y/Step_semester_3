package data_structure.assigment_problems;

import java.util.*;

/**
 * Input : n, then n sorted scores, then low and high.
 *
 * Linear scan      : O(n) time, O(1) space.
 * Final solution   : O(log n) time (two binary searches), O(1) space.
 *
 * Duplicates: a standard binary search stops at ANY matching element, which could be
 * the middle of a run of equal scores. So we search for boundaries instead:
 *   - first index with score >= low   (leftmost position of the band)
 *   - first index with score >  high  (one past the band's end)
 * Count = second index - first index, which includes every duplicate at both edges.
 */
public class ExamScoreBandCounter {
    // first index i such that scores[i] >= target (n if none)
    static int lowerBound(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        int start = lowerBound(scores, low);        // first score >= low
        int end = lowerBound(scores, high + 1);     // first score > high
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        int low = sc.nextInt(), high = sc.nextInt();
        System.out.println(countInBand(scores, low, high));
    }
}
