public class UsernameValidator {

    static boolean isValidUsername(String username, int index) {
        if (index == username.length()) {
            return true;
        }

        char ch = username.charAt(index);

        if (ch < 'a' || ch > 'z') {
            return false;
        }

        return isValidUsername(username, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("abcdxyz", 0));
        System.out.println(isValidUsername("abcD123", 0));
    }
}