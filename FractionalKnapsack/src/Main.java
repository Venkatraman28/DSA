import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int w = 50;
        Knapsack item1 = new Knapsack(20, 100);
        Knapsack item2 = new Knapsack(10, 60);
        Knapsack item3 = new Knapsack(30, 120);
        Knapsack[] knapsacks = {item1, item2, item3};

        double result = calculateFractionalKnapsack(knapsacks, w);
        System.out.println("Total: " + result);
    }

    private static double calculateFractionalKnapsack(Knapsack[] knapsacks, int w) {
        Arrays.sort(knapsacks, new itemCalculator());
        if (w <= 0)
            return 0.0;

        double total = 0.0;
        for (int i = 0; i < knapsacks.length; ++i) {
            Knapsack k = knapsacks[i];
            if (k.weight <= w) {
                w -= k.weight;
                total += k.value;
            } else {
                total += (w * ((double) k.value / k.weight));
                w = 0;
            }
        }
        return total;
    }
}

class itemCalculator implements Comparator<Knapsack> {

    @Override
    public int compare(Knapsack o1, Knapsack o2) {
        double avg1 = (double) (o1.value) / (double) (o1.weight);
        double avg2 = (double) (o2.value) / (double) (o2.weight);

        if (avg1 < avg2)
            return 1;
        else if (avg1 > avg2)
            return -1;
        else
            return 0;
    }
}