import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double compositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), this.compositeScore());
        }
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 50;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }

        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            result.append(i + 1).append(". ").append(shortlistedArray[i].name)
                  .append(" (").append(shortlistedArray[i].compositeScore()).append(")");
            if (i < shortlistedArray.length - 1) result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
