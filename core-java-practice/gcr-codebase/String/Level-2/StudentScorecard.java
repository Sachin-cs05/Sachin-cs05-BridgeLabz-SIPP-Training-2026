import java.util.Scanner;
public class StudentScorecard {
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            scores[i][0] = 10 + (int)(Math.random() * 90);
            scores[i][1] = 10 + (int)(Math.random() * 90);
            scores[i][2] = 10 + (int)(Math.random() * 90);
        }
        return scores;
    }
    public static String[][] calculateTotals(int[][] scores) {
        String[][] totals = new String[scores.length][4];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = Math.round((total / 3.0) * 100.0) / 100.0;
            double percentage = Math.round((total / 300.0 * 100.0) * 100.0) / 100.0;
            totals[i][0] = String.valueOf(total);
            totals[i][1] = String.valueOf(average);
            totals[i][2] = String.valueOf(percentage);
            totals[i][3] = gradeFromPercentage(percentage);
        }
        return totals;
    }
    public static String gradeFromPercentage(double percentage) {
        if (percentage >= 80) {
            return "A";
        }
        if (percentage >= 70) {
            return "B";
        }
        if (percentage >= 60) {
            return "C";
        }
        if (percentage >= 50) {
            return "D";
        }
        if (percentage >= 40) {
            return "E";
        }
        return "R";
    }
    public static void displayScorecard(int[][] scores, String[][] totals) {
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i][0] + " " + scores[i][1] + " " + scores[i][2] + " " + totals[i][0] + " " + totals[i][1] + " " + totals[i][2] + " " + totals[i][3]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt();
        int[][] scores = generateScores(students);
        String[][] totals = calculateTotals(scores);
        displayScorecard(scores, totals);
        scanner.close();
    }
}
