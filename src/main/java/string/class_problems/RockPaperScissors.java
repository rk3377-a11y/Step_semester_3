import java.util.Random;

public class RockPaperScissors {

    static String[] moves = {"Rock", "Paper", "Scissors"};

    public static String getComputerMove(Random rand) {
        return moves[rand.nextInt(3)];
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int rounds = 5;

        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] roundResults = new String[rounds];
        String[] computerMoves = new String[rounds];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            String computerMove = getComputerMove(rand);
            String result = playRound(playerMoves[i], computerMove);

            computerMoves[i] = computerMove;
            roundResults[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + " | " + playerMoves[i] + " | " + computerMoves[i] + " | " + roundResults[i]);
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.println("\nWins: " + wins + " | Losses: " + losses + " | Draws: " + draws +
                " | Win % = " + winPercentage + "%");
    }
}