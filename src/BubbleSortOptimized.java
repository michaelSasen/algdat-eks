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