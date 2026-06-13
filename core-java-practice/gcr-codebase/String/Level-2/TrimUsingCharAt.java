import java.util.Scanner;
public class TrimUsingCharAt {
    public static int[] trimBounds(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        return new int[] { start, end + 1 };
    }
    public static String substringWithCharAt(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }
    public static boolean compareCharAt(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int[] bounds = trimBounds(text);
        String customTrimmed = substringWithCharAt(text, bounds[0], bounds[1]);
        String builtTrimmed = text.trim();
        boolean equal = compareCharAt(customTrimmed, builtTrimmed);
        System.out.println(customTrimmed);
        System.out.println(builtTrimmed);
        System.out.println(equal);
        scanner.close();
    }
}
