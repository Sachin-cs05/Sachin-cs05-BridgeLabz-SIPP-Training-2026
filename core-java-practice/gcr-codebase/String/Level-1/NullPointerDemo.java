public class NullPointerDemo {
    public static void generateException() {
        String text = null;
        text.length();
    }
    public static void handleException() {
        String text = null;
        try {
            text.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[] args) {
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown");
        }
        handleException();
    }
}
