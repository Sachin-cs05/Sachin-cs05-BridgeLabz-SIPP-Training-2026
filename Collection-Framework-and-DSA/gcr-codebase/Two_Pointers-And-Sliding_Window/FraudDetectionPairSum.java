import java.util.Arrays;

public class FraudDetectionPairSum {

    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {
            int sum = transactions[left] + transactions[right];

            if (sum == target) {
                return new int[]{transactions[left], transactions[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] transactions = {1000, 2000, 3500, 7000, 9000};
        int target = 10500;

        int[] result = findPairSum(transactions, target);

        if (result[0] == -1) {
            System.out.println("No pair found.");
        } else {
            System.out.println("Pair found: " + Arrays.toString(result));
        }
    }
}