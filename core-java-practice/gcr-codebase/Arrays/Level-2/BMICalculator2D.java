import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number;
        while (true) {
            System.out.print("Enter number of persons: ");
            number = sc.nextInt();
            if (number > 0) break;
            System.out.println("Please enter a positive integer.");
        }

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        System.out.println("(Enter weight in kilograms and height in meters)");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d - Weight (kg): ", i + 1);
            double w = sc.nextDouble();
            System.out.printf("Person %d - Height (m): ", i + 1);
            double h = sc.nextDouble();

            if (w <= 0 || h <= 0) {
                System.out.println("Invalid input. Weight and height must be > 0. Please re-enter this person.");
                i--; // repeat
                continue;
            }

            personData[i][0] = w;
            personData[i][1] = h;
        }

        for (int i = 0; i < number; i++) {
            double w = personData[i][0];
            double h = personData[i][1];
            double bmi = w / (h * h);
            personData[i][2] = bmi;

            if (bmi <= 18.4) weightStatus[i] = "Underweight";
            else if (bmi <= 24.9) weightStatus[i] = "Normal";
            else if (bmi <= 39.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        System.out.println();
        System.out.printf("%4s %12s %12s %8s %12s\n", "No.", "Weight(kg)", "Height(m)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < number; i++) {
            System.out.printf("%3d   %10.2f %10.2f %8.2f   %s\n", i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        sc.close();
    }
}
