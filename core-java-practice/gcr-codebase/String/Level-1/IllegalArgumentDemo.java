import java.util.Scanner;
public class IllegalArgumentDemo {
    public static void generateException(String text) {
        System.out.println(text.substring(5, 2));
    }
    public static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        try {
            generateException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException thrown");
        }
        handleException(text);
        scanner.close();
    }
}
