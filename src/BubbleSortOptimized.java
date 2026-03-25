/* ==============================================================================
* TASK 1: BUBBLE SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
============================================================================== */

void main() {

    ArrayList<Wine> wines = CSVImport.fileReader();

    Timer timer = new Timer();
    timer.start();
    bubbleSortOptimized(wines);
    timer.end();

    IO.println(timer.getTime());
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


