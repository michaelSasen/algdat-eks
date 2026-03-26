/* ==============================================================================
* TASK 3: MERGE SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 26/03-26
============================================================================== */

void main() {

    ArrayList<Wine> wines = CSVImport.fileReader();
    HashSet<Double> uniqueAlcohol = CSVImport.uniqueAlcoholValues(wines);

    int[] result = mergeSort(wines);
    //int[] uniqueResults = mergeSortUniqueAlcohol(uniqueAlcohol);

    Timer timer = new Timer();
    timer.start();
    mergeSort(wines);
    timer.end();

    println("Full dataset: ");
    println("Time: " + timer.getTime());
    println("Iterations: " + result[0]);
    println("Swaps: " + result[1]);

    timer.start();
    //mergeSortUniqueAlcohol(uniqueAlcohol);
    timer.end();

    println("");

    println("Unique alcohol values: ");
    println("Time: " + timer.getTime());
    //println("Iterations: " + uniqueResults[0]);
    //println("Swaps: " + uniqueResults[1]);
}

/* ==============================================================================
* MERGE SORT ALGORITHM
============================================================================== */


// ---- MERGE SORT FULL DATASET ----
public static int[] mergeSort(ArrayList<Wine> wines) {
    int[] stats = new int[2];
    mergeSortRecursive(wines, stats);
    return stats;
}

private static void mergeSortRecursive(ArrayList<Wine> wines, int[] stats) {
    // stops if last element
    if (wines.size() <= 1) {
        return;
    }

    // split in half
    int middleIndex = wines.size() / 2;
    ArrayList<Wine> leftHalf = new ArrayList<>();
    ArrayList<Wine> rightHalf = new ArrayList<>();

    for (int i = 0; i < middleIndex; i++) {
        leftHalf.add(wines.get(i));
    }

    for (int i = middleIndex; i < wines.size(); i++) {
        rightHalf.add(wines.get(i));
    }

    // recursive sorting
    mergeSortRecursive(leftHalf, stats);
    mergeSortRecursive(rightHalf, stats);

    //merge back to original
    mergeSortedWineLists(wines, leftHalf, rightHalf, stats);
}

private static void mergeSortedWineLists(ArrayList<Wine> wines, ArrayList<Wine> leftHalf, ArrayList<Wine> rightHalf, int[] stats) {
    int leftIndex = 0;
    int rightIndex = 0;
    int currentIndex = 0;

    while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
        stats[0]++; // comparison / iteration

        if (leftHalf.get(leftIndex).alcohol() <= rightHalf.get(rightIndex).alcohol()) {
            wines.set(currentIndex, leftHalf.get(leftIndex));
            leftIndex++;
        } else {
            wines.set(currentIndex, rightHalf.get(rightIndex));
            rightIndex++;
        }

        currentIndex++;
        stats[1]++; // move
    }

    while (leftIndex < leftHalf.size()) {
        wines.set(currentIndex, leftHalf.get(leftIndex));
        leftIndex++;
        currentIndex++;
        stats[1]++;
    }

    while (rightIndex < rightHalf.size()) {
        wines.set(currentIndex, rightHalf.get(rightIndex));
        rightIndex++;
        currentIndex++;
        stats[1]++;
    }
}



