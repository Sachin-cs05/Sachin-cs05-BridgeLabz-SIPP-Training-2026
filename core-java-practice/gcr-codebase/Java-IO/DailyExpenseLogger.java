import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class DailyExpenseLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.txt", true));
        for (int i = 0; i < 3; i++) {
            String expense = reader.readLine();
            if (expense == null) {
                break;
            }
            writer.write(expense);
            writer.newLine();
        }
        writer.close();
    }
}
