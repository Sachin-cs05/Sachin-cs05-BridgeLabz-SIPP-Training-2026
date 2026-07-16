import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        while (true) {
            System.out.print("Enter number of persons: ");
            n = sc.nextInt();
            if (n > 0) break;
            System.out.println("Please enter a positive integer.");
        }

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        System.out.println("(Enter weight in kilograms and height in meters)");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d - Weight (kg): ", i + 1);
            double w = sc.nextDouble();
            System.out.printf("Person %d - Height (m): ", i + 1);
            double h = sc.nextDouble();

            if (w <= 0 || h <= 0) {
                System.out.println("Invalid input. Weight and height must be > 0. Please re-enter this person.");
                i--; // repeat
                continue;
            }

            weight[i] = w;
            height[i] = h;
        }

        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);
            double v = bmi[i];
            if (v <= 18.4) status[i] = "Underweight";
            else if (v <= 24.9) status[i] = "Normal";
            else if (v <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        System.out.println();
        System.out.printf("%5s %10s %10s %10s\n", "No.", "Weight(kg)", "Height(m)", "BMI");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%3d   %10.2f %10.2f %10.2f   %s\n", i + 1, weight[i], height[i], bmi[i], status[i]);
        }

        sc.close();
    }
}
