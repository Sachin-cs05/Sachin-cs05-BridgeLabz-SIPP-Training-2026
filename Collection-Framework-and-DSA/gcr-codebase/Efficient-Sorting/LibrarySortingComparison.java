import java.util.Random;

public class LibrarySortingComparison {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void countingSort(int[] arr, int maxValue) {
        int[] count = new int[maxValue + 1];

        for (int value : arr) {
            count[value]++;
        }

        int index = 0;
        for (int i = 0; i <= maxValue; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound) + 1;
        }

        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void compareRuntime(int size) {
        int[] base = generateRandomArray(size, 20);

        int[] mergeArr = copyArray(base);
        int[] quickArr = copyArray(base);
        int[] countingArr = copyArray(base);

        long start = System.nanoTime();
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        long mergeTime = System.nanoTime() - start;

        start = System.nanoTime();
        quickSort(quickArr, 0, quickArr.length - 1);
        long quickTime = System.nanoTime() - start;

        start = System.nanoTime();
        countingSort(countingArr, 20);
        long countingTime = System.nanoTime() - start;

        System.out.println("Size: " + size);
        System.out.println("Merge Sort Time: " + mergeTime + " ns");
        System.out.println("Quick Sort Time: " + quickTime + " ns");
        System.out.println("Counting Sort Time: " + countingTime + " ns");
        System.out.println();
    }

    public static void main(String[] args) {
        compareRuntime(100);
        compareRuntime(1000);
        compareRuntime(10000);
    }
}