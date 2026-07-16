import java.util.Scanner;
public class UniqueCharacterFrequency {
    public static char[] uniqueCharacters(String text) {
        char[] unique = new char[text.length()];
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean exists = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                unique[uniqueCount++] = ch;
            }
        }
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }
        return result;
    }
    public static String[][] frequencyTable(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        char[] unique = uniqueCharacters(text);
        String[][] table = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            table[i][0] = String.valueOf(unique[i]);
            table[i][1] = String.valueOf(freq[unique[i]]);
        }
        return table;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[][] table = frequencyTable(text);
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + " " + table[i][1]);
        }
        scanner.close();
    }
}