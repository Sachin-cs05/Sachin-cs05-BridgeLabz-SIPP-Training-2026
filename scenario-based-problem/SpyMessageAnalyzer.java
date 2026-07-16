class SpyMessageAnalyzer {
    public static void main(String[] args) {
        String secretMessage = "level";
        String word = "surveillance";
        String firstMessage = "listen";
        String secondMessage = "silent";
        String log = "swiss";

        System.out.println("Reversed Message: " + reverse(secretMessage));
        System.out.println("Is Palindrome: " + isPalindrome(secretMessage));
        System.out.println("Vowels and Consonants: " + countVowelsAndConsonants(word));
        System.out.println("Are Anagrams: " + areAnagrams(firstMessage, secondMessage));
        System.out.println("First Non-Repeating Character: " + firstNonRepeatingCharacter(log));
    }

    public static String reverse(String text) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        return reversed;
    }

    public static boolean isPalindrome(String text) {
        return text.equals(reverse(text));
    }

    public static String countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        String lower = text.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        return "Vowels: " + vowels + ", Consonants: " + consonants;
    }

    public static boolean areAnagrams(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        char[] firstChars = first.toLowerCase().toCharArray();
        char[] secondChars = second.toLowerCase().toCharArray();
        sort(firstChars);
        sort(secondChars);

        for (int i = 0; i < firstChars.length; i++) {
            if (firstChars[i] != secondChars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void sort(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static char firstNonRepeatingCharacter(String text) {
        for (int i = 0; i < text.length(); i++) {
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    count++;
                }
            }
            if (count == 1) {
                return text.charAt(i);
            }
        }
        return '-';
    }
}
