import java.util.ArrayList;
import java.util.Collections;

/* ==============================================================================
* TASK 1: BUBBLE SORT NON OPTIMIZED ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
* Time Complexity: O(n²) - comparisons = (n-1)² regardless of input order
============================================================================== */

public class BubbleSortNonOptimized {
    static int comparisons = 0;

/* ==============================================================================
* BUBBLE SORT ALGORITHM NON OPTIMIZED
============================================================================== */

    public static void bubbleSortNonOptimized(ArrayList<Wine> wines) {
        for (int i = 0; i < wines.size() - 1; i++) {  // (n-1) comparisons per pass
            for (int j = 0; j < wines.size() - 1; j++) {  // (n-1) comparisons per pass
                comparisons++;
                // Compare adjacent elements and swap if out of order
                if (wines.get(j).alcohol() > wines.get(j + 1).alcohol()) {
                    Collections.swap(wines, j, j + 1);
                }
            }
        }
    }

/* ==============================================================================
* BUBBLE SORT ALGORITHM NON OPTIMIZED UNIQUE ALCOHOL VALUES
============================================================================== */

    public static void bubbleSortNonOptimizedUnique(ArrayList<Double> alcohol) {
        for (int i = 0; i < alcohol.size() - 1; i++) {  // (n-1) comparisons per pass
            for (int j = 0; j < alcohol.size() - 1; j++) {  // (n-1) comparisons per pass
                comparisons++;
                // Compare adjacent elements and swap if out of order
                if (alcohol.get(j) > alcohol.get(j + 1)) {
                    Collections.swap(alcohol, j, j + 1);
                }
            }
        }
    }
}
