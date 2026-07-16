import java.util.Scanner;
public class StudentVotingAge {
    public static int[] randomAges(int count) {
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            ages[i] = 10 + (int)(Math.random() * 90);
        }
        return ages;
    }
    public static String[][] votingInfo(int[] ages) {
        String[][] info = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            boolean canVote = ages[i] >= 18;
            info[i][0] = String.valueOf(ages[i]);
            info[i][1] = String.valueOf(canVote);
        }
        return info;
    }
    public static void displayTable(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + " " + table[i][1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] ages = randomAges(count);
        String[][] table = votingInfo(ages);
        displayTable(table);
        scanner.close();
    }
}
