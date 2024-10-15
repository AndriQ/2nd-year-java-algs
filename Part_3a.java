import java.util.Arrays;

public class Part_3a {
    public static int[] iLargestElements(int[] array, int i) {
        // Sort the array in descending order with merge-sort
        mergeSort(array, 0, array.length - 1);

        // Take the first i elements
        return Arrays.copyOfRange(array, 0, i);
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            // Recursive calls to divide the array up
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);

            // Merge the sorted halves
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to left and right arrays which are temporary
        System.arraycopy(array, low, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        // Merge the two halves into sorted order
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (leftArray[i] >= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy any remaining elements of leftArray
        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        // Copy any remaining elements of rightArray
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        // I used the example from the question but it also works with other numbers
        int[] array = {1, 5, 8, 2, 4, 2};
        int i = 3;
        int[] endResult = iLargestElements(array, i);
        System.out.println("The top " + i + " largest elements are: " + Arrays.toString(endResult));
    }    
}
