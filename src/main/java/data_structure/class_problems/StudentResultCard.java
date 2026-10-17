package data_structure.class_problems;

import java.util.*;

public class StudentResultCard {
    static class Student {
        private final String name;
        private final int[] marks;
        Student(String name, int[] marks) { this.name = name; this.marks = marks; }
        double average() {
            int sum = 0;
            for (int m : marks) sum += m;
            return (double) sum / marks.length;
        }
        char grade() {
            double avg = average();
            if (avg >= 90) return 'A';
            else if (avg >= 75) return 'B';
            else if (avg >= 60) return 'C';
            else if (avg >= 40) return 'D';
            else return 'F';
        }
        void print() {
            System.out.printf(Locale.US, "%s: Average %.1f, Grade %c%n", name.toUpperCase(), average(), grade());
        }
    }
    static int[] parse(String s) {
        s = s.replace("[", "").replace("]", "").trim();
        String[] p = s.split("[,\\s]+");
        int[] a = new int[p.length];
        for (int i = 0; i < p.length; i++) a[i] = Integer.parseInt(p[i]);
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            int b = line.indexOf('[');
            new Student(line.substring(0, b).trim(), parse(line.substring(b))).print();
        }
    }
}
