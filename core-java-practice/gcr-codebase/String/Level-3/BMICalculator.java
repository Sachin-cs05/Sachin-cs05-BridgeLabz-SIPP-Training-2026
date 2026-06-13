import java.util.Scanner;
public class BMICalculator {
    public static String[][] computeBMI(int[][] measurements) {
        String[][] result = new String[measurements.length][4];
        for (int i = 0; i < measurements.length; i++) {
            int weight = measurements[i][0];
            int heightCm = measurements[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            double roundedBmi = Math.round(bmi * 100.0) / 100.0;
            result[i][0] = String.valueOf(weight);
            result[i][1] = String.valueOf(heightCm);
            result[i][2] = String.valueOf(roundedBmi);
            result[i][3] = bmiStatus(roundedBmi);
        }
        return result;
    }
    public static String bmiStatus(double bmi) {
        if (bmi >= 40.0) {
            return "Obese";
        }
        if (bmi >= 25.0) {
            return "Overweight";
        }
        if (bmi >= 18.5) {
            return "Normal";
        }
        return "Underweight";
    }
    public static void displayScorecard(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + " " + table[i][1] + " " + table[i][2] + " " + table[i][3]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] measurements = new int[10][2];
        for (int i = 0; i < 10; i++) {
            measurements[i][0] = scanner.nextInt();
            measurements[i][1] = scanner.nextInt();
        }
        String[][] table = computeBMI(measurements);
        displayScorecard(table);
        scanner.close();
    }
}
