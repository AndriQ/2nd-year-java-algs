public class quicksort_1b {

    public static void quickSort(int[] array, int index, int length, int cutoff) {
        if (index < length) {
            if ((length - index + 1) <= cutoff) {
                insertionSort(array, index, length);
            } else {
                int q = partition(array, index, length);
                quickSort(array, index, q - 1, cutoff);
                quickSort(array, q + 1, length, cutoff);
            }
        }
    }

    public static void insertionSort(int[] array, int index, int length) {
        for (int j = index + 1; j <= length; j++) {
            int key = array[j];
            int i = j - 1;

            while (i >= index && array[i] > key) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
    }

    public static int partition(int[] array, int index, int length) {
        int x = array[length];
        int i = index - 1;

        for (int j = index; j < length; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, length);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
