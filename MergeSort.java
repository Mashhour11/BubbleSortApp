public class MergeSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array.length < 2) return;

        int mid = array.length / 2;
        T[] left = java.util.Arrays.copyOfRange(array, 0, mid);
        T[] right = java.util.Arrays.copyOfRange(array, mid, array.length);

        sort(left);
        sort(right);

        merge(array, left, right);
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }
}