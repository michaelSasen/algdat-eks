/* ==============================================================================
* TASK 2: INSERTION SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
============================================================================== */

void main() {

    // full dataset
    ArrayList<Wine> wines = CSVImport.fileReader();
    // hashset with only unique alcohol values
    HashSet<Double> uniqueAlcohol = CSVImport.uniqueAlcoholValues(wines);

    // captures values returned by the methods
    int[] result = insertionSort(wines);
    int[] uniqueResults = insertionSortUniqueAlcohol(uniqueAlcohol);

    Timer timer = new Timer();
    timer.start();
    insertionSort(wines);
    timer.end();
    
    IO.println("Full dataset: ");
    IO.println("Time: " + timer.getTime());
    IO.println("Iterations: " + result[0]);
    IO.println("Swaps: " + result[1]);

    timer.start();
    insertionSortUniqueAlcohol(uniqueAlcohol);
    timer.end();

    IO.println("");

    IO.println("Unique alcohol values: ");
    IO.println("Time: " + timer.getTime());
    IO.println("Iterations: " + uniqueResults[0]);
    IO.println("Swaps: " + uniqueResults[1]);
}

/* ==============================================================================
* INSERTION SORT ALGORITHM
============================================================================== */

// ----INSERTION SORT FULL DATASET----
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

// ----INSERTION SORT UNIQUE VALUES----
public static int[] insertionSortUniqueAlcohol (HashSet<Double> uniqueAlcohol) {
    // converting hashset to arraylist
    ArrayList<Double> alcohol = new ArrayList<>(uniqueAlcohol);
    int iteration = 0;
    int swaps = 0;
    for (int i = 1; i < alcohol.size(); i++) {
        iteration++;
        int j = i - 1;
        Double curr = alcohol.get(i);
        while (j >= 0 && alcohol.get(j) > curr) {
            alcohol.set(j + 1, alcohol.get(j));
            swaps++;
            j--;
        }
        alcohol.set(j + 1, curr);
    }
    return new int[]{iteration, swaps};
} // End insertion sort unique alcohol values



