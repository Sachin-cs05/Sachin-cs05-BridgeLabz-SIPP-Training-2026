import java.util.Arrays;

public class SelectionSortExamScores {
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {56, 23, 89, 12, 45, 78};

        System.out.println("Before Sorting: " + Arrays.toString(scores));
        selectionSort(scores);
        System.out.println("After Sorting: " + Arrays.toString(scores));
    }
}