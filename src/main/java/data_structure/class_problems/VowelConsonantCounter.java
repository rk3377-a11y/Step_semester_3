package data_structure.class_problems;

import java.util.*;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toLowerCase();
        int vowels = 0, consonants = 0;
        for (char ch : word.toCharArray()) {
            if (!Character.isLetter(ch)) continue;
            if ("aeiou".indexOf(ch) >= 0) vowels++; else consonants++;
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
