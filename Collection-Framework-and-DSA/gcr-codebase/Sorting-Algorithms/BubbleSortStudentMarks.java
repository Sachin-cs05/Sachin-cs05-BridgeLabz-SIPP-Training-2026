import java.util.Arrays;

public class BubbleSortStudentMarks {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] marks = {78, 45, 90, 32, 67, 88};

        System.out.println("Before Sorting: " + Arrays.toString(marks));
        bubbleSort(marks);
        System.out.println("After Sorting: " + Arrays.toString(marks));
    }
}