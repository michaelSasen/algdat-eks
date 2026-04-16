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

    private static void printResult(String algorithm, Long time, String metric) {
        System.out.printf("%-45s | Time: %-15s | %s%n", algorithm, time, metric);
    }

    // ===== FULL DATASET TESTS =====
    
    public static void runBubbleSortFull() {
        Timer timer;
        
        ArrayList<Wine> winesNonOpt = new ArrayList<>(ORIGINAL_WINES);
        Collections.shuffle(winesNonOpt);
        BubbleSortNonOptimized.comparisons = 0;
        timer = new Timer();
        timer.start();
        BubbleSortNonOptimized.bubbleSortNonOptimized(winesNonOpt);
        timer.end();
        printResult("BubbleSort-NonOptimized-Full-Shuffled", timer.getTime(), 
                "Comparisons: " + BubbleSortNonOptimized.comparisons);

        ArrayList<Wine> winesOptBest = new ArrayList<>(ORIGINAL_WINES);
        winesOptBest.sort((w1, w2) -> Double.compare(w1.alcohol(), w2.alcohol()));
        BubbleSortOptimized.comparisons = 0;
        timer = new Timer();
        timer.start();
        BubbleSortOptimized.bubbleSortOptimized(winesOptBest);
        timer.end();
        printResult("BubbleSort-Optimized-Full-BestCase", timer.getTime(),
                "Comparisons: " + BubbleSortOptimized.comparisons);

        ArrayList<Wine> winesOptWorst = new ArrayList<>(ORIGINAL_WINES);
        Collections.shuffle(winesOptWorst);
        BubbleSortOptimized.comparisons = 0;
        timer = new Timer();
        timer.start();
        BubbleSortOptimized.bubbleSortOptimized(winesOptWorst);
        timer.end();
        printResult("BubbleSort-Optimized-Full-Shuffled", timer.getTime(),
                "Comparisons: " + BubbleSortOptimized.comparisons);
    }

    public static void runInsertionSortFull() {
        Timer timer;
        
        ArrayList<Wine> winesWorst = new ArrayList<>(ORIGINAL_WINES);
        Collections.shuffle(winesWorst);
        InsertionSort.comparisons = 0;
        timer = new Timer();
        timer.start();
        InsertionSort.insertionSort(winesWorst);
        timer.end();
        printResult("InsertionSort-Full-Shuffled", timer.getTime(),
                "Comparisons: " + InsertionSort.comparisons);

        ArrayList<Wine> winesBest = new ArrayList<>(ORIGINAL_WINES);
        winesBest.sort((w1, w2) -> Double.compare(w1.alcohol(), w2.alcohol()));
        InsertionSort.comparisons = 0;
        timer = new Timer();
        timer.start();
        InsertionSort.insertionSort(winesBest);
        timer.end();
        printResult("InsertionSort-Full-BestCase", timer.getTime(),
                "Comparisons: " + InsertionSort.comparisons);
    }

    public static void runMergeSortFull() {
        Timer timer;
        
        ArrayList<Wine> winesForMergeSort = new ArrayList<>(ORIGINAL_WINES);
        Collections.shuffle(winesForMergeSort);
        MergeSort.mergeCount = 0;
        timer = new Timer();
        timer.start();
        MergeSort.mergeSort(winesForMergeSort);
        timer.end();
        printResult("MergeSort-Full", timer.getTime(),
                "Merge operations: " + MergeSort.mergeCount);
    }

    public static void runQuickSortFirstPivotFull() {
        Timer timer;
        
        ArrayList<Wine> wines = new ArrayList<>(ORIGINAL_WINES);
        Collections.shuffle(wines);
        QuickSortFirstPivot.comparisons = 0;
        timer = new Timer();
        timer.start();
        QuickSortFirstPivot.sort(wines);
        timer.end();
        printResult("QuickSort-FirstPivot-Full", timer.getTime(),
                "Comparisons: " + QuickSortFirstPivot.comparisons);
    }

    public static void runQuickSortLastPivotFull() {
        Timer timer;
        
        ArrayList<Wine> wines = new ArrayList<>(ORIGINAL_WINES);
        Collections.shuffle(wines);
        QuickSortLastPivot.comparisons = 0;
        timer = new Timer();
        timer.start();
        QuickSortLastPivot.sort(wines);
        timer.end();
        printResult("QuickSort-LastPivot-Full", timer.getTime(),
                "Comparisons: " + QuickSortLastPivot.comparisons);
    }

    public static void runQuickSortMedianPivotFull() {
        Timer timer;
        
        ArrayList<Wine> wines = new ArrayList<>(ORIGINAL_WINES);
        Collections.shuffle(wines);
        QuickSortMedianPivot.comparisons = 0;
        timer = new Timer();
        timer.start();
        QuickSortMedianPivot.sort(wines);
        timer.end();
        printResult("QuickSort-MedianPivot-Full", timer.getTime(),
                "Comparisons: " + QuickSortMedianPivot.comparisons);
    }

    public static void runQuickSortRandomPivotFull() {
        Timer timer;
        
        ArrayList<Wine> wines = new ArrayList<>(ORIGINAL_WINES);
        Collections.shuffle(wines);
        QuickSortRandomPivot.comparisons = 0;
        timer = new Timer();
        timer.start();
        QuickSortRandomPivot.sort(wines);
        timer.end();
        printResult("QuickSort-RandomPivot-Full", timer.getTime(),
                "Comparisons: " + QuickSortRandomPivot.comparisons);
    }

    public static void runAllFullDatasetTests() {
        IO.println("---Full Dataset Sorting---");
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
        Timer timer;
        
        ArrayList<Double> alcoholNonOpt = new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL);
        Collections.shuffle(alcoholNonOpt);
        BubbleSortNonOptimized.comparisons = 0;
        timer = new Timer();
        timer.start();
        BubbleSortNonOptimized.bubbleSortNonOptimizedUnique(alcoholNonOpt);
        timer.end();
        printResult("BubbleSort-NonOptimized-Unique", timer.getTime(),
                "Comparisons: " + BubbleSortNonOptimized.comparisons);

        ArrayList<Double> alcoholBest = new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL);
        Collections.sort(alcoholBest);
        BubbleSortOptimized.comparisons = 0;
        timer = new Timer();
        timer.start();
        BubbleSortOptimized.bubbleSortOptimizedUnique(alcoholBest);
        timer.end();
        printResult("BubbleSort-Optimized-Unique-BestCase", timer.getTime(),
                "Comparisons: " + BubbleSortOptimized.comparisons);

        ArrayList<Double> alcoholWorst = new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL);
        Collections.shuffle(alcoholWorst);
        BubbleSortOptimized.comparisons = 0;
        timer = new Timer();
        timer.start();
        BubbleSortOptimized.bubbleSortOptimizedUnique(alcoholWorst);
        timer.end();
        printResult("BubbleSort-Optimized-Unique-Shuffled", timer.getTime(),
                "Comparisons: " + BubbleSortOptimized.comparisons);
    }

    public static void runInsertionSortUnique() {
        Timer timer;
        
        ArrayList<Double> alcoholBest = new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL);
        Collections.sort(alcoholBest);
        InsertionSort.comparisons = 0;
        timer = new Timer();
        timer.start();
        InsertionSort.insertionSortUniqueAlcohol(alcoholBest);
        timer.end();
        printResult("InsertionSort-Unique-BestCase", timer.getTime(),
                "Comparisons: " + InsertionSort.comparisons);

        ArrayList<Double> alcoholWorst = new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL);
        Collections.shuffle(alcoholWorst);
        InsertionSort.comparisons = 0;
        timer = new Timer();
        timer.start();
        InsertionSort.insertionSortUniqueAlcohol(alcoholWorst);
        timer.end();
        printResult("InsertionSort-Unique-Shuffled", timer.getTime(),
                "Comparisons: " + InsertionSort.comparisons);
    }

    public static void runMergeSortUnique() {
        Timer timer;
        
        HashSet<Double> uniqueAlcoholForMergeSort = new HashSet<>(ORIGINAL_UNIQUE_ALCOHOL);
        MergeSort.uniqueMergeCount = 0;
        timer = new Timer();
        timer.start();
        MergeSort.mergeSortUnique(uniqueAlcoholForMergeSort);
        timer.end();
        printResult("MergeSort-Unique", timer.getTime(),
                "Merge operations: " + MergeSort.uniqueMergeCount);
    }

    public static void runQuickSortFirstPivotUnique() {
        Timer timer;
        
        ArrayList<Double> alcohol = new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL);
        QuickSortFirstPivot.comparisons = 0;
        timer = new Timer();
        timer.start();
        QuickSortFirstPivot.sortUnique(alcohol);
        timer.end();
        printResult("QuickSort-FirstPivot-Unique", timer.getTime(),
                "Comparisons: " + QuickSortFirstPivot.comparisons);
    }

    public static void runQuickSortLastPivotUnique() {
        Timer timer;
        
        ArrayList<Double> alcohol = new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL);
        QuickSortLastPivot.comparisons = 0;
        timer = new Timer();
        timer.start();
        QuickSortLastPivot.sortUnique(alcohol);
        timer.end();
        printResult("QuickSort-LastPivot-Unique", timer.getTime(),
                "Comparisons: " + QuickSortLastPivot.comparisons);
    }

    public static void runQuickSortMedianPivotUnique() {
        Timer timer;
        
        ArrayList<Double> alcohol = new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL);
        QuickSortMedianPivot.comparisons = 0;
        timer = new Timer();
        timer.start();
        QuickSortMedianPivot.sortUnique(alcohol);
        timer.end();
        printResult("QuickSort-MedianPivot-Unique", timer.getTime(),
                "Comparisons: " + QuickSortMedianPivot.comparisons);
    }

    public static void runQuickSortRandomPivotUnique() {
        Timer timer;
        
        ArrayList<Double> alcohol = new ArrayList<>(ORIGINAL_UNIQUE_ALCOHOL);
        QuickSortRandomPivot.comparisons = 0;
        timer = new Timer();
        timer.start();
        QuickSortRandomPivot.sortUnique(alcohol);
        timer.end();
        printResult("QuickSort-RandomPivot-Unique", timer.getTime(),
                "Comparisons: " + QuickSortRandomPivot.comparisons);
    }

    public static void runAllUniqueDatasetTests() {
        IO.println("---Unique Alcohol Values Sorting---");
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
        runAllFullDatasetTests();
        runAllUniqueDatasetTests();
    }
}
