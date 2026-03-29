/* ==============================================================================
* TASK 1: BUBBLE SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
============================================================================== */

void main() {



}

/* ==============================================================================
* BUBBLE SORT ALGORITHM
============================================================================== */

    // ----OPTIMIZED BUBBLE SORT----
    public static int[] bubbleSortOptimized(ArrayList<Wine> wines) {
        // implementing a swapped boolean
        int iteration = 0;
        int swaps = 0;

        for (int i = 0; i < wines.size() - 1; i++) {
            iteration++;
            boolean swapped = false;
            // nested loop to compare the value of the next index
            // -i to skip the sorted elements
            for (int j = 0; j < wines.size() - 1 - i; j++) {
                // proceeds if current value is larger than next value
                if (wines.get(j).alcohol() > wines.get(j + 1).alcohol()) {
                    // sets current to variable temp
                    Wine temp = wines.get(j);
                    // sets current to next
                    wines.set(j, wines.get(j + 1));
                    // sets next to temp variable with original value
                    wines.set(j + 1, temp);
                    swaps++;
                    swapped = true;
                }
            }
            // Exit early if no swaps
            if (!swapped) {
                break;
            }
        }
        return new int[]{iteration, swaps};
    } // End optimized sort

// ----OPTIMIZED BUBBLE SORT UNIQUE ALCOHOL VALUES----
public static int[] bubbleSortOptimizedUnique(HashSet<Double> uniqueAlcohol) {
    // converting hashset to arraylist
    ArrayList<Double> alcohol = new ArrayList<>(uniqueAlcohol);

    // implementing a swapped boolean
    int iteration = 0;
    int swaps = 0;

    for (int i = 0; i < alcohol.size() - 1; i++) {
        iteration++;
        boolean swapped = false;
        // nested loop to compare the value of the next index
        // -i to skip the sorted elements
        for (int j = 0; j < alcohol.size() - 1 - i; j++) {
            // proceeds if current value is larger than next value
            if (alcohol.get(j) > alcohol.get(j + 1)) {
                // sets current to variable temp
                Double temp = alcohol.get(j);
                // sets current to next
                alcohol.set(j, alcohol.get(j + 1));
                // sets next to temp variable with original value
                alcohol.set(j + 1, temp);
                swaps++;
                swapped = true;
            }
        }
        // Exit early if no swaps
        if (!swapped) {
            break;
        }
    }
    return new int[]{iteration, swaps};
} // End optimized sort unique


