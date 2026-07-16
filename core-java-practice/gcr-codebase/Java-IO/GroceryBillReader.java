import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GroceryBillReader {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("bill.txt"));
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;
            }
            System.out.println("Total lines = " + count);
        } catch (IOException e) {
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
