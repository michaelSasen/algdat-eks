/* ==============================================================================
* TASK 2: INSERTION SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
============================================================================== */

void main() {

    ArrayList<Wine> wines = CSVImport.fileReader();

    Timer timer = new Timer();
    timer.start();
    insertionSort(wines);
    timer.end();

    IO.println(timer.getTime());
}

/* ==============================================================================
* BUBBLE SORT ALGORITHM
============================================================================== */

// ----OPTIMIZED BUBBLE SORT----
public static int[] insertionSort(ArrayList<Wine> wines) {
    // implementing a swapped boolean
    int iteration = 0;
    int swaps = 0;
        // insertion sort assumes first index is sorted, hence the int = 1
        for (int i = 1; i < wines.size(); i++) {
            iteration++;
            int j = i - 1;
            Wine curr = wines.get(i);
            double currAlc = curr.alcohol();

            while (j >= 0 && wines.get(j).alcohol() > currAlc) {
                wines.set(j + 1, wines.get(j));
                swaps++;
                j--;
            }
            wines.set(j + 1, curr);
        }
    return new int[]{iteration, swaps};
} // End insertion sort


