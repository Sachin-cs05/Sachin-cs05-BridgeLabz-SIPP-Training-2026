import java.util.Scanner;
public class VowelConsonantTypeTable {
    public static String charType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }
    public static String[][] typeCharacters(String text) {
        String[][] table = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            table[i][0] = String.valueOf(ch);
            table[i][1] = charType(ch);
        }
        return table;
    }
    public static void displayTable(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + " " + table[i][1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[][] table = typeCharacters(text);
        displayTable(table);
        scanner.close();
    }
}
