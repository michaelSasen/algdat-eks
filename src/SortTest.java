import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SortTest {

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
        TestResult r1 = TestAlgorithmWine.testWineAlgorithm(ORIGINAL_WINES, true, 100, "BubbleSort-NonOptimized-Full", BubbleSortNonOptimized::bubbleSortNonOptimized);
        printResult(r1);
        TestResult r2 = TestAlgorithmWine.testWineAlgorithm(ORIGINAL_WINES, true, 100, "BubbleSort-Optimized-Full", BubbleSortOptimized::bubbleSortOptimized);
        printResult(r2);
    }

    public static void runInsertionSortFull() {
        TestResult r = TestAlgorithmWine.testWineAlgorithm(ORIGINAL_WINES, true, 100, "InsertionSort-Full", InsertionSort::insertionSort);
        printResult(r);
    }

    public static void runQuickSortFirstPivotFull() {
        TestResult r = TestAlgorithmWine.testWineAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-FirstPivot-Full", QuickSortFirstPivot::sort);
        printResult(r);
    }

    public static void runQuickSortLastPivotFull() {
        TestResult r = TestAlgorithmWine.testWineAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-LastPivot-Full", QuickSortLastPivot::sort);
        printResult(r);
    }

    public static void runQuickSortMedianPivotFull() {
        TestResult r = TestAlgorithmWine.testWineAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-MedianPivot-Full", QuickSortMedianPivot::sort);
        printResult(r);
    }

    public static void runQuickSortRandomPivotFull() {
        TestResult r = TestAlgorithmWine.testWineAlgorithm(ORIGINAL_WINES, true, 100, "QuickSort-RandomPivot-Full", QuickSortRandomPivot::sort);
        printResult(r);
    }

    public static void runMergeSortFull() {
        TestResult r = TestAlgorithmWine.testMergeSort(ORIGINAL_WINES, 100);
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
        TestResult r1 = TestAlgorithmWine.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "BubbleSort-NonOptimized-Unique", BubbleSortNonOptimized::bubbleSortNonOptimizedUnique);
        printResult(r1);
        TestResult r2 = TestAlgorithmWine.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "BubbleSort-Optimized-Unique", BubbleSortOptimized::bubbleSortOptimizedUnique);
        printResult(r2);
    }

    public static void runInsertionSortUnique() {
        TestResult r = TestAlgorithmWine.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "InsertionSort-Unique", InsertionSort::insertionSortUniqueAlcohol);
        printResult(r);
    }

    public static void runQuickSortFirstPivotUnique() {
        TestResult r = TestAlgorithmWine.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-FirstPivot-Unique", QuickSortFirstPivot::sortUnique);
        printResult(r);
    }

    public static void runQuickSortLastPivotUnique() {
        TestResult r = TestAlgorithmWine.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-LastPivot-Unique", QuickSortLastPivot::sortUnique);
        printResult(r);
    }

    public static void runQuickSortMedianPivotUnique() {
        TestResult r = TestAlgorithmWine.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-MedianPivot-Unique", QuickSortMedianPivot::sortUnique);
        printResult(r);
    }

    public static void runQuickSortRandomPivotUnique() {
        TestResult r = TestAlgorithmWine.testUniqueAlgorithm(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), true, 100, "QuickSort-RandomPivot-Unique", QuickSortRandomPivot::sortUnique);
        printResult(r);
    }

    public static void runMergeSortUnique() {
        TestResult r = TestAlgorithmWine.testMergeSortUnique(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 100);
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
        TestAlgorithmWine.runWarmUp(ORIGINAL_WINES, 10, "Bubble Sort Non-Optimized", BubbleSortNonOptimized::bubbleSortNonOptimized);
        TestAlgorithmWine.runWarmUp(ORIGINAL_WINES, 10, "Bubble Sort Optimized", BubbleSortOptimized::bubbleSortOptimized);
        TestAlgorithmWine.runWarmUp(ORIGINAL_WINES, 10, "Insertion Sort", InsertionSort::insertionSort);
        TestAlgorithmWine.runWarmUp(ORIGINAL_WINES, 10, "Quick Sort First Pivot", QuickSortFirstPivot::sort);
        TestAlgorithmWine.runWarmUp(ORIGINAL_WINES, 10, "Quick Sort Last Pivot", QuickSortLastPivot::sort);
        TestAlgorithmWine.runWarmUp(ORIGINAL_WINES, 10, "Quick Sort Median Pivot", QuickSortMedianPivot::sort);
        TestAlgorithmWine.runWarmUp(ORIGINAL_WINES, 10, "Quick Sort Random Pivot", QuickSortRandomPivot::sort);
        TestAlgorithmWine.runMergeWarmUp(ORIGINAL_WINES, 10, "Merge Sort");
        IO.println("Warm-up complete.\n");

        IO.println("Warming up Unique Dataset algorithms...");
        TestAlgorithmWine.runWarmUpDouble(new ArrayList<Double>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Bubble Sort Non-Optimized Unique", BubbleSortNonOptimized::bubbleSortNonOptimizedUnique);
        TestAlgorithmWine.runWarmUpDouble(new ArrayList<Double>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Bubble Sort Optimized Unique", BubbleSortOptimized::bubbleSortOptimizedUnique);
        TestAlgorithmWine.runWarmUpDouble(new ArrayList<Double>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Insertion Sort Unique", InsertionSort::insertionSortUniqueAlcohol);
        TestAlgorithmWine.runWarmUpDouble(new ArrayList<Double>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Quick Sort First Pivot Unique", QuickSortFirstPivot::sortUnique);
        TestAlgorithmWine.runWarmUpDouble(new ArrayList<Double>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Quick Sort Last Pivot Unique", QuickSortLastPivot::sortUnique);
        TestAlgorithmWine.runWarmUpDouble(new ArrayList<Double>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Quick Sort Median Pivot Unique", QuickSortMedianPivot::sortUnique);
        TestAlgorithmWine.runWarmUpDouble(new ArrayList<Double>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Quick Sort Random Pivot Unique", QuickSortRandomPivot::sortUnique);
        TestAlgorithmWine.runMergeUniqueWarmUp(new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL), 10, "Merge Sort Unique");
        IO.println("Warm-up complete.\n");

        IO.println("\n");
        runAllFullDatasetTests();
        runAllUniqueDatasetTests();
    }
}
