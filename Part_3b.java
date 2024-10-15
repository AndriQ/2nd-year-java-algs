import java.util.Arrays;

public class Part_3b {
    public static int[] iLargestElements(int[] array, int i) {
        quickSelect(array, 0, array.length - 1, i);

        // Take the last i elements after quickSelect
        return Arrays.copyOfRange(array, 0, i);
    }

    private static void quickSelect(int[] array, int low, int high, int k) {
        if (low < high) {
            int pivotIndex = middlePartition(array, low, high);

            // See if the pivot is the k-th smallest element
            if (pivotIndex == k) {
                return;
            } else if (pivotIndex > k) {
                quickSelect(array, low, pivotIndex - 1, k);
            } else {
                quickSelect(array, pivotIndex + 1, high, k);
            }
        }
    }

    private static int middlePartition(int[] array, int low, int high) {
        // Choose the middle index as the pivot instead of doing a random index
        int pivotIndex = (low + high) / 2;  
        swap(array, pivotIndex, high);
    
        return partition(array, low, high);
    }
    

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] >= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        // I used the example from the question but it also works with other numbers
        int[] array = {1, 5, 8, 2, 4, 2};
        int i = 3;
        int[] result = iLargestElements(array, i);
        System.out.println("The top " + i + " largest elements are: " + Arrays.toString(result));
    }
}
