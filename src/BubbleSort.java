import java.util.*;

/* ==============================================================================
* BUBBLE SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
============================================================================== */


public class BubbleSort {

    // NON OPTIMIZED BUBBLE SORT
    public static void bubbleSortNonOptimized(List<Double> list) {
        // assign list length to variable
        int n = list.size();
        // traverse list
        for (int i = 0; i < n - 1; i++) {
            // nested loop to compare the value of the next index
            for (int j = 0; j < n - 1; j++) {
                //
                if (list.get(j) > list.get(j + 1)) {
                    double temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // OPTIMIZED BUBBLE SORT
    public static void bubbleSortOptimized(List<Double> list) {
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    double temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}

