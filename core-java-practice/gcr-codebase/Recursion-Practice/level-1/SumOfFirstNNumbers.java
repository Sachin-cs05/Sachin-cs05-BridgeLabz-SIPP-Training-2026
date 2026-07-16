public class SumOfFirstNNumbers {
    public static int sumOfNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNumbers(n - 1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Sum of first " + n + " natural numbers: " + sumOfNumbers(n));
    }
}
