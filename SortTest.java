import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Integer[] nums = {5, 2, 9, 1, 5, 6};
        String[] words = {"banana", "apple", "cherry"};

        System.out.println("Original Integers: " + Arrays.toString(nums));
        BubbleSort.sort(nums);
        System.out.println("Bubble Sorted: " + Arrays.toString(nums));

        System.out.println("\nOriginal Strings: " + Arrays.toString(words));
        MergeSort.sort(words);
        System.out.println("Merge Sorted: " + Arrays.toString(words));
    }
}
