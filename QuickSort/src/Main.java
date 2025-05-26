import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Pick a pivot - any element
        // Pick 1st element of a array as pivot
        // Place the pivot in the correct place
        // Place smaller on the left and larger on the right

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(0, arr.length - 1, arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    private static void quickSort(int low, int high, int[] arr) {
        if (low < high) {
            int partitionIndex = partition(low, high, arr);
            quickSort(low, partitionIndex - 1, arr);
            quickSort(partitionIndex + 1, high, arr);
        }
    }

    private static int partition(int low, int high, int[] arr) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1)
                i++;

            while (arr[j] > pivot && j >= low + 1)
                j--;

            if (i < j)
                swap(i, j, arr);
        }

        // Swap pivot with high
        swap(low, j, arr);
        return j;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}