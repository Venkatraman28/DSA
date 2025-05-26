import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // divide and merge
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        // Time complexity - O(n * log n)
        // Space complexity - O(n)

        mergeSort(0, arr.length - 1, arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    private static void mergeSort(int low, int high, int[] arr) {
        if (low == high)
            return;

        int mid = (low + high) / 2;
        mergeSort(low, mid, arr);
        mergeSort(mid+1, high, arr);
        merge(low, mid, high, arr);
    }

    private static void merge(int low, int mid, int high, int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; ++i) {
            arr[i] = temp.get(i - low);
        }
    }
}