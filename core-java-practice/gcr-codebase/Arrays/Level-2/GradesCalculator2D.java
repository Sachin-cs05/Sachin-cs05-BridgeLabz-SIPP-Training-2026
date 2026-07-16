import java.util.Scanner;

public class GradesCalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number;
        while (true) {
            System.out.print("Enter number of students: ");
            number = sc.nextInt();
            if (number > 0) break;
            System.out.println("Please enter a positive integer.");
        }

        double[][] marks = new double[number][3]; // physics, chemistry, maths
        double[] percentage = new double[number];
        String[] grade = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.printf("Student %d - Physics marks: ", i + 1);
            double p = sc.nextDouble();
            System.out.printf("Student %d - Chemistry marks: ", i + 1);
            double c = sc.nextDouble();
            System.out.printf("Student %d - Maths marks: ", i + 1);
            double m = sc.nextDouble();

            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Invalid input. Marks must be non-negative. Please re-enter this student.");
                i--; // repeat
                continue;
            }

            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;
        }

        for (int i = 0; i < number; i++) {
            double sum = marks[i][0] + marks[i][1] + marks[i][2];
            double pct = sum / 3.0;
            percentage[i] = pct;

            if (pct >= 80.0) grade[i] = "A";
            else if (pct >= 70.0) grade[i] = "B";
            else if (pct >= 60.0) grade[i] = "C";
            else if (pct >= 50.0) grade[i] = "D";
            else if (pct >= 40.0) grade[i] = "E";
            else grade[i] = "R";
        }

        System.out.println();
        System.out.printf("%4s %10s %10s %10s %12s %6s\n", "No.", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < number; i++) {
            System.out.printf("%3d   %8.2f %10.2f %10.2f %10.2f%%   %4s\n", i + 1, marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }

        sc.close();
    }
}
