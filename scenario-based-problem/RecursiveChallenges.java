class RecursiveChallenges {
    static int moveCount = 0;

    public static void main(String[] args) {
        int disks = 3;
        System.out.println("Tower of Hanoi Steps:");
        solveTowerOfHanoi(disks, 'A', 'C', 'B');
        System.out.println("Total Moves: " + moveCount);

        int[] prices = {120, 180, 240, 300, 360, 420, 510};
        int target = 300;
        int index = binarySearch(prices, 0, prices.length - 1, target);
        System.out.println("Binary Search Index of " + target + ": " + index);

        int number = 5482;
        System.out.println("Sum of Digits of " + number + ": " + sumOfDigits(number));

        String text = "bridge";
        System.out.println("Reverse of " + text + ": " + reverseString(text));

        String brackets = "(()())";
        System.out.println("Balanced Parentheses: " + isBalanced(brackets, 0, 0));
    }

    public static void solveTowerOfHanoi(int n, char source, char destination, char helper) {
        if (n == 0) {
            return;
        }
        solveTowerOfHanoi(n - 1, source, helper, destination);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        moveCount++;
        solveTowerOfHanoi(n - 1, helper, destination, source);
    }

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target < arr[mid]) {
            return binarySearch(arr, left, mid - 1, target);
        }
        return binarySearch(arr, mid + 1, right, target);
    }

    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }

    public static String reverseString(String text) {
        if (text.length() <= 1) {
            return text;
        }
        return reverseString(text.substring(1)) + text.charAt(0);
    }

    public static boolean isBalanced(String text, int index, int openCount) {
        if (openCount < 0) {
            return false;
        }
        if (index == text.length()) {
            return openCount == 0;
        }
        char ch = text.charAt(index);
        if (ch == '(') {
            return isBalanced(text, index + 1, openCount + 1);
        }
        if (ch == ')') {
            return isBalanced(text, index + 1, openCount - 1);
        }
        return isBalanced(text, index + 1, openCount);
    }
}
