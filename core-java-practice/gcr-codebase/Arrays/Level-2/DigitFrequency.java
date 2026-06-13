import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        long num = sc.nextLong();
        if (num < 0) num = -num;

        int[] freq = new int[10];

        if (num == 0) {
            freq[0] = 1;
        } else {
            while (num != 0) {
                int d = (int) (num % 10);
                freq[d]++;
                num /= 10;
            }
        }

        System.out.println("Digit frequencies:");
        for (int d = 0; d <= 9; d++) {
            System.out.printf("%d : %d\n", d, freq[d]);
        }

        sc.close();
    }
}
