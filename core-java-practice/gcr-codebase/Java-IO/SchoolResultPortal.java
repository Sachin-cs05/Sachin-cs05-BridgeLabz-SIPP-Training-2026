import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "students.txt";
        String outputFile = "report_card.txt";
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(outputFile, true));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\s+");
                if (parts.length < 2) {
                    continue;
                }
                String name = parts[0];
                double sum = 0;
                int marksCount = 0;
                for (int i = 1; i < parts.length; i++) {
                    try {
                        sum += Double.parseDouble(parts[i]);
                        marksCount++;
                    } catch (NumberFormatException e) {
                    }
                }
                if (marksCount == 0) {
                    continue;
                }
                double average = sum / marksCount;
                writer.write("Report Card for " + name + " : Average = " + average);
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        } catch (IOException e) {
            System.out.println("IO error");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
