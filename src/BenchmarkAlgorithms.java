import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.function.Consumer;

public class BenchmarkAlgorithms {

    // Generic benchmark method for Wine dataset
    public static TestResult testAlgorithm(ArrayList<Wine> dataset, boolean shuffle, int repetitions, String name, Consumer<ArrayList<Wine>> algorithm) {
        long totalTime = 0;
        long totalComparisons = 0;

        for (int i = 0; i < repetitions; i++) {

            // Create a fresh copy of dataset for each run
            ArrayList<Wine> copiedData = new ArrayList<>(dataset);

            // Shuffle data to avoid best/worst case bias
            if (shuffle) {
                Collections.shuffle(copiedData);
            }

            // Reset comparison counter for selected algorithm
            if (name.contains("BubbleSort-NonOptimized")) BubbleSortNonOptimized.comparisons = 0;
            else if (name.contains("BubbleSort-Optimized")) BubbleSortOptimized.comparisons = 0;
            else if (name.contains("InsertionSort")) InsertionSort.comparisons = 0;
            else if (name.contains("QuickSort-FirstPivot")) QuickSortFirstPivot.comparisons = 0;
            else if (name.contains("QuickSort-LastPivot")) QuickSortLastPivot.comparisons = 0;
            else if (name.contains("QuickSort-MedianPivot")) QuickSortMedianPivot.comparisons = 0;
            else if (name.contains("QuickSort-RandomPivot")) QuickSortRandomPivot.comparisons = 0;

            // Measure execution time
            Timer timer = new Timer();
            timer.start();
            algorithm.accept(copiedData);
            timer.end();

            totalTime += timer.getTime();

            // Collect comparison count after execution
            if (name.contains("BubbleSort-NonOptimized")) totalComparisons += BubbleSortNonOptimized.comparisons;
            else if (name.contains("BubbleSort-Optimized")) totalComparisons += BubbleSortOptimized.comparisons;
            else if (name.contains("InsertionSort")) totalComparisons += InsertionSort.comparisons;
            else if (name.contains("QuickSort-FirstPivot")) totalComparisons += QuickSortFirstPivot.comparisons;
            else if (name.contains("QuickSort-LastPivot")) totalComparisons += QuickSortLastPivot.comparisons;
            else if (name.contains("QuickSort-MedianPivot")) totalComparisons += QuickSortMedianPivot.comparisons;
            else if (name.contains("QuickSort-RandomPivot")) totalComparisons += QuickSortRandomPivot.comparisons;
        }

        // Return aggregated benchmark result
        return new TestResult(name, repetitions, shuffle, totalTime, totalComparisons, "Comparisons");
    }

    // Same benchmark method for unique alcohol values (Double dataset)
    public static TestResult testAlgorithmUnique(ArrayList<Double> dataset, boolean shuffle, int repetitions, String name, Consumer<ArrayList<Double>> algorithm) {
        long totalTime = 0;
        long totalComparisons = 0;

        for (int i = 0; i < repetitions; i++) {

            // Copy dataset for independent run
            ArrayList<Double> copiedData = new ArrayList<>(dataset);

            if (shuffle) {
                Collections.shuffle(copiedData);
            }

            // Reset comparison counters
            if (name.contains("BubbleSort-NonOptimized")) BubbleSortNonOptimized.comparisons = 0;
            else if (name.contains("BubbleSort-Optimized")) BubbleSortOptimized.comparisons = 0;
            else if (name.contains("InsertionSort")) InsertionSort.comparisons = 0;
            else if (name.contains("QuickSort-FirstPivot")) QuickSortFirstPivot.comparisons = 0;
            else if (name.contains("QuickSort-LastPivot")) QuickSortLastPivot.comparisons = 0;
            else if (name.contains("QuickSort-MedianPivot")) QuickSortMedianPivot.comparisons = 0;
            else if (name.contains("QuickSort-RandomPivot")) QuickSortRandomPivot.comparisons = 0;

            // Measure execution time
            Timer timer = new Timer();
            timer.start();
            algorithm.accept(copiedData);
            timer.end();

            totalTime += timer.getTime();

            // Collect comparison count
            if (name.contains("BubbleSort-NonOptimized")) totalComparisons += BubbleSortNonOptimized.comparisons;
            else if (name.contains("BubbleSort-Optimized")) totalComparisons += BubbleSortOptimized.comparisons;
            else if (name.contains("InsertionSort")) totalComparisons += InsertionSort.comparisons;
            else if (name.contains("QuickSort-FirstPivot")) totalComparisons += QuickSortFirstPivot.comparisons;
            else if (name.contains("QuickSort-LastPivot")) totalComparisons += QuickSortLastPivot.comparisons;
            else if (name.contains("QuickSort-MedianPivot")) totalComparisons += QuickSortMedianPivot.comparisons;
            else if (name.contains("QuickSort-RandomPivot")) totalComparisons += QuickSortRandomPivot.comparisons;
        }

        // Return result for unique dataset
        return new TestResult(name, repetitions, shuffle, totalTime, totalComparisons, "Comparisons");
    }

