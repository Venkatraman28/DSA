import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {5, 2, 1};
        List<Integer> result = calculateSubsetSum(arr, n);
        Collections.sort(result);
        for (Integer integer : result) System.out.print(integer + " ");
    }

    private static List<Integer> calculateSubsetSum(int[] arr, int n) {
        if (n == 0)
            return null;
        List<Integer> subset = new ArrayList<>();
        subsetSumHelper(0, 0, n, arr, subset);
        return subset;
    }

    private static void subsetSumHelper(int index, int sum, int n, int[] arr, List<Integer> result) {
        if (index == n) {
            result.add(sum);
            return;
        }

        // Pick arr current number
        subsetSumHelper(index + 1, sum + arr[index], n, arr, result);

        // Only pick sum
        subsetSumHelper(index + 1, sum, n, arr, result);
    }
}