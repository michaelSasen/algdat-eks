/* ==============================================================================
* TASK 1: BUBBLE SORT OPTIMIZED ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
============================================================================== */

void main(){


}

/* ==============================================================================
* BUBBLE SORT ALGORITHM
============================================================================== */

    // ----NON OPTIMIZED BUBBLE SORT----
    public static int[] bubbleSortNonOptimized(ArrayList<Wine> wines) {
        // implementing a swapped boolean
        int iteration = 0;
        int swaps = 0;

        for (int i = 0; i < wines.size() - 1; i++) {
            iteration++;
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
                    swaps++;
                }
            }
        }
        return new int[]{iteration, swaps};
    } // End non optimized sort

// ----NON OPTIMIZED BUBBLE SORT UNIQUE ALCOHOL VALUES----
public static int[] bubbleSortNonOptimizedUnique(HashSet<Double> uniqueAlcohol) {
    // converting hashset to arraylist
    ArrayList<Double> alcohol = new ArrayList<>(uniqueAlcohol);

    // implementing a swapped boolean
    int iteration = 0;
    int swaps = 0;

    for (int i = 0; i < alcohol.size() - 1; i++) {
        iteration++;
        // nested loop to compare the value of the next index
        for (int j = 0; j < alcohol.size() - 1; j++) {
            // proceeds if current value is larger than next value
            if (alcohol.get(j) > alcohol.get(j + 1)) {
                // sets current to variable temp
                Double temp = alcohol.get(j);
                // sets current to next
                alcohol.set(j, alcohol.get(j + 1));
                // sets next to temp variable with original value
                alcohol.set(j + 1, temp);
                swaps++;
            }
        }
    }
    return new int[]{iteration, swaps};
} // End non optimized sort unique



