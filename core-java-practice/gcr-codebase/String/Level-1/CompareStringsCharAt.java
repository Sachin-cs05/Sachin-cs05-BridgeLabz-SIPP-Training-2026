import java.util.Scanner;
public class CompareStringsCharAt {
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
        String first = scanner.next();
        String second = scanner.next();
        boolean charAtResult = compareCharAt(first, second);
        boolean equalsResult = first.equals(second);
        System.out.println(charAtResult);
        System.out.println(equalsResult);
        System.out.println(charAtResult == equalsResult);
        scanner.close();
    }
}
