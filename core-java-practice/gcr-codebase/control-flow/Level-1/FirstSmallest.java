import java.util.Scanner;

public class FirstSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();

        boolean result = (num1 < num2 && num1 < num3);

        System.out.println("Is the first number the smallest? " + result);

        sc.close();
    }
}