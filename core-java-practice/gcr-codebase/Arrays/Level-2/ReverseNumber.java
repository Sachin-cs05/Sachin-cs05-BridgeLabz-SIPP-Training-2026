import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        long num = sc.nextLong();
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }

        int maxDigit = 20; // allow reasonably large numbers
        int[] digits = new int[maxDigit];
        int idx = 0;

        if (num == 0) {
            digits[idx++] = 0;
        } else {
            while (num != 0) {
                if (idx == digits.length) {
                    int[] tmp = new int[digits.length + 10];
                    System.arraycopy(digits, 0, tmp, 0, digits.length);
                    digits = tmp;
                }
                digits[idx++] = (int) (num % 10);
                num /= 10;
            }
        }

        System.out.println("Digits in reverse order (reversed number):");
        if (negative) System.out.print("-");
        for (int i = 0; i < idx; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();

        sc.close();
    }
}
