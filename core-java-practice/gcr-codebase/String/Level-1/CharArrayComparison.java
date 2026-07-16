import java.util.Scanner;
public class CharArrayComparison {
    public static char[] toCharArrayCustom(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }
    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        char[] custom = toCharArrayCustom(text);
        char[] builtin = text.toCharArray();
        boolean equal = compareArrays(custom, builtin);
        System.out.println(custom);
        System.out.println(builtin);
        System.out.println(equal);
        scanner.close();
    }
}
