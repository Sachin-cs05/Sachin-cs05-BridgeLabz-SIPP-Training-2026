import java.util.Scanner;
public class StringLengthWithoutLength {
    public static int customLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        int custom = customLength(text);
        int builtin = text.length();
        System.out.println(custom);
        System.out.println(builtin);
        scanner.close();
    }
}
