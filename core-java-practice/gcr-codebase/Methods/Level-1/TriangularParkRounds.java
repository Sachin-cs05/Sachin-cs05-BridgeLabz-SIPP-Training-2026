import java.util.Scanner;

public class TriangularParkRounds {
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distanceInMeters = 5000;
        return distanceInMeters / perimeter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter side 1 in meters: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 in meters: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 in meters: ");
        double side3 = input.nextDouble();

        double rounds = calculateRounds(side1, side2, side3);

        System.out.println("The athlete must complete " + rounds + " rounds to cover 5 km.");

        input.close();
    }
}
