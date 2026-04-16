import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.function.Consumer;

public class TestAlgorithmWine {

    public static TestResult testWineAlgorithm(ArrayList<Wine> dataset, boolean shuffle, int repetitions,
                                               String name, Consumer<ArrayList<Wine>> algorithm) {
        long totalTime = 0;
        long totalComparisons = 0;

        for (int i = 0; i < repetitions; i++) {
            ArrayList<Wine> copiedData = new ArrayList<>(dataset);

            if (shuffle) {
                Collections.shuffle(copiedData);
            }

            // Reset comparisons for this algorithm
            if (name.contains("BubbleSort-NonOptimized")) BubbleSortNonOptimized.comparisons = 0;
            else if (name.contains("BubbleSort-Optimized")) BubbleSortOptimized.comparisons = 0;
            else if (name.contains("InsertionSort")) InsertionSort.comparisons = 0;
            else if (name.contains("QuickSort-FirstPivot")) QuickSortFirstPivot.comparisons = 0;
            else if (name.contains("QuickSort-LastPivot")) QuickSortLastPivot.comparisons = 0;
            else if (name.contains("QuickSort-MedianPivot")) QuickSortMedianPivot.comparisons = 0;
            else if (name.contains("QuickSort-RandomPivot")) QuickSortRandomPivot.comparisons = 0;

            Timer timer = new Timer();
            timer.start();
            algorithm.accept(copiedData);
            timer.end();

            totalTime += timer.getTime();
            
            // Capture comparisons from the algorithm
            if (name.contains("BubbleSort-NonOptimized")) totalComparisons += BubbleSortNonOptimized.comparisons;
            else if (name.contains("BubbleSort-Optimized")) totalComparisons += BubbleSortOptimized.comparisons;
            else if (name.contains("InsertionSort")) totalComparisons += InsertionSort.comparisons;
            else if (name.contains("QuickSort-FirstPivot")) totalComparisons += QuickSortFirstPivot.comparisons;
            else if (name.contains("QuickSort-LastPivot")) totalComparisons += QuickSortLastPivot.comparisons;
            else if (name.contains("QuickSort-MedianPivot")) totalComparisons += QuickSortMedianPivot.comparisons;
            else if (name.contains("QuickSort-RandomPivot")) totalComparisons += QuickSortRandomPivot.comparisons;
        }

        return new TestResult(name, repetitions, shuffle, totalTime, totalComparisons, "Comparisons");
    }

    public static TestResult testUniqueAlgorithm(ArrayList<Double> dataset, boolean shuffle, int repetitions,
                                                 String name, Consumer<ArrayList<Double>> algorithm) {
        long totalTime = 0;
        long totalComparisons = 0;

        for (int i = 0; i < repetitions; i++) {
            ArrayList<Double> copiedData = new ArrayList<>(dataset);

            if (shuffle) {
                Collections.shuffle(copiedData);
            }

            // Reset comparisons for this algorithm
            if (name.contains("BubbleSort-NonOptimized")) BubbleSortNonOptimized.comparisons = 0;
            else if (name.contains("BubbleSort-Optimized")) BubbleSortOptimized.comparisons = 0;
            else if (name.contains("InsertionSort")) InsertionSort.comparisons = 0;
            else if (name.contains("QuickSort-FirstPivot")) QuickSortFirstPivot.comparisons = 0;
            else if (name.contains("QuickSort-LastPivot")) QuickSortLastPivot.comparisons = 0;
            else if (name.contains("QuickSort-MedianPivot")) QuickSortMedianPivot.comparisons = 0;
            else if (name.contains("QuickSort-RandomPivot")) QuickSortRandomPivot.comparisons = 0;

            Timer timer = new Timer();
            timer.start();
            algorithm.accept(copiedData);
            timer.end();

            totalTime += timer.getTime();
            
            // Capture comparisons from the algorithm
            if (name.contains("BubbleSort-NonOptimized")) totalComparisons += BubbleSortNonOptimized.comparisons;
            else if (name.contains("BubbleSort-Optimized")) totalComparisons += BubbleSortOptimized.comparisons;
            else if (name.contains("InsertionSort")) totalComparisons += InsertionSort.comparisons;
            else if (name.contains("QuickSort-FirstPivot")) totalComparisons += QuickSortFirstPivot.comparisons;
            else if (name.contains("QuickSort-LastPivot")) totalComparisons += QuickSortLastPivot.comparisons;
            else if (name.contains("QuickSort-MedianPivot")) totalComparisons += QuickSortMedianPivot.comparisons;
            else if (name.contains("QuickSort-RandomPivot")) totalComparisons += QuickSortRandomPivot.comparisons;
        }

        return new TestResult(name, repetitions, shuffle, totalTime, totalComparisons, "Comparisons");
    }

