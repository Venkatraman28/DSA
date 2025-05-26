import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};

        // [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]
        for (ArrayList<Integer> r : calculateUniqueSubset(arr)) {
            System.out.println(r);
        }
    }

    private static ArrayList<ArrayList<Integer>> calculateUniqueSubset(int[] arr) {
        if (arr.length == 0)
            return null;

        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        uniqueSubsetHelper(0, arr, new ArrayList<>(), result);
        return result;
    }

    private static void uniqueSubsetHelper(int index, int[] arr, ArrayList<Integer> sets, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(sets));
        for (int i = index; i < arr.length; ++i) {
            // remove duplicates
            if (i != index && arr[i] == arr[i-1])
                continue;
            sets.add(arr[i]);
            uniqueSubsetHelper(i+1, arr, sets, result);
            sets.remove(sets.size() - 1);
        }
    }
}