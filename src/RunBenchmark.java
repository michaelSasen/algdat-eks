import java.util.ArrayList;
import java.util.HashSet;

public class RunBenchmark {

    private static ArrayList<Wine> ORIGINAL_WINES;
    private static HashSet<Double> ORIGINAL_UNIQUE_ALCOHOL;

    static {
        ORIGINAL_WINES = CSVImport.fileReader();
        ORIGINAL_UNIQUE_ALCOHOL = CSVImport.uniqueAlcoholValues(ORIGINAL_WINES);
    }

    private static void printResult(TestResult result) {
        double timeInSeconds = result.totalTimeNano() / 1_000_000_000.0;
        System.out.printf("%-50s | %10.4f sec | %s: %d%n", 
            result.algorithmName(), 
            timeInSeconds,
            result.metricLabel(),
            result.comparisons());
    }

    // ===== FULL DATASET TESTS =====
    
    public static void runBubbleSortFull() {
        TestResult r1 = BenchmarkAlgorithms.testWineAlgorithm(ORIGINAL_WINES, true, 100, "BubbleSort-NonOptimized-Full", BubbleSortNonOptimized::bubbleSortNonOptimized);
        printResult(r1);
        TestResult r2 = BenchmarkAlgorithms.testWineAlgorithm(ORIGINAL_WINES, true, 100, "BubbleSort-Optimized-Full", BubbleSortOptimized::bubbleSortOptimized);
        printResult(r2);
    }

    public static void runInsertionSortFull() {
        TestResult r = BenchmarkAlgorithms.testWineAlgorithm(ORIGINAL_WINES, true, 100, "InsertionSort-Full", InsertionSort::insertionSort);
        printResult(r);
    }

    public static void runQuickSortFirstPivotFull() {
        TestResult r = BenchmarkAlgorithms.testWineAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-FirstPivot-Full", QuickSortFirstPivot::sort);
        printResult(r);
    }

    public static void runQuickSortLastPivotFull() {
        TestResult r = BenchmarkAlgorithms.testWineAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-LastPivot-Full", QuickSortLastPivot::sort);
        printResult(r);
    }

    public static void runQuickSortMedianPivotFull() {
        TestResult r = BenchmarkAlgorithms.testWineAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-MedianPivot-Full", QuickSortMedianPivot::sort);
        printResult(r);
    }

    public static void runQuickSortRandomPivotFull() {
        TestResult r = BenchmarkAlgorithms.testWineAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-RandomPivot-Full", QuickSortRandomPivot::sort);
        printResult(r);
    }

    public static void runMergeSortFull() {
        TestResult r = BenchmarkAlgorithms.testMergeSort(ORIGINAL_WINES, 100);
        printResult(r);
    }

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

    // ===== UNIQUE DATASET TESTS =====

    public static void runBubbleSortUnique() {
        TestResult r1 = BenchmarkAlgorithms.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "BubbleSort-NonOptimized-Unique", BubbleSortNonOptimized::bubbleSortNonOptimizedUnique);
        printResult(r1);
        TestResult r2 = BenchmarkAlgorithms.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "BubbleSort-Optimized-Unique", BubbleSortOptimized::bubbleSortOptimizedUnique);
        printResult(r2);
    }

    public static void runInsertionSortUnique() {
        TestResult r = BenchmarkAlgorithms.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "InsertionSort-Unique", InsertionSort::insertionSortUniqueAlcohol);
        printResult(r);
    }

    public static void runQuickSortFirstPivotUnique() {
        TestResult r = BenchmarkAlgorithms.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-FirstPivot-Unique", QuickSortFirstPivot::sortUnique);
        printResult(r);
    }

    public static void runQuickSortLastPivotUnique() {
        TestResult r = BenchmarkAlgorithms.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-LastPivot-Unique", QuickSortLastPivot::sortUnique);
        printResult(r);
    }

    public static void runQuickSortMedianPivotUnique() {
        TestResult r = BenchmarkAlgorithms.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-MedianPivot-Unique", QuickSortMedianPivot::sortUnique);
        printResult(r);
    }

    public static void runQuickSortRandomPivotUnique() {
        TestResult r = BenchmarkAlgorithms.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-RandomPivot-Unique", QuickSortRandomPivot::sortUnique);
        printResult(r);
    }

    public static void runMergeSortUnique() {
        TestResult r = BenchmarkAlgorithms.testMergeSortUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 100);
        printResult(r);
    }

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

    // ===== MAIN TEST EXECUTION =====

    public static void runAllSortingAlgorithms() {
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

        IO.println("\n");
        runAllFullDatasetTests();
        runAllUniqueDatasetTests();
    }
}
