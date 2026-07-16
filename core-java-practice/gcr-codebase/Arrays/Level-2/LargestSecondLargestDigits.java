import java.util.Scanner;

public class LargestSecondLargestDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a (non-negative) integer: ");
        long num = sc.nextLong();
        if (num < 0) num = -num;

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (num != 0 && index < maxDigit) {
            digits[index++] = (int) (num % 10);
            num /= 10;
        }

        if (index == 0) {
            System.out.println("No digits entered (input was 0). Largest = 0, Second largest = 0");
            sc.close();
            return;
        }

        int largest = 0;
        int second = 0;
        for (int i = 0; i < index; i++) {
            int v = digits[i];
            if (v > largest) {
                second = largest;
                largest = v;
            } else if (v > second && v != largest) {
                second = v;
            }
        }

        System.out.printf("Largest digit = %d\n", largest);
        System.out.printf("Second largest digit = %d\n", second);

        sc.close();
    }
}
