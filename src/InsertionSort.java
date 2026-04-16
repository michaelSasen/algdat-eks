import java.util.ArrayList;

/* ==============================================================================
* TASK 2: INSERTION SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
* Time Complexity: O(n) best case | O(n²) worst case - depends on input order
============================================================================== */

public class InsertionSort {
    static int comparisons = 0;

/* ==============================================================================
* INSERTION SORT ALGORITHM
============================================================================== */

    public static void insertionSort(ArrayList<Wine> wines) {
        for (int i = 1; i < wines.size(); i++) {  // n-1 passes
            int j = i - 1;
            Wine curr = wines.get(i);
            double currAlc = curr.alcohol();

            while (j >= 0 && wines.get(j).alcohol() > currAlc) {
                comparisons++;
                wines.set(j + 1, wines.get(j));
                j--;
            }
            wines.set(j + 1, curr);
        }
    }

/* ==============================================================================
* INSERTION SORT ALGORITHM UNIQUE
============================================================================== */

    public static void insertionSortUniqueAlcohol(ArrayList<Double> alcohol) {
        for (int i = 1; i < alcohol.size(); i++) {  // n-1 passes
            int j = i - 1;
            Double curr = alcohol.get(i);
            while (j >= 0 && alcohol.get(j) > curr) {
                comparisons++;
                alcohol.set(j + 1, alcohol.get(j));
                j--;
            }
            alcohol.set(j + 1, curr);
        }
    }
}