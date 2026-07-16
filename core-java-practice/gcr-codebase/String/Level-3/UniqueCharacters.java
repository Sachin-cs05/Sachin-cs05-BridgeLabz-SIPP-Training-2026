import java.util.Scanner;
public class UniqueCharacters {
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
    public static char[] uniqueCharacters(String text) {
        int length = customLength(text);
        char[] unique = new char[length];
        int uniqueCount = 0;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unique[uniqueCount++] = ch;
            }
        }
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char[] result = uniqueCharacters(text);
        for (char ch : result) {
            System.out.print(ch);
        }
        scanner.close();
    }
}