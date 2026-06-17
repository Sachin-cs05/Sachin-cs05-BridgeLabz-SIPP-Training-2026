public class CheckPalindromeRecursion {
    
    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindrome(str.substring(1, str.length() - 1));
    }
    
    public static boolean isPalindromeIgnoreCase(String str) {
        str = str.toLowerCase().replaceAll(" ", "");
        return isPalindrome(str);
    }
    
    public static void main(String[] args) {
        String test1 = "madam";
        System.out.println("Is '" + test1 + "' a palindrome? " + isPalindrome(test1));
    }
}
