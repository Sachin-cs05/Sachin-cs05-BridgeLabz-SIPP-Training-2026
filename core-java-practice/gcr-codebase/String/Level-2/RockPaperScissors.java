import java.util.Scanner;
public class RockPaperScissors {
    public static String computerChoice() {
        double value = Math.random();
        if (value < 1.0 / 3.0) {
            return "rock";
        }
        if (value < 2.0 / 3.0) {
            return "paper";
        }
        return "scissors";
    }
    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "draw";
        }
        if (user.equals("rock") && computer.equals("scissors")
                || user.equals("paper") && computer.equals("rock")
                || user.equals("scissors") && computer.equals("paper")) {
            return "user";
        }
        return "computer";
    }
    public static String[][] statsTable(int userWins, int computerWins, int draws, int total) {
        String[][] table = new String[3][2];
        table[0][0] = "User";
        table[0][1] = String.valueOf(userWins);
        table[1][0] = "Computer";
        table[1][1] = String.valueOf(computerWins);
        table[2][0] = "Draws";
        table[2][1] = String.valueOf(draws);
        return table;
    }
    public static void displayResults(String[][] games, String[][] stats, int userWins, int computerWins, int total) {
        for (int i = 0; i < games.length; i++) {
            System.out.println(games[i][0] + " " + games[i][1] + " " + games[i][2]);
        }
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + " " + stats[i][1]);
        }
        System.out.println("User% " + (total == 0 ? 0 : (userWins * 100 / total)));
        System.out.println("Computer% " + (total == 0 ? 0 : (computerWins * 100 / total)));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int games = scanner.nextInt();
        String[][] gameResults = new String[games][3];
        int userWins = 0;
        int computerWins = 0;
        int draws = 0;
        for (int i = 0; i < games; i++) {
            String user = scanner.next();
            String computer = computerChoice();
            String winner = findWinner(user, computer);
            gameResults[i][0] = user;
            gameResults[i][1] = computer;
            gameResults[i][2] = winner;
            if (winner.equals("user")) {
                userWins++;
            } else if (winner.equals("computer")) {
                computerWins++;
            } else {
                draws++;
            }
        }
        String[][] stats = statsTable(userWins, computerWins, draws, games);
        displayResults(gameResults, stats, userWins, computerWins, games);
        scanner.close();
    }
}