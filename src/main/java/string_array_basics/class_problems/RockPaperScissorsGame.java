package string_array_basics.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {
    public static String playRound(String playerMove, String computerMove) {
        String player = playerMove.trim().toLowerCase();
        String computer = computerMove.trim().toLowerCase();
        if (player.equals(computer)) return "Draw";
        if ((player.equals("rock") && computer.equals("scissors"))
                || (player.equals("paper") && computer.equals("rock"))
                || (player.equals("scissors") && computer.equals("paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random(7);
        int wins = 0, losses = 0, draws = 0;
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int round = 0; round < moves.length; round++) {
            String computerMove = choices[random.nextInt(choices.length)];
            String result = playRound(moves[round], computerMove);
            System.out.printf("%d | %s | %s | %s%n", round + 1, moves[round], computerMove, result);
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, wins * 100.0 / moves.length);
    }
}
