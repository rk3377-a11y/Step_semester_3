package polymorphism.class_problems;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ExamGrader {
    static abstract class Question {
        final String label, correct, student; final double points;
        Question(String l, String c, String s, double p) { label = l; correct = c; student = s; points = p; }
        abstract double score();
    }
    static class Mcq extends Question {
        Mcq(String l, String c, String s, double p) { super(l, c, s, p); }
        double score() { return student.equals(correct) ? points : 0; }
    }
    static class TrueFalse extends Question {
        TrueFalse(String l, String c, String s, double p) { super(l, c, s, p); }
        double score() { return student.equals(correct) ? points : 0; }
    }
    static class Essay extends Question {
        Essay(String l, String c, String s, double p) { super(l, c, s, p); }
        double score() {
            String ans = student.toLowerCase();
            int hits = 0;
            for (String k : correct.split(",")) {
                k = k.trim().toLowerCase();
                if (!k.isEmpty() && ans.contains(k)) hits++;
            }
            return hits >= 2 ? points * 0.75 : hits == 1 ? points * 0.5 : 0;
        }
    }
    static Question create(String t, String c, String s, double p) {
        return switch (t) {
            case "MCQ" -> new Mcq(t, c, s, p);
            case "TF" -> new TrueFalse(t, c, s, p);
            default -> new Essay(t, c, s, p);
        };
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Pattern quoted = Pattern.compile("\"([^\"]*)\"");
        List<Question> list = new ArrayList<>();
        while (list.size() < n) {
            String line = br.readLine();
            if (line == null) break;
            line = line.trim();
            if (line.isEmpty()) continue;
            String type = line.substring(0, line.indexOf(' '));
            Matcher m = quoted.matcher(line);
            List<String> q = new ArrayList<>();
            while (m.find()) q.add(m.group(1));
            double pts = Double.parseDouble(line.substring(line.lastIndexOf('"') + 1).trim());
            list.add(create(type, q.get(1), q.get(2), pts));
        }
        double total = 0;
        for (Question q : list) {
            double s = q.score(); total += s;
            System.out.printf(Locale.US, "%s: %.2f%n", q.label, s);
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}
