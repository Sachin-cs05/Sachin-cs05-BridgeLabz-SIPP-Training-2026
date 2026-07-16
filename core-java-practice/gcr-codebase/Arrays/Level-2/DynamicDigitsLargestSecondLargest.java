import java.util.Scanner;

public class DynamicDigitsLargestSecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        long num = sc.nextLong();
        if (num < 0) num = -num;

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (num != 0) {
            if (index == maxDigit) {
                // increase size by 10
                int newSize = maxDigit + 10;
                int[] temp = new int[newSize];
                System.arraycopy(digits, 0, temp, 0, maxDigit);
                digits = temp;
                maxDigit = newSize;
            }
            digits[index++] = (int) (num % 10);
            num /= 10;
        }

        if (index == 0) {
            System.out.println("Input was 0. Largest = 0, Second largest = 0");
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
