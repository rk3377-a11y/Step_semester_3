package data_structure.class_problems;

import java.math.BigInteger;
import java.util.*;

public class FactorialCalculation {
    static BigInteger factorial(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 2; i <= n; i++) f = f.multiply(BigInteger.valueOf(i));
        return f;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) System.out.println(factorial(sc.nextInt()));
    }
}
