import java.util.Scanner;

public class StoreNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        System.out.println("Enter positive numbers (0 or negative number to stop):");

        while (true) {
            double num = sc.nextDouble();

            // Stop if number is 0 or negative
            if (num <= 0) {
                break;

            }
            // Stop if array is full
            if (index == 10) {
                break;
            }

            numbers[index] = num;
            index++;
        }

        System.out.println("\nNumbers entered:");

        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }

        System.out.println("\n\nTotal Sum = " + total);

        sc.close();
    }
}