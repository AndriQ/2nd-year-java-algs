public class quicksort_1c {

    public static void quickSort(int[] array, int index, int length) {
        if (index < length) {
            int[] partitions = partition(array, index, length);
            int lessThan = partitions[0];
            int greaterThan = partitions[1];

            quickSort(array, index, lessThan - 1);
            quickSort(array, greaterThan + 1, length);
        }
    }

    public static int[] partition(int[] array, int index, int length) {
        int pivot = array[index];

        int lessThan = index;
        int greaterThan = length;
        int equalToPivot = index + 1;

        while (equalToPivot <= greaterThan) {
            if (array[equalToPivot] < pivot) {
                swap(array, lessThan, equalToPivot);
                lessThan++;
                equalToPivot++;
            } else if (array[equalToPivot] > pivot) {
                swap(array, equalToPivot, greaterThan);
                greaterThan--;
            } else {
                equalToPivot++;
            }
        }

        return new int[]{lessThan, greaterThan};
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
