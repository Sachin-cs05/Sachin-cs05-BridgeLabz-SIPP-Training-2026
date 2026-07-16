import java.util.Scanner;

public class BMIOfTeam {
    public static void calculateBMI(double[][] personData) {
        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double heightInCm = personData[i][1];
            double heightInMeters = heightInCm / 100.0;
            personData[i][2] = weight / Math.pow(heightInMeters, 2);
        }
    }

    public static String[] findBMIStatus(double[][] personData) {
        String[] status = new String[personData.length];

        for (int i = 0; i < personData.length; i++) {
            double bmi = personData[i][2];

            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] personData = new double[10][3];

        for (int i = 0; i < personData.length; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            personData[i][0] = input.nextDouble();

            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            personData[i][1] = input.nextDouble();
        }

        calculateBMI(personData);
        String[] bmiStatus = findBMIStatus(personData);

        System.out.println("Weight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < personData.length; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t\t%s%n",
                personData[i][0], personData[i][1], personData[i][2], bmiStatus[i]);
        }

        input.close();
    }
}
