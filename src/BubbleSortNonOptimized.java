/* ==============================================================================
* TASK 1: BUBBLE SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
============================================================================== */

void main(){

    ArrayList<Wine> wines  = CSVImport.fileReader();

    Timer timer = new Timer();
    timer.start();
    bubbleSortNonOptimized(wines);
    timer.end();

    System.out.println(timer.getTime());
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
    } // End optimized sort




