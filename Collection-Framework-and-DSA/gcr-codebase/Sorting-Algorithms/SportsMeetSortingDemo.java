import java.util.Arrays;

public class SportsMeetSortingDemo {

    public static int bubbleSort(int[] arr) {
        int n = arr.length;
        int totalSwaps = 0;
        boolean alreadySorted = true;

        System.out.println("Bubble Sort Pass-by-Pass:");
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    totalSwaps++;
                    swapped = true;
                }
            }

            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(arr));

            if (!swapped) {
                break;
            } else {
                alreadySorted = false;
            }
        }

        System.out.println("Already Sorted (Best Case): " + alreadySorted);
        return totalSwaps;
    }

    public static int insertionSort(int[] arr) {
        int n = arr.length;
        int shifts = 0;

        System.out.println("\nInsertion Sort Pass-by-Pass:");
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                shifts++;
            }
            arr[j + 1] = key;

            System.out.println("Pass " + i + ": " + Arrays.toString(arr));
        }

        return shifts;
    }

    public static void printTop3(int[] scores) {
        int n = scores.length;
        int[] copy = Arrays.copyOf(scores, n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (copy[j] > copy[j + 1]) {
                    int temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }

        System.out.println("\nTop 3 Medalists Scores:");
        for (int i = n - 1; i >= n - 3; i--) {
            System.out.println(copy[i]);
        }
    }

    public static void main(String[] args) {
        int[] athletesScores = {55, 78, 90, 45, 88, 67, 99, 72, 81, 60};
        int[] bubbleArray = Arrays.copyOf(athletesScores, athletesScores.length);
        int[] insertionArray = Arrays.copyOf(athletesScores, athletesScores.length);

        System.out.println("Original Scores: " + Arrays.toString(athletesScores));

        int bubbleSwaps = bubbleSort(bubbleArray);
        System.out.println("Bubble Sorted Scores: " + Arrays.toString(bubbleArray));
        System.out.println("Total Bubble Sort Swaps: " + bubbleSwaps);

        int insertionShifts = insertionSort(insertionArray);
        System.out.println("Insertion Sorted Scores: " + Arrays.toString(insertionArray));
        System.out.println("Total Insertion Sort Shifts: " + insertionShifts);

        printTop3(athletesScores);

        System.out.println("\nTrace for [64, 25, 12, 22, 11] using Bubble Sort:");
        int[] traceArray = {64, 25, 12, 22, 11};
        bubbleSort(traceArray);

        System.out.println("\nTrace for [64, 25, 12, 22, 11] using Insertion Sort:");
        int[] traceArray2 = {64, 25, 12, 22, 11};
        insertionSort(traceArray2);
    }
}