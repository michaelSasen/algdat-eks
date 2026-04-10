/* ==============================================================================
* TASK 4: QUICK SORT ALGORITHM PIVOT FIRST
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
* QUICK SORT ALGORITHM PIVOT FIRST
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
    // First in current as the pivot
    double pivot = wines.get(low).alcohol();

    int left = low;
    for (int right = low + 1; right <= high; right++) {
        comparisons++;
        if (wines.get(right).alcohol() < pivot) {
            left++;
            Collections.swap(wines, left, right);
        }
    }

    Collections.swap(wines, low, left);

    return left;
}
