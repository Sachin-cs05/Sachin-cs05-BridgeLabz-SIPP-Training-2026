class WarehouseOperations {
    public static void main(String[] args) {
        int[] stock = {45, 12, 78, 34, 56, 90, 23, 67};

        System.out.println("Maximum Stock: " + findMax(stock));
        System.out.println("Minimum Stock: " + findMin(stock));
        System.out.println("Total Stock: " + findTotal(stock));
        System.out.print("Duplicate Values: ");
        printDuplicates(new int[]{12, 45, 78, 12, 34, 56, 45, 90});

        rotateRight(stock, 2);
        System.out.print("Rotated Stock: ");
        printArray(stock);

        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6}
        };

        System.out.println("Transposed Grid:");
        printMatrix(transpose(grid));
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static int findTotal(int[] arr) {
        int total = 0;
        for (int value : arr) {
            total += value;
        }
        return total;
    }

    public static void printDuplicates(int[] arr) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            boolean alreadyPrinted = false;
            for (int k = 0; k < i; k++) {
                if (arr[i] == arr[k]) {
                    alreadyPrinted = true;
                    break;
                }
            }
            if (alreadyPrinted) {
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(arr[i] + " ");
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }

    public static void rotateRight(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
