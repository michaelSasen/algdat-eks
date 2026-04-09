/* ==============================================================================
* TASK 4: QUICK SORT ALGORITHM PIVOT RANDOM
* code inspiration source: Geeksforgeeks
* fetched: 25/03-26
============================================================================== */
static int comparisons = 0;

void main() {
// full dataset
    ArrayList<Wine> wines = CSVImport.fileReader();
    // hashset with only unique alcohol values
    HashSet<Double> uniqueAlcohol = CSVImport.uniqueAlcoholValues(wines);

    Timer timer = new Timer();
    timer.start();
    quickSort(wines, 0, wines.size() - 1);
    timer.end();

    IO.println("Full dataset: ");
    IO.println("Time: " + timer.getTime());
    IO.println("Comparisons: " + comparisons);

}

/* ==============================================================================
* QUICK SORT ALGORITHM PIVOT RANDOM
============================================================================== */
public static void quickSort(ArrayList<Wine> wines, int low, int high) {

    if (low < high) {
        int pivot = partition(wines, low, high);

        // Recursion for smaller elements and greater or equal
        quickSort(wines, low, pivot - 1);
        quickSort(wines, pivot + 1, high);
    }
}

public static int partition(ArrayList<Wine> wines, int low, int high) {
    Random Randomizer = new Random();
    // Create random value using high and low as boundaries
    int rand = Randomizer.nextInt(high - low + 1) + low;
    // Random in current as the pivot
    Collections.swap(wines, rand, high);
    double pivot = wines.get(high).alcohol();

    int left = low - 1;
    for (int right = low; right < high; right++) {
        comparisons++;
        if (wines.get(right).alcohol() < pivot) {
            left++;
            Collections.swap(wines, left, right);
        }
    }

    Collections.swap(wines, left + 1, high);
    return left + 1;
}
