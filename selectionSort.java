import java.util.Arrays;

public class selectionSort {
    public static void sort(int a[]) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
           
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            
            int min = a[index];
            a[index] = a[i];
            a[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] array = {14, 2, 9, 8, 11, 15, 16, 2, 5};
    

        System.out.println("Original array is: " + Arrays.toString(array));
        sort(array);
        System.out.println("Sorted array is now: " + Arrays.toString(array));
    }
}
