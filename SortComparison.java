import java.util.Random;
import java.util.Scanner;

public class SortComparison {

    // Generate an array of random integers
    public static int[] createRandomArray(int length) {
        int[] array = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = rand.nextInt(1000); // Random numbers 0–999
        }
        return array;
    }

    // Bubble Sort (in-place)
    public static void bubbleSort(int[] array) {
        boolean swapped;
        int n = array.length;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    // Merge Sort
    public static void mergeSort(int[] array) {
        if (array.length <= 1) return;
        int mid = array.length / 2;

        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    // Main method
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter array length: ");
            int length = scanner.nextInt();
            
            int[] originalArray = createRandomArray(length);
            int[] arrayForBubble = originalArray.clone();
            int[] arrayForMerge = originalArray.clone();
            
            // Bubble Sort timing
            long startBubble = System.currentTimeMillis();
            bubbleSort(arrayForBubble);
            long endBubble = System.currentTimeMillis();
            
            // Merge Sort timing
            long startMerge = System.currentTimeMillis();
            mergeSort(arrayForMerge);
            long endMerge = System.currentTimeMillis();
            
            System.out.println("Bubble Sort took: " + (endBubble - startBubble) + " ms");
            System.out.println("Merge Sort took: " + (endMerge - startMerge) + " ms");
        }
    }
}