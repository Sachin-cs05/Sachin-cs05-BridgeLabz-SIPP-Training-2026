import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 10;
        double[] salary = new double[N];
        double[] years = new double[N];
        double[] bonus = new double[N];
        double[] newSalary = new double[N];

        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < N; i++) {
            System.out.printf("Employee %d - Salary: ", i + 1);
            double s = sc.nextDouble();
            System.out.printf("Employee %d - Years of service: ", i + 1);
            double y = sc.nextDouble();

            if (s <= 0 || y < 0) {
                System.out.println("Invalid input. Salary must be > 0 and years >= 0. Please re-enter this employee.");
                i--; // repeat this index
                continue;
            }

            salary[i] = s;
            years[i] = y;
        }

        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        double totalBonus = 0.0;

        for (int i = 0; i < N; i++) {
            double b = (years[i] > 5) ? salary[i] * 0.05 : salary[i] * 0.02;
            bonus[i] = b;
            newSalary[i] = salary[i] + b;

            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
            totalBonus += b;
        }

        System.out.println("\nEmployee-wise details:");
        for (int i = 0; i < N; i++) {
            System.out.printf("%d: Old=%.2f, Bonus=%.2f, New=%.2f\n", i + 1, salary[i], bonus[i], newSalary[i]);
        }

        System.out.println();
        System.out.printf("Total old salary: %.2f\n", totalOldSalary);
        System.out.printf("Total bonus payout: %.2f\n", totalBonus);
        System.out.printf("Total new salary: %.2f\n", totalNewSalary);

        sc.close();
    }
}
