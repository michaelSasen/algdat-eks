import java.util.ArrayList;
import java.util.HashSet;

public class RunBenchmark {

    // Original dataset of wines loaded once and reused
    private static ArrayList<Wine> ORIGINAL_WINES;

    // Set of unique alcohol values extracted from the dataset
    private static HashSet<Double> ORIGINAL_UNIQUE_ALCOHOL;

    // Static initialization: load data from file at class startup
    static {
        ORIGINAL_WINES = CSVImport.fileReader();
        ORIGINAL_UNIQUE_ALCOHOL = CSVImport.uniqueAlcoholValues(ORIGINAL_WINES);
    }

    // Formats and prints benchmark results (time + comparisons)
    private static void printResult(TestResult result) {
        double timeInSeconds = result.totalTimeNano() / 1_000_000_000.0;
        System.out.printf("%-50s | %10.4f sec | %s: %d%n",
                result.algorithmName(),
                timeInSeconds,
                result.metricLabel(),
                result.comparisons());
    }

/* ==============================================================================
* FULL DATASET TESTS
============================================================================== */

    // Runs both versions of Bubble Sort on full dataset
    public static void runBubbleSortFull() {
        TestResult r1 = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, false, 100, "BubbleSort-NonOptimized-Full", BubbleSortNonOptimized::bubbleSortNonOptimized);
        printResult(r1);

        TestResult r2 = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, false, 100, "BubbleSort-Optimized-Full", BubbleSortOptimized::bubbleSortOptimized);
        printResult(r2);
    }

    // Runs Insertion Sort on full dataset
    public static void runInsertionSortFull() {
        TestResult r = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, false, 100, "InsertionSort-Full", InsertionSort::insertionSort);
        printResult(r);
    }

    // Runs Quick Sort (first element as pivot)
    public static void runQuickSortFirstPivotFull() {
        TestResult r = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, false, 100, "QuickSort-FirstPivot-Full", QuickSortFirstPivot::sort);
        printResult(r);
    }

    // Runs Quick Sort (last element as pivot)
    public static void runQuickSortLastPivotFull() {
        TestResult r = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, false, 100, "QuickSort-LastPivot-Full", QuickSortLastPivot::sort);
        printResult(r);
    }

    // Runs Quick Sort (median pivot strategy)
    public static void runQuickSortMedianPivotFull() {
        TestResult r = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, false, 100, "QuickSort-MedianPivot-Full", QuickSortMedianPivot::sort);
        printResult(r);
    }

    // Runs Quick Sort (random pivot strategy)
    public static void runQuickSortRandomPivotFull() {
        TestResult r = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, false, 100, "QuickSort-RandomPivot-Full", QuickSortRandomPivot::sort);
        printResult(r);
    }

    // Runs Merge Sort on full dataset (sorted)
    public static void runMergeSortFull() {
        TestResult r = BenchmarkAlgorithms.testMergeSort(ORIGINAL_WINES, false, 100);
        printResult(r);
    }

    // Runs all sorting algorithms on full dataset
    public static void runAllFullDatasetTests() {
        IO.println("===== Full Dataset Sorting (100 runs with JVM warm-up) =====\n");
        runBubbleSortFull();
        runInsertionSortFull();
        runQuickSortFirstPivotFull();
        runQuickSortLastPivotFull();
        runQuickSortMedianPivotFull();
        runQuickSortRandomPivotFull();
        runMergeSortFull();
        IO.println("");
    }

/* ==============================================================================
* UNIQUE DATASET TESTS
============================================================================== */

    // Runs Bubble Sort on unique alcohol values
    public static void runBubbleSortUnique() {
        TestResult r1 = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), false, 100, "BubbleSort-NonOptimized-Unique", BubbleSortNonOptimized::bubbleSortNonOptimizedUnique);
        printResult(r1);

        TestResult r2 = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), false, 100, "BubbleSort-Optimized-Unique", BubbleSortOptimized::bubbleSortOptimizedUnique);
        printResult(r2);
    }

    // Runs Insertion Sort on unique alcohol values
    public static void runInsertionSortUnique() {
        TestResult r = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), false, 100, "InsertionSort-Unique", InsertionSort::insertionSortUniqueAlcohol);
        printResult(r);
    }

    // Runs Quick Sort (first pivot) on unique values
    public static void runQuickSortFirstPivotUnique() {
        TestResult r = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), false, 100, "QuickSort-FirstPivot-Unique", QuickSortFirstPivot::sortUnique);
        printResult(r);
    }

    // Runs Quick Sort (last pivot) on unique values
    public static void runQuickSortLastPivotUnique() {
        TestResult r = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), false, 100, "QuickSort-LastPivot-Unique", QuickSortLastPivot::sortUnique);
        printResult(r);
    }

    // Runs Quick Sort (median pivot) on unique values
    public static void runQuickSortMedianPivotUnique() {
        TestResult r = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), false, 100, "QuickSort-MedianPivot-Unique", QuickSortMedianPivot::sortUnique);
        printResult(r);
    }

    // Runs Quick Sort (random pivot) on unique values
    public static void runQuickSortRandomPivotUnique() {
        TestResult r = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), false, 100, "QuickSort-RandomPivot-Unique", QuickSortRandomPivot::sortUnique);
        printResult(r);
    }

    // Runs Merge Sort on unique values (sorted)
    public static void runMergeSortUnique() {
        TestResult r = BenchmarkAlgorithms.testMergeSortUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), false, 100);
        printResult(r);
    }

    // Runs all sorting algorithms on unique dataset
    public static void runAllUniqueDatasetTests() {
        IO.println("===== Unique Alcohol Values Sorting (100 runs with JVM warm-up) =====\n");
        runBubbleSortUnique();
        runInsertionSortUnique();
        runQuickSortFirstPivotUnique();
        runQuickSortLastPivotUnique();
        runQuickSortMedianPivotUnique();
        runQuickSortRandomPivotUnique();
        runMergeSortUnique();
        IO.println("");
    }

/* ==============================================================================
* FULL DATASET TESTS SHUFFLED
============================================================================== */

    // Runs both versions of Bubble Sort on full dataset
    public static void runBubbleSortFullShuffled() {
        TestResult r1 = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, true, 100, "BubbleSort-NonOptimized-Full", BubbleSortNonOptimized::bubbleSortNonOptimized);
        printResult(r1);

        TestResult r2 = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, true, 100, "BubbleSort-Optimized-Full", BubbleSortOptimized::bubbleSortOptimized);
        printResult(r2);
    }

    // Runs Insertion Sort on full dataset
    public static void runInsertionSortFullShuffled() {
        TestResult r = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, true, 100, "InsertionSort-Full", InsertionSort::insertionSort);
        printResult(r);
    }

    // Runs Quick Sort (first element as pivot)
    public static void runQuickSortFirstPivotFullShuffled() {
        TestResult r = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-FirstPivot-Full", QuickSortFirstPivot::sort);
        printResult(r);
    }

    // Runs Quick Sort (last element as pivot)
    public static void runQuickSortLastPivotFullShuffled() {
        TestResult r = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-LastPivot-Full", QuickSortLastPivot::sort);
        printResult(r);
    }

    // Runs Quick Sort (median pivot strategy)
    public static void runQuickSortMedianPivotFullShuffled() {
        TestResult r = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-MedianPivot-Full", QuickSortMedianPivot::sort);
        printResult(r);
    }

    // Runs Quick Sort (random pivot strategy)
    public static void runQuickSortRandomPivotFullShuffled() {
        TestResult r = BenchmarkAlgorithms.testAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-RandomPivot-Full", QuickSortRandomPivot::sort);
        printResult(r);
    }

    // Runs Merge Sort on full dataset (shuffled)
    public static void runMergeSortFullShuffled() {
        TestResult r = BenchmarkAlgorithms.testMergeSort(ORIGINAL_WINES, true, 100);
        printResult(r);
    }

    // Runs all sorting algorithms on full dataset
    public static void runAllFullDatasetTestsShuffled() {
        IO.println("===== Full Dataset Sorting (100 runs with JVM warm-up) =====\n");
        runBubbleSortFullShuffled();
        runInsertionSortFullShuffled();
        runQuickSortFirstPivotFullShuffled();
        runQuickSortLastPivotFullShuffled();
        runQuickSortMedianPivotFullShuffled();
        runQuickSortRandomPivotFullShuffled();
        runMergeSortFullShuffled();
        IO.println("");
    }

/* ==============================================================================
* UNIQUE DATASET TESTS SHUFFLED
============================================================================== */

    // Runs Bubble Sort on unique alcohol values
    public static void runBubbleSortUniqueShuffled() {
        TestResult r1 = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "BubbleSort-NonOptimized-Unique", BubbleSortNonOptimized::bubbleSortNonOptimizedUnique);
        printResult(r1);

        TestResult r2 = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "BubbleSort-Optimized-Unique", BubbleSortOptimized::bubbleSortOptimizedUnique);
        printResult(r2);
    }

    // Runs Insertion Sort on unique alcohol values
    public static void runInsertionSortUniqueShuffled() {
        TestResult r = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "InsertionSort-Unique", InsertionSort::insertionSortUniqueAlcohol);
        printResult(r);
    }

    // Runs Quick Sort (first pivot) on unique values
    public static void runQuickSortFirstPivotUniqueShuffled() {
        TestResult r = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-FirstPivot-Unique", QuickSortFirstPivot::sortUnique);
        printResult(r);
    }

    // Runs Quick Sort (last pivot) on unique values
    public static void runQuickSortLastPivotUniqueShuffled() {
        TestResult r = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-LastPivot-Unique", QuickSortLastPivot::sortUnique);
        printResult(r);
    }

    // Runs Quick Sort (median pivot) on unique values
    public static void runQuickSortMedianPivotUniqueShuffled() {
        TestResult r = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-MedianPivot-Unique", QuickSortMedianPivot::sortUnique);
        printResult(r);
    }

    // Runs Quick Sort (random pivot) on unique values
    public static void runQuickSortRandomPivotUniqueShuffled() {
        TestResult r = BenchmarkAlgorithms.testAlgorithmUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-RandomPivot-Unique", QuickSortRandomPivot::sortUnique);
        printResult(r);
    }

    // Runs Merge Sort on unique values (shuffled)
    public static void runMergeSortUniqueShuffled() {
        TestResult r = BenchmarkAlgorithms.testMergeSortUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100);
        printResult(r);
    }

    // Runs all sorting algorithms on unique dataset
    public static void runAllUniqueDatasetTestsShuffled() {
        IO.println("===== Unique Alcohol Values Sorting (100 runs with JVM warm-up) =====\n");
        runBubbleSortUniqueShuffled();
        runInsertionSortUniqueShuffled();
        runQuickSortFirstPivotUniqueShuffled();
        runQuickSortLastPivotUniqueShuffled();
        runQuickSortMedianPivotUniqueShuffled();
        runQuickSortRandomPivotUniqueShuffled();
        runMergeSortUniqueShuffled();
        IO.println("");
    }

/* ==============================================================================
* MAIN TEST EXECUTION
============================================================================== */

    // Runs warm-up + all benchmarks for both datasets
    public static void runAllSortingAlgorithms() {

        // Warm-up phase to stabilize JVM performance (full dataset)
        IO.println("Warming up Full Dataset algorithms...");
        BenchmarkAlgorithms.runWarmUp(ORIGINAL_WINES, 10, "Bubble Sort Non-Optimized", BubbleSortNonOptimized::bubbleSortNonOptimized);
        BenchmarkAlgorithms.runWarmUp(ORIGINAL_WINES, 10, "Bubble Sort Optimized", BubbleSortOptimized::bubbleSortOptimized);
        BenchmarkAlgorithms.runWarmUp(ORIGINAL_WINES, 10, "Insertion Sort", InsertionSort::insertionSort);
        BenchmarkAlgorithms.runWarmUp(ORIGINAL_WINES, 10, "Quick Sort First Pivot", QuickSortFirstPivot::sort);
        BenchmarkAlgorithms.runWarmUp(ORIGINAL_WINES, 10, "Quick Sort Last Pivot", QuickSortLastPivot::sort);
        BenchmarkAlgorithms.runWarmUp(ORIGINAL_WINES, 10, "Quick Sort Median Pivot", QuickSortMedianPivot::sort);
        BenchmarkAlgorithms.runWarmUp(ORIGINAL_WINES, 10, "Quick Sort Random Pivot", QuickSortRandomPivot::sort);
        BenchmarkAlgorithms.runMergeWarmUp(ORIGINAL_WINES, 10, "Merge Sort");
        IO.println("Warm-up complete.\n");

        // Warm-up phase for unique dataset
        IO.println("Warming up Unique Dataset algorithms...");
        BenchmarkAlgorithms.runWarmUpDouble(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Bubble Sort Non-Optimized Unique", BubbleSortNonOptimized::bubbleSortNonOptimizedUnique);
        BenchmarkAlgorithms.runWarmUpDouble(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Bubble Sort Optimized Unique", BubbleSortOptimized::bubbleSortOptimizedUnique);
        BenchmarkAlgorithms.runWarmUpDouble(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Insertion Sort Unique", InsertionSort::insertionSortUniqueAlcohol);
        BenchmarkAlgorithms.runWarmUpDouble(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Quick Sort First Pivot Unique", QuickSortFirstPivot::sortUnique);
        BenchmarkAlgorithms.runWarmUpDouble(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Quick Sort Last Pivot Unique", QuickSortLastPivot::sortUnique);
        BenchmarkAlgorithms.runWarmUpDouble(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Quick Sort Median Pivot Unique", QuickSortMedianPivot::sortUnique);
        BenchmarkAlgorithms.runWarmUpDouble(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Quick Sort Random Pivot Unique", QuickSortRandomPivot::sortUnique);
        BenchmarkAlgorithms.runMergeUniqueWarmUp(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Merge Sort Unique");
        IO.println("Warm-up complete.\n");

        // Run actual benchmarks
        runAllFullDatasetTests();
        runAllUniqueDatasetTests();
        
        IO.println("\n=== NOW RUNNING SHUFFLED TESTS ===\n");
        
        runAllFullDatasetTestsShuffled();
        runAllUniqueDatasetTestsShuffled();
    }
}