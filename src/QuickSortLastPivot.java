import java.util.ArrayList;
import java.util.Collections;

/* ==============================================================================
* TASK 4: QUICK SORT ALGORITHM PIVOT LAST
* code inspiration source: Geeksforgeeks
* fetched: 25/03-26
* Time Complexity: O(n log n) average | O(n²) worst case - depends on pivot placement
============================================================================== */

public class QuickSortLastPivot {
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

/*

static int comparisons = 0;

void main() {
    // Load all wine records from CSV
    ArrayList<Wine> wines = CSVImport.fileReader();
    // Extract unique alcohol values from dataset
    HashSet<Double> uniqueAlcohol = CSVImport.uniqueAlcoholValues(wines);
    // Casting the hashset to an arraylist
    ArrayList<Double> alcohol = new ArrayList<>(uniqueAlcohol);

    // Best case: reverse sorted data (last element = minimum, worst case for last pivot)
    alcohol.sort(Collections.reverseOrder());
    
    Timer timer = new Timer();
    timer.start();
    quickSortUnique(alcohol, 0, alcohol.size() - 1);
    timer.end();

    IO.println("Worst case (reverse sorted data - last pivot is minimum): O(n²)");
    IO.println("Time: " + timer.getTime());
    IO.println("Comparisons: " + comparisons);

    IO.println("");
    comparisons = 0;

    // Average case: shuffled data (last element is random)
    Collections.shuffle(alcohol);
    timer.start();
    quickSortUnique(alcohol, 0, alcohol.size() - 1);
    timer.end();

    IO.println("Average case (shuffled data - last pivot is random): O(n log n)");
    IO.println("Time: " + timer.getTime());
    IO.println("Comparisons: " + comparisons);
}

 */

/* ==============================================================================
* QUICK SORT ALGORITHM PIVOT LAST
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
        // Last in current as the pivot
        double pivot = wines.get(high).alcohol();
        int left = low - 1;
        for (int right = low; right < high; right++) {
            comparisons++;  // Each comparison counted: O(n) comparisons
            if (wines.get(right).alcohol() < pivot) {
                left++;
                Collections.swap(wines, left, right);  // O(1) per swap
            }
        }
        Collections.swap(wines, left + 1, high);
        return left + 1;
    }

/* ==============================================================================
* QUICK SORT ALGORITHM PIVOT LAST UNIQUE
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
        // Last in current as the pivot
        double pivot = alcohol.get(high);
        int left = low - 1;
        for (int right = low; right < high; right++) {
            comparisons++;  // Each comparison counted: O(n) comparisons
            if (alcohol.get(right) < pivot) {
                left++;
                Collections.swap(alcohol, left, right);  // O(1) per swap
            }
        }
        Collections.swap(alcohol, left + 1, high);
        return left + 1;
    }
}