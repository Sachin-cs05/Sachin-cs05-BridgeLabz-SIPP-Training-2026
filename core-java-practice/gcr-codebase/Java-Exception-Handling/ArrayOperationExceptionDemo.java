public class ArrayOperationExceptionDemo {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        int index = 3;
        try {
            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
