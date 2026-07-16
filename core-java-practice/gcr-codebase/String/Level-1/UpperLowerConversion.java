import java.util.Scanner;
public class UpperLowerConversion {
    public static String toUpperCustom(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static String toLowerCustom(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
            } else {
                result.append(ch);
            }
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
        String upperCustom = toUpperCustom(text);
        String upperBuilt = text.toUpperCase();
        boolean upperEqual = compareCharAt(upperCustom, upperBuilt);
        System.out.println(upperCustom);
        System.out.println(upperBuilt);
        System.out.println(upperEqual);
        String lowerCustom = toLowerCustom(text);
        String lowerBuilt = text.toLowerCase();
        boolean lowerEqual = compareCharAt(lowerCustom, lowerBuilt);
        System.out.println(lowerCustom);
        System.out.println(lowerBuilt);
        System.out.println(lowerEqual);
        scanner.close();
    }
}