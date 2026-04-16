import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/* ==============================================================================
* TASK 4: QUICK SORT ALGORITHM PIVOT RANDOM
* code inspiration source: Geeksforgeeks
* fetched: 25/03-26
* Time Complexity: O(n log n) average | O(n²) worst case - depends on pivot placement
============================================================================== */

public class QuickSortRandomPivot {
    static Random Randomizer = new Random();
    static int comparisons = 0;

    public static void sort(ArrayList<Wine> wines) {
        comparisons = 0;
        if (wines != null && !wines.isEmpty()) {
            quickSort(wines, 0, wines.size() - 1);
        }
    }

    public static void sortUnique(ArrayList<Double> alcohol) {
        comparisons = 0;
        if (alcohol != null && !alcohol.isEmpty()) {
            quickSortUnique(alcohol, 0, alcohol.size() - 1);
        }
    }

    /* ==============================================================================
     * QUICK SORT ALGORITHM PIVOT RANDOM
     ============================================================================== */
     public static void quickSort(ArrayList<Wine> wines, int low, int high) {
         // Time Complexity: T(n) = T(k) + T(n-k-1) + O(n)
         // where k is partition result, O(n) for partition work
         if (low < high) {
             int pivot = partition(wines, low, high);
             // Recursion for smaller elements and greater or equal
             quickSort(wines, low, pivot - 1);
             quickSort(wines, pivot + 1, high);
         }
     }

    public static int partition(ArrayList<Wine> wines, int low, int high) {
        // Partition: O(n) - single pass through range
        // Create random value using high and low as boundaries
        int rand = Randomizer.nextInt(high - low + 1) + low;
        // Move random element to end, then use as pivot
        Collections.swap(wines, rand, high);
        double pivot = wines.get(high).alcohol();

        int left = low - 1;
        for (int right = low; right < high; right++) {
            comparisons++;  // Each comparison counted: O(n) comparisons
            if (wines.get(right).alcohol() < pivot) {
                left++;
                Collections.swap(wines, left, right);
            }
        }
        Collections.swap(wines, left + 1, high);
        return left + 1;
    }

    /* ==============================================================================
   * QUICK SORT ALGORITHM PIVOT RANDOM UNIQUE VALUES
   ============================================================================== */

    public static void quickSortUnique(ArrayList<Double> alcohol, int low, int high) {
        // Time Complexity: T(n) = T(k) + T(n-k-1) + O(n)
        // where k is partition result, O(n) for partition work
        if (low < high) {
            int pivot = partitionUnique(alcohol, low, high);

            // Recursion for smaller elements and greater or equal
            quickSortUnique(alcohol, low, pivot - 1);
            quickSortUnique(alcohol, pivot + 1, high);
        }
    }

    public static int partitionUnique(ArrayList<Double> alcohol, int low, int high) {
        // Partition: O(n) - single pass through range
        // Create random value using high and low as boundaries
        int rand = Randomizer.nextInt(high - low + 1) + low;
        // Move random element to end, then use as pivot
        Collections.swap(alcohol, rand, high);
        double pivot = alcohol.get(high);
        int left = low - 1;
        for (int right = low; right < high; right++) {
            comparisons++;  // Each comparison counted: O(n) comparisons
            if (alcohol.get(right) < pivot) {
                left++;
                Collections.swap(alcohol, left, right);
            }
        }
        Collections.swap(alcohol, left + 1, high);
        return left + 1;
    }
}