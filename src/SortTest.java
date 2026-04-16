import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SortTest {

    public static void runBubbleSort() {
        ArrayList<Wine> originalWines = CSVImport.fileReader();
        HashSet<Double> originalUniqueAlcohol = CSVImport.uniqueAlcoholValues(originalWines);

        ArrayList<Wine> winesNonOpt = new ArrayList<>(originalWines);
        Collections.shuffle(winesNonOpt);

        BubbleSortNonOptimized.comparisons = 0;
        Timer timer1 = new Timer();
        timer1.start();
        BubbleSortNonOptimized.bubbleSortNonOptimized(winesNonOpt);
        timer1.end();

        IO.println("=== BUBBLE SORT NON-OPTIMIZED: FULL DATASET ===");
        IO.println("Time: " + timer1.getTime());
        IO.println("Comparisons: " + BubbleSortNonOptimized.comparisons);
        IO.println("");

        ArrayList<Double> alcoholNonOpt = new ArrayList<>(originalUniqueAlcohol);
        Collections.shuffle(alcoholNonOpt);

        BubbleSortNonOptimized.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        BubbleSortNonOptimized.bubbleSortNonOptimizedUnique(alcoholNonOpt);
        timer2.end();

        IO.println("=== BUBBLE SORT NON-OPTIMIZED: UNIQUE ALCOHOL VALUES ===");
        IO.println("Time: " + timer2.getTime());
        IO.println("Comparisons: " + BubbleSortNonOptimized.comparisons);
        IO.println("");

        ArrayList<Wine> winesOpt = new ArrayList<>(originalWines);

        BubbleSortOptimized.comparisons = 0;
        Timer timer3 = new Timer();
        timer3.start();
        BubbleSortOptimized.bubbleSortOptimized(winesOpt);
        timer3.end();

        IO.println("=== BUBBLE SORT OPTIMIZED: FULL DATASET ===");
        IO.println("Time: " + timer3.getTime());
        IO.println("Comparisons: " + BubbleSortOptimized.comparisons);
        IO.println("");

        ArrayList<Double> alcoholBest = new ArrayList<>(originalUniqueAlcohol);
        Collections.sort(alcoholBest);

        BubbleSortOptimized.comparisons = 0;
        Timer timer4 = new Timer();
        timer4.start();
        BubbleSortOptimized.bubbleSortOptimizedUnique(alcoholBest);
        timer4.end();

        IO.println("=== BUBBLE SORT OPTIMIZED: UNIQUE VALUES BEST CASE ===");
        IO.println("Time: " + timer4.getTime());
        IO.println("Comparisons: " + BubbleSortOptimized.comparisons);
        IO.println("");

        ArrayList<Double> alcoholWorst = new ArrayList<>(originalUniqueAlcohol);
        Collections.shuffle(alcoholWorst);

        BubbleSortOptimized.comparisons = 0;
        Timer timer5 = new Timer();
        timer5.start();
        BubbleSortOptimized.bubbleSortOptimizedUnique(alcoholWorst);
        timer5.end();

        IO.println("=== BUBBLE SORT OPTIMIZED: UNIQUE VALUES SHUFFLED ===");
        IO.println("Time: " + timer5.getTime());
        IO.println("Comparisons: " + BubbleSortOptimized.comparisons);
        IO.println("");
    }

    public static void runInsertionSort() {
        ArrayList<Wine> originalWines = CSVImport.fileReader();
        HashSet<Double> originalUniqueAlcohol = CSVImport.uniqueAlcoholValues(originalWines);

        ArrayList<Wine> winesForInsertion = new ArrayList<>(originalWines);

        InsertionSort.comparisons = 0;
        Timer timer1 = new Timer();
        timer1.start();
        InsertionSort.insertionSort(winesForInsertion);
        timer1.end();

        IO.println("=== INSERTION SORT: FULL DATASET ===");
        IO.println("Time: " + timer1.getTime());
        IO.println("Comparisons: " + InsertionSort.comparisons);
        IO.println("");

        ArrayList<Double> alcoholBest = new ArrayList<>(originalUniqueAlcohol);
        Collections.sort(alcoholBest);

        InsertionSort.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        InsertionSort.insertionSortUniqueAlcohol(alcoholBest);
        timer2.end();

        IO.println("=== INSERTION SORT: UNIQUE VALUES BEST CASE ===");
        IO.println("Time: " + timer2.getTime());
        IO.println("Comparisons: " + InsertionSort.comparisons);
        IO.println("");

        ArrayList<Double> alcoholWorst = new ArrayList<>(originalUniqueAlcohol);
        Collections.shuffle(alcoholWorst);

        InsertionSort.comparisons = 0;
        Timer timer3 = new Timer();
        timer3.start();
        InsertionSort.insertionSortUniqueAlcohol(alcoholWorst);
        timer3.end();

        IO.println("=== INSERTION SORT: UNIQUE VALUES SHUFFLED ===");
        IO.println("Time: " + timer3.getTime());
        IO.println("Comparisons: " + InsertionSort.comparisons);
        IO.println("");
    }

    public static void runMergeSort() {
        ArrayList<Wine> originalWines = CSVImport.fileReader();
        HashSet<Double> originalUniqueAlcohol = CSVImport.uniqueAlcoholValues(originalWines);

        ArrayList<Wine> winesForMergeSort = new ArrayList<>(originalWines);
        HashSet<Double> uniqueAlcoholForMergeSort = new HashSet<>(originalUniqueAlcohol);

        MergeSort.mergeCount = 0;
        Timer timer1 = new Timer();
        timer1.start();
        MergeSort.mergeSort(winesForMergeSort);
        timer1.end();

        IO.println("=== MERGE SORT: FULL DATASET ===");
        IO.println("Time: " + timer1.getTime());
        IO.println("Merge operations: " + MergeSort.mergeCount);
        IO.println("");

        MergeSort.uniqueMergeCount = 0;
        Timer timer2 = new Timer();
        timer2.start();
        MergeSort.mergeSortUnique(uniqueAlcoholForMergeSort);
        timer2.end();

        IO.println("=== MERGE SORT: UNIQUE ALCOHOL VALUES ===");
        IO.println("Time: " + timer2.getTime());
        IO.println("Merge operations: " + MergeSort.uniqueMergeCount);
        IO.println("");
    }

    public static void runQuickSortFirstPivot() {
        ArrayList<Wine> originalWines = CSVImport.fileReader();
        HashSet<Double> originalUniqueAlcohol = CSVImport.uniqueAlcoholValues(originalWines);

        ArrayList<Wine> wines = new ArrayList<>(originalWines);
        ArrayList<Double> alcohol = new ArrayList<>(originalUniqueAlcohol);

        QuickSortFirstPivot.comparisons = 0;
        Timer timer1 = new Timer();
        timer1.start();
        QuickSortFirstPivot.sort(wines);
        timer1.end();

        IO.println("=== QUICK SORT FIRST PIVOT: FULL DATASET ===");
        IO.println("Time: " + timer1.getTime());
        IO.println("Comparisons: " + QuickSortFirstPivot.comparisons);
        IO.println("");

        QuickSortFirstPivot.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        QuickSortFirstPivot.sortUnique(alcohol);
        timer2.end();

        IO.println("=== QUICK SORT FIRST PIVOT: UNIQUE ALCOHOL VALUES ===");
        IO.println("Time: " + timer2.getTime());
        IO.println("Comparisons: " + QuickSortFirstPivot.comparisons);
        IO.println("");
    }

    public static void runQuickSortLastPivot() {
        ArrayList<Wine> originalWines = CSVImport.fileReader();
        HashSet<Double> originalUniqueAlcohol = CSVImport.uniqueAlcoholValues(originalWines);

        ArrayList<Wine> wines = new ArrayList<>(originalWines);
        ArrayList<Double> alcohol = new ArrayList<>(originalUniqueAlcohol);

        QuickSortLastPivot.comparisons = 0;
        Timer timer1 = new Timer();
        timer1.start();
        QuickSortLastPivot.sort(wines);
        timer1.end();

        IO.println("=== QUICK SORT LAST PIVOT: FULL DATASET ===");
        IO.println("Time: " + timer1.getTime());
        IO.println("Comparisons: " + QuickSortLastPivot.comparisons);
        IO.println("");

        QuickSortLastPivot.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        QuickSortLastPivot.sortUnique(alcohol);
        timer2.end();

        IO.println("=== QUICK SORT LAST PIVOT: UNIQUE ALCOHOL VALUES ===");
        IO.println("Time: " + timer2.getTime());
        IO.println("Comparisons: " + QuickSortLastPivot.comparisons);
        IO.println("");
    }

    public static void runQuickSortMedianPivot() {
        ArrayList<Wine> originalWines = CSVImport.fileReader();
        HashSet<Double> originalUniqueAlcohol = CSVImport.uniqueAlcoholValues(originalWines);

        ArrayList<Wine> wines = new ArrayList<>(originalWines);
        ArrayList<Double> alcohol = new ArrayList<>(originalUniqueAlcohol);

        QuickSortMedianPivot.comparisons = 0;
        Timer timer1 = new Timer();
        timer1.start();
        QuickSortMedianPivot.sort(wines);
        timer1.end();

        IO.println("=== QUICK SORT MEDIAN PIVOT: FULL DATASET ===");
        IO.println("Time: " + timer1.getTime());
        IO.println("Comparisons: " + QuickSortMedianPivot.comparisons);
        IO.println("");

        QuickSortMedianPivot.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        QuickSortMedianPivot.sortUnique(alcohol);
        timer2.end();

        IO.println("=== QUICK SORT MEDIAN PIVOT: UNIQUE ALCOHOL VALUES ===");
        IO.println("Time: " + timer2.getTime());
        IO.println("Comparisons: " + QuickSortMedianPivot.comparisons);
        IO.println("");
    }

    public static void runQuickSortRandomPivot() {
        ArrayList<Wine> originalWines = CSVImport.fileReader();
        HashSet<Double> originalUniqueAlcohol = CSVImport.uniqueAlcoholValues(originalWines);

        ArrayList<Wine> wines = new ArrayList<>(originalWines);
        ArrayList<Double> alcohol = new ArrayList<>(originalUniqueAlcohol);

        QuickSortRandomPivot.comparisons = 0;
        Timer timer1 = new Timer();
        timer1.start();
        QuickSortRandomPivot.sort(wines);
        timer1.end();

        IO.println("=== QUICK SORT RANDOM PIVOT: FULL DATASET ===");
        IO.println("Time: " + timer1.getTime());
        IO.println("Comparisons: " + QuickSortRandomPivot.comparisons);
        IO.println("");

        QuickSortRandomPivot.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        QuickSortRandomPivot.sortUnique(alcohol);
        timer2.end();

        IO.println("=== QUICK SORT RANDOM PIVOT: UNIQUE ALCOHOL VALUES ===");
        IO.println("Time: " + timer2.getTime());
        IO.println("Comparisons: " + QuickSortRandomPivot.comparisons);
        IO.println("");
    }

    public static void runAllQuickSorts() {
        IO.println("=== RUNNING ALL QUICK SORT VARIANTS ===");
        IO.println("");

        runQuickSortFirstPivot();
        runQuickSortLastPivot();
        runQuickSortMedianPivot();
        runQuickSortRandomPivot();
    }

    public static void runAllSortnigAlgorithms() {
        IO.println("=== RUNNING ALL AVAILABLE SORTS ===");
        IO.println("");

        runBubbleSort();
        runInsertionSort();
        runMergeSort();
        runAllQuickSorts();
    }
}