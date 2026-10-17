package data_structure.class_problems;

import java.util.*;

public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.next();
            String reversed = new StringBuilder(word).reverse().toString();
            System.out.println(reversed + (word.equals(reversed) ? " - palindrome" : " - not a palindrome"));
        }
    }
}
