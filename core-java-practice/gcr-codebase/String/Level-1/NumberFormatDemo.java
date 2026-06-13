import java.util.Scanner;
public class NumberFormatDemo {
    public static void generateException(String text) {
        Integer.parseInt(text);
    }
    public static void handleException(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        try {
            generateException(text);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException thrown");
        }
        handleException(text);
        scanner.close();
    }
}