    // Benchmark Merge Sort (Wine dataset)
    public static TestResult testMergeSort(ArrayList<Wine> dataset, int repetitions) {
        long totalTime = 0;
        long totalMerges = 0;

        for (int i = 0; i < repetitions; i++) {

            // Copy and shuffle dataset
            ArrayList<Wine> copiedData = new ArrayList<>(dataset);
            Collections.shuffle(copiedData);

            // Reset merge counter
            MergeSort.mergeCount = 0;

            // Measure execution time
            Timer timer = new Timer();
            timer.start();
            MergeSort.mergeSort(copiedData);
            timer.end();

            totalTime += timer.getTime();
            totalMerges += MergeSort.mergeCount;
        }

        // Return merge sort results
        return new TestResult("Merge Sort", repetitions, true, totalTime, totalMerges, "Merge Operations");
    }

    // Benchmark Merge Sort for unique values
    public static TestResult testMergeSortUnique(ArrayList<Double> dataset, int repetitions) {
        long totalTime = 0;
        long totalMerges = 0;

        for (int i = 0; i < repetitions; i++) {

            // Copy and shuffle dataset
            ArrayList<Double> copiedData = new ArrayList<>(dataset);
            Collections.shuffle(copiedData);

            // Convert to set (unique values)
            HashSet<Double> uniqueSet = new HashSet<>(copiedData);

            // Reset merge counter
            MergeSort.uniqueMergeCount = 0;

            // Measure execution time
            Timer timer = new Timer();
            timer.start();
            MergeSort.mergeSortUnique(uniqueSet);
            timer.end();

            totalTime += timer.getTime();
            totalMerges += MergeSort.uniqueMergeCount;
        }

        // Return results for unique merge sort
        return new TestResult("Merge Sort Unique", repetitions, true, totalTime, totalMerges, "Merge Operations");
    }

    // Warm-up runs for Wine dataset (no measurements)
    public static void runWarmUp(ArrayList<Wine> dataset, int warmUpLength, String name, Consumer<ArrayList<Wine>> algorithm) {
        for (int i = 0; i < warmUpLength; i++) {
            ArrayList<Wine> copiedData = new ArrayList<>(dataset);
            algorithm.accept(copiedData);
        }
    }

    // Warm-up runs for Double dataset
    public static void runWarmUpDouble(ArrayList<Double> dataset, int warmUpLength, String name, Consumer<ArrayList<Double>> algorithm) {
        for (int i = 0; i < warmUpLength; i++) {
            ArrayList<Double> copiedData = new ArrayList<>(dataset);
            algorithm.accept(copiedData);
        }
    }

    // Warm-up for Merge Sort (Wine dataset)
    public static void runMergeWarmUp(ArrayList<Wine> dataset, int warmUpLength, String name) {
        for (int i = 0; i < warmUpLength; i++) {
            ArrayList<Wine> copiedData = new ArrayList<>(dataset);
            MergeSort.mergeCount = 0;
            MergeSort.mergeSort(copiedData);
        }
    }

    // Warm-up for Merge Sort (unique dataset)
    public static void runMergeUniqueWarmUp(ArrayList<Double> dataset, int warmUpLength, String name) {
        for (int i = 0; i < warmUpLength; i++) {
            ArrayList<Double> copiedData = new ArrayList<>(dataset);
            HashSet<Double> uniqueSet = new HashSet<>(copiedData);
            MergeSort.uniqueMergeCount = 0;
            MergeSort.mergeSortUnique(uniqueSet);
        }
    }
}