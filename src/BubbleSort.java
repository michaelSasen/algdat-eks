import java.util.*;

/* ==============================================================================
* TASK 1: BUBBLE SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
============================================================================== */

void main(){

    ArrayList<Wine> wines  = CSVImport.fileReader();

    Timer timer = new Timer();
    timer.start();
    BubbleSort.bubbleSortNonOptimized(wines);
    timer.end();

    System.out.println(timer.getTime());
}

/* ==============================================================================
* BUBBLE SORT ALGORITHM
============================================================================== */

public static class BubbleSort {

    // ----NON OPTIMIZED BUBBLE SORT----
    public static void bubbleSortNonOptimized(ArrayList<Wine> wines) {
        // traverse list
        for (int i = 0; i < wines.size() - 1; i++) {
            // nested loop to compare the value of the next index
            for (int j = 0; j < wines.size() - 1; j++) {
                // proceeds if current value is larger than next value
                if (wines.get(j).alcohol() > wines.get(j + 1).alcohol()) {
                    // sets current to variable temp
                    Wine temp = wines.get(j);
                    // sets current to next
                    wines.set(j, wines.get(j + 1));
                    // sets next to temp variable with original value
                    wines.set(j + 1, temp);
                }
            }
        }
    } // End non-optimized sort

    // ----OPTIMIZED BUBBLE SORT----
    public static void bubbleSortOptimized(ArrayList<Wine> wines) {
        // implementing a swapped boolean
        boolean swapped;

        for (int i = 0; i < wines.size() - 1; i++) {
            swapped = false;
            // nested loop to compare the value of the next index
            for (int j = 0; j < wines.size() - 1 - i; j++) {
                // proceeds if current value is larger than next value
                if (wines.get(j).alcohol() > wines.get(j + 1).alcohol()) {
                    // sets current to variable temp
                    Wine temp = wines.get(j);
                    // sets current to next
                    wines.set(j, wines.get(j + 1));
                    // sets next to temp variable with original value
                    wines.set(j + 1, temp);
                    swapped = true;
                }
            }

            // Exit early if no swaps
            if (!swapped) {
                break;
            }
        }
    } // End optimized sort
}

