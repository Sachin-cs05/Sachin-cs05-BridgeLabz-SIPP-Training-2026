import java.util.Scanner;
public class ShortestLongestWords {
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
    public static String[] customSplit(String text) {
        int wordCount = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        String[] words = new String[wordCount];
        int start = 0;
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
        }
        words[index] = text.substring(start);
        return words;
    }
    public static String[][] wordLengths(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(customLength(words[i]));
        }
        return table;
    }
    public static int[] findShortestAndLongest(String[][] table) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int shortestLength = Integer.parseInt(table[0][1]);
        int longestLength = shortestLength;
        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);
            if (length < shortestLength) {
                shortestLength = length;
                shortestIndex = i;
            }
            if (length > longestLength) {
                longestLength = length;
                longestIndex = i;
            }
        }
        return new int[] { shortestIndex, longestIndex };
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] words = customSplit(text);
        String[][] table = wordLengths(words);
        int[] result = findShortestAndLongest(table);
        System.out.println("Shortest: " + table[result[0]][0] + " " + table[result[0]][1]);
        System.out.println("Longest: " + table[result[1]][0] + " " + table[result[1]][1]);
        scanner.close();
    }
}
