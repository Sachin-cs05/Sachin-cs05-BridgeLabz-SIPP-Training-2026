import java.util.Scanner;
public class CardDeckDistribution {
    public static String[] initializeDeck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }
        return deck;
    }
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }
    public static String[][] distributeCards(String[] deck, int n, int players) {
        if (n % players != 0) {
            return new String[0][];
        }
        int cardsPerPlayer = n / players;
        String[][] result = new String[players][cardsPerPlayer];
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                result[i][j] = deck[i * cardsPerPlayer + j];
            }
        }
        return result;
    }
    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (int j = 0; j < players[i].length; j++) {
                System.out.print(players[i][j]);
                if (j < players[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int players = scanner.nextInt();
        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);
        String[][] distributed = distributeCards(deck, n, players);
        if (distributed.length == 0) {
            System.out.println("Cannot distribute cards evenly");
        } else {
            printPlayers(distributed);
        }
        scanner.close();
    }
}
