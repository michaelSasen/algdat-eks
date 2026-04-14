import java.util.ArrayList;
import java.util.Collections;

/* ==============================================================================
* TASK 1: BUBBLE SORT OPTIMIZED ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
* Time Complexity: O(n) best case | O(n²) worst case - depends on input order
============================================================================== */
public class BubbleSortOptimized {
    static int comparisons = 0;

/*
void main() {
    // Load all wine records from CSV
    ArrayList<Wine> wines = CSVImport.fileReader();
    // Extract unique alcohol values from dataset
    HashSet<Double> uniqueAlcohol = CSVImport.uniqueAlcoholValues(wines);
    // Casting the hashset to an arraylist
    ArrayList<Double> alcohol = new ArrayList<>(uniqueAlcohol);

    Timer timer = new Timer();

    comparisons = 0;

    // Best case: Already sorted
    Collections.sort(alcohol);
    timer.start();
    bubbleSortOptimizedUnique(alcohol);
    timer.end();

    IO.println("Best case (sorted data): O(n)");
    IO.println("Time: " + timer.getTime());
    IO.println("Comparisons: " + comparisons);

    comparisons = 0;
    IO.println("");

    // Worst case: Shuffled data
    Collections.shuffle(alcohol);
    timer.start();
    bubbleSortOptimizedUnique(alcohol);
    timer.end();

    IO.println("Worst case (shuffled data): O(n²)");
    IO.println("Time: " + timer.getTime());
    IO.println("Comparisons: " + comparisons);
}

/* ==============================================================================
* BUBBLE SORT ALGORITHM OPTIMIZED
============================================================================== */

    public static void bubbleSortOptimized(ArrayList<Wine> wines) {
        for (int i = 0; i < wines.size() - 1; i++) {  // (n-1) comparisons per pass
            boolean swapped = false;
            for (int j = 0; j < wines.size() - 1 - i; j++) {  // (n-1) comparisons per pass
                comparisons++;
                // proceeds if current value is larger than next value
                if (wines.get(j).alcohol() > wines.get(j + 1).alcohol()) {
                    Collections.swap(wines, j, j + 1);
                    swapped = true;
                }
            }
            // Exit early if no swaps
            if (!swapped) {
                break;
            }
        }
    }

/* ==============================================================================
* BUBBLE SORT ALGORITHM OPTIMIZED UNIQUE
============================================================================== */

    public static void bubbleSortOptimizedUnique(ArrayList<Double> alcohol) {
        for (int i = 0; i < alcohol.size() - 1; i++) {  // (n-1) passes max
            boolean swapped = false;
            for (int j = 0; j < alcohol.size() - 1 - i; j++) {  // (n-1) comparisons per pass
                comparisons++;
                // proceeds if current value is larger than next value
                if (alcohol.get(j) > alcohol.get(j + 1)) {
                    Collections.swap(alcohol, j, j + 1);
                    swapped = true;
                }
            }
            // Exit early if no swaps
            if (!swapped) {
                break;
            }
        }
    }
}