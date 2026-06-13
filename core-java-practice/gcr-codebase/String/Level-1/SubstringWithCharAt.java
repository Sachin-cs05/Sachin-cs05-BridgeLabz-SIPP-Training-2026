import java.util.Scanner;
public class SubstringWithCharAt {
    public static String substringWithCharAt(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end && i < text.length(); i++) {
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
        String text = scanner.next();
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        String userSubstring = substringWithCharAt(text, start, end);
        String builtSubstring = text.substring(start, end);
        boolean equal = compareCharAt(userSubstring, builtSubstring);
        System.out.println(userSubstring);
        System.out.println(builtSubstring);
        System.out.println(equal);
        scanner.close();
    }
}
