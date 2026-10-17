package data_structure.class_problems;

import java.util.*;

public class DigitSumReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0, rev = 0;
        while (n > 0) {
            long d = n % 10;
            sum += d;
            rev = rev * 10 + d;
            n /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + rev);
    }
}
