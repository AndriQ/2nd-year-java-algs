public class quicksort_1a {
    public static void quickSort(int[] array, int index, int length) {
        if (index < length) {
            int q = partition(array, index, length);
            quickSort(array, index, q-1);
            quickSort(array, q+1, length);

        }
    }

    public static int partition(int[] array, int index, int length) {
        int x = array[length];
        int i = index - 1;
        
        for (int j = index; j < length; j++) {
            if (array[j] <= x) {
                i += 1;
                swap(array, i, j);
            }   
        }
        swap(array, i+1, length);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}