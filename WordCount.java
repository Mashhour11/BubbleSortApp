import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        // File paths
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Create a map to store word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;

            // Read each line of the input file
            while ((line = br.readLine()) != null) {
                // Convert the word to lowercase to ensure case insensitivity
                line = line.toLowerCase().trim();

                // If the word is not empty, update the count
                if (!line.isEmpty()) {
                    wordCounts.put(line, wordCounts.getOrDefault(line, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the word counts to the output file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Word count has been written to output.txt.");
    }
}