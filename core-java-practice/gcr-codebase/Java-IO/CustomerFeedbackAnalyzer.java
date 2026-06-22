import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 0; i < 5; i++) {
            String line = reader.readLine();
            if (line != null && line.toLowerCase().contains("good")) {
                count++;
            }
        }
        System.out.println("Good Feedback Count = " + count);
    }
}
