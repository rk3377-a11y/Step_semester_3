package data_structure.assigment_problems;

import java.util.*;

/**
 * Input : r c, then r*c integers (row by row).
 * Time  : O(r * c)    Extra space: O(1)
 */
public class BusiestBusRow {
    static int[] busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = -1;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) total += grid[i][j];
            if (total > bestTotal) { bestTotal = total; bestRow = i; }   // strictly larger keeps smaller index on ties
        }
        return new int[]{bestRow, bestTotal};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) grid[i][j] = sc.nextInt();
        int[] res = busiestRow(grid);
        System.out.println("Row " + res[0] + ", Total " + res[1]);
    }
}
