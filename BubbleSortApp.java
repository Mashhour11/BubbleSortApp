import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BubbleSortApp {

    // 1. Create an array of random integers between 0 and 100
    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random rand = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = rand.nextInt(101); // random int from 0 to 100
        }
        return array;
    }

    // 2. Write array to file
    public static void writeArrayToFile(int[] array, String filename) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (int num : array) {
                    writer.write(Integer.toString(num));
                    writer.newLine();
                }
            }
            System.out.println("Array written to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // 3. Read array from file
    public static int[] readFileToArray(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            int count = 0;

            // First pass: count lines
            while (reader.readLine() != null) {
                count++;
            }
            reader.close();

            // Second pass: read values
            int[] array = new int[count];
            reader = new BufferedReader(new FileReader(filename));
            int index = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                array[index++] = Integer.parseInt(line);
            }
            reader.close();

            return array;

        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return new int[0]; // return empty array on error
        }
    }

    // 4. Bubble sort (in-place)
    public static void bubbleSort(int[] array) {
        boolean swapped;
        int n = array.length;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (array[i] > array[i + 1]) {
                    // swap
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            n--; // Each pass places the largest element at the end
        } while (swapped);
    }

    // 5. Main method (interactive menu)
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an option:");
            System.out.println("1 - Generate random array and save to file");
            System.out.println("2 - Read array from file, sort, and save to new file");
            System.out.print("Your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1 ->                 {
                    System.out.print("Enter the length of the array: ");
                    int length = scanner.nextInt();
                    int[] array = createRandomArray(length);
                    System.out.print("Enter filename to save the array: ");
                    scanner.nextLine(); // clear newline
                    String filename = scanner.nextLine();
                    writeArrayToFile(array, filename);
                    System.out.println("Array saved to " + filename);
                }
                case 2 ->                 {
                    System.out.print("Enter the filename to read from: ");
                    scanner.nextLine(); // clear newline
                    String inputFile = scanner.nextLine();
                    int[] array = readFileToArray(inputFile);
                    if (array.length == 0) {
                        System.out.println("Could not read array from file.");
                    } else {
                        bubbleSort(array);
                        System.out.print("Enter filename to save the sorted array: ");
                        String outputFile = scanner.nextLine();
                        writeArrayToFile(array, outputFile);
                        System.out.println("Sorted array saved to " + outputFile);
                    }                      }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}