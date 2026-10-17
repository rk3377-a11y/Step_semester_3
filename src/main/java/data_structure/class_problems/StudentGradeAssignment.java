package data_structure.class_problems;

import java.util.*;

public class StudentGradeAssignment {
    static char grade(double marks) {
        if (marks >= 90) return 'A';
        else if (marks >= 75) return 'B';
        else if (marks >= 60) return 'C';
        else if (marks >= 40) return 'D';
        else return 'F';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()) System.out.println("Grade " + grade(sc.nextDouble()));
    }
}