    public static TestResult testMergeSort(ArrayList<Wine> dataset, int repetitions) {
        long totalTime = 0;
        long totalMerges = 0;

        for (int i = 0; i < repetitions; i++) {
            ArrayList<Wine> copiedData = new ArrayList<>(dataset);
            Collections.shuffle(copiedData);

            MergeSort.mergeCount = 0;

            Timer timer = new Timer();
            timer.start();
            MergeSort.mergeSort(copiedData);
            timer.end();

            totalTime += timer.getTime();
            totalMerges += MergeSort.mergeCount;
        }

        return new TestResult("Merge Sort", repetitions, true, totalTime, totalMerges, "Merge Operations");
    }

    public static TestResult testMergeSortUnique(ArrayList<Double> dataset, int repetitions) {
        long totalTime = 0;
        long totalMerges = 0;

        for (int i = 0; i < repetitions; i++) {
            ArrayList<Double> copiedData = new ArrayList<>(dataset);
            Collections.shuffle(copiedData);

            HashSet<Double> uniqueSet = new HashSet<>(copiedData);

            MergeSort.uniqueMergeCount = 0;

            Timer timer = new Timer();
            timer.start();
            MergeSort.mergeSortUnique(uniqueSet);
            timer.end();

            totalTime += timer.getTime();
            totalMerges += MergeSort.uniqueMergeCount;
        }

        return new TestResult("Merge Sort Unique", repetitions, true, totalTime, totalMerges, "Merge Operations");
    }

    public static void runWarmUp(ArrayList<Wine> dataset, int warmUpLength, String name,
                                 Consumer<ArrayList<Wine>> algorithm) {
        for (int i = 0; i < warmUpLength; i++) {
            ArrayList<Wine> copiedData = new ArrayList<>(dataset);
            algorithm.accept(copiedData);
        }
    }

    public static void runWarmUpDouble(ArrayList<Double> dataset, int warmUpLength, String name,
                                       Consumer<ArrayList<Double>> algorithm) {
        for (int i = 0; i < warmUpLength; i++) {
            ArrayList<Double> copiedData = new ArrayList<>(dataset);
            algorithm.accept(copiedData);
        }
    }

    public static void runMergeWarmUp(ArrayList<Wine> dataset, int warmUpLength, String name) {
        for (int i = 0; i < warmUpLength; i++) {
            ArrayList<Wine> copiedData = new ArrayList<>(dataset);
            MergeSort.mergeCount = 0;
            MergeSort.mergeSort(copiedData);
        }
    }

    public static void runMergeUniqueWarmUp(ArrayList<Double> dataset, int warmUpLength, String name) {
        for (int i = 0; i < warmUpLength; i++) {
            ArrayList<Double> copiedData = new ArrayList<>(dataset);
            HashSet<Double> uniqueSet = new HashSet<>(copiedData);
            MergeSort.uniqueMergeCount = 0;
            MergeSort.mergeSortUnique(uniqueSet);
        }
    }
}
