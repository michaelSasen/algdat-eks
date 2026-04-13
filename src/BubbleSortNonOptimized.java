/* ==============================================================================
* TASK 1: BUBBLE SORT NON OPTIMIZED ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 25/03-26
* Time Complexity: O(n²) - comparisons = (n-1)² regardless of input order
============================================================================== */

static int comparisons = 0;

void main(){
    // Load all wine records from CSV
    ArrayList<Wine> wines = CSVImport.fileReader();
    // Extract unique alcohol values from dataset
    HashSet<Double> uniqueAlcohol = CSVImport.uniqueAlcoholValues(wines);
    // Casting the hashset to an arraylist
    ArrayList<Double> alcohol = new ArrayList<>(uniqueAlcohol);

    // Shuffle list to prove that comparisons do not change with input order
    Collections.shuffle(wines);
    Timer timer = new Timer();
    timer.start();
    bubbleSortNonOptimized(wines);
    timer.end();

    IO.println("Full dataset: ");
    IO.println("Time: " + timer.getTime());
    IO.println("Comparisons: " + comparisons);

    // Reset comparisons counter
    comparisons = 0;

    // Shuffle again, now with the unique values
    Collections.shuffle(alcohol);
    timer.start();
    bubbleSortNonOptimizedUnique(alcohol);
    timer.end();

    IO.println("");

    IO.println("Unique alcohol values: ");
    IO.println("Time: " + timer.getTime());
    IO.println("Comparisons: " + comparisons);
}

/* ==============================================================================
* BUBBLE SORT ALGORITHM NON OPTIMIZED
============================================================================== */

    public static void bubbleSortNonOptimized(ArrayList<Wine> wines) {
        for (int i = 0; i < wines.size() - 1; i++) {  // (n-1) passes
            for (int j = 0; j < wines.size() - 1; j++) {  // (n-1) comparisons per pass
                comparisons++;
                // Compare adjacent elements and swap if out of order
                if (wines.get(j).alcohol() > wines.get(j + 1).alcohol()) {
                    Collections.swap(wines, j, j +1);
                }
            }
        }
    }

/* ==============================================================================
* BUBBLE SORT ALGORITHM NON OPTIMIZED UNIQUE ALCOHOL VALUES
============================================================================== */

public static void bubbleSortNonOptimizedUnique(ArrayList<Double> alcohol) {
    for (int i = 0; i < alcohol.size() - 1; i++) {  // (n-1) passes
        for (int j = 0; j < alcohol.size() - 1; j++) {  // (n-1) comparisons per pass
            comparisons++;
            // Compare adjacent elements and swap if out of order
            if (alcohol.get(j) > alcohol.get(j + 1)) {
                Collections.swap(alcohol, j, j +1);
            }
        }
    }
}



