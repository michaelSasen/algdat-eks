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

        IO.println("BubbleSort-NonOptimized-Full     Time: " + timer1.getTime()
                + "     Comparisons: " + BubbleSortNonOptimized.comparisons);

        ArrayList<Double> alcoholNonOpt = new ArrayList<>(originalUniqueAlcohol);
        Collections.shuffle(alcoholNonOpt);

        BubbleSortNonOptimized.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        BubbleSortNonOptimized.bubbleSortNonOptimizedUnique(alcoholNonOpt);
        timer2.end();

        IO.println("BubbleSort-NonOptimized-Unique     Time: " + timer2.getTime()
                + "     Comparisons: " + BubbleSortNonOptimized.comparisons);

        ArrayList<Wine> winesOpt = new ArrayList<>(originalWines);

        BubbleSortOptimized.comparisons = 0;
        Timer timer3 = new Timer();
        timer3.start();
        BubbleSortOptimized.bubbleSortOptimized(winesOpt);
        timer3.end();

        IO.println("BubbleSort-Optimized-Full     Time: " + timer3.getTime()
                + "     Comparisons: " + BubbleSortOptimized.comparisons);

        ArrayList<Double> alcoholBest = new ArrayList<>(originalUniqueAlcohol);
        Collections.sort(alcoholBest);

        BubbleSortOptimized.comparisons = 0;
        Timer timer4 = new Timer();
        timer4.start();
        BubbleSortOptimized.bubbleSortOptimizedUnique(alcoholBest);
        timer4.end();

        IO.println("BubbleSort-Optimized-Unique-BestCase     Time: " + timer4.getTime()
                + "     Comparisons: " + BubbleSortOptimized.comparisons);

        ArrayList<Double> alcoholWorst = new ArrayList<>(originalUniqueAlcohol);
        Collections.shuffle(alcoholWorst);

        BubbleSortOptimized.comparisons = 0;
        Timer timer5 = new Timer();
        timer5.start();
        BubbleSortOptimized.bubbleSortOptimizedUnique(alcoholWorst);
        timer5.end();

        IO.println("BubbleSort-Optimized-Unique-Shuffled     Time: " + timer5.getTime()
                + "     Comparisons: " + BubbleSortOptimized.comparisons);

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

        IO.println("InsertionSort-Full     Time: " + timer1.getTime()
                + "     Comparisons: " + InsertionSort.comparisons);

        ArrayList<Double> alcoholBest = new ArrayList<>(originalUniqueAlcohol);
        Collections.sort(alcoholBest);

        InsertionSort.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        InsertionSort.insertionSortUniqueAlcohol(alcoholBest);
        timer2.end();

        IO.println("InsertionSort-Unique-BestCase     Time: " + timer2.getTime()
                + "     Comparisons: " + InsertionSort.comparisons);

        ArrayList<Double> alcoholWorst = new ArrayList<>(originalUniqueAlcohol);
        Collections.shuffle(alcoholWorst);

        InsertionSort.comparisons = 0;
        Timer timer3 = new Timer();
        timer3.start();
        InsertionSort.insertionSortUniqueAlcohol(alcoholWorst);
        timer3.end();

        IO.println("InsertionSort-Unique-Shuffled     Time: " + timer3.getTime()
                + "     Comparisons: " + InsertionSort.comparisons);

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

        IO.println("MergeSort-Full     Time: " + timer1.getTime()
                + "     Merge operations: " + MergeSort.mergeCount);

        MergeSort.uniqueMergeCount = 0;
        Timer timer2 = new Timer();
        timer2.start();
        MergeSort.mergeSortUnique(uniqueAlcoholForMergeSort);
        timer2.end();

        IO.println("MergeSort-Unique     Time: " + timer2.getTime()
                + "     Merge operations: " + MergeSort.uniqueMergeCount);

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

        IO.println("QuickSort-FirstPivot-Full     Time: " + timer1.getTime()
                + "     Comparisons: " + QuickSortFirstPivot.comparisons);

        QuickSortFirstPivot.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        QuickSortFirstPivot.sortUnique(alcohol);
        timer2.end();

        IO.println("QuickSort-FirstPivot-Unique     Time: " + timer2.getTime()
                + "     Comparisons: " + QuickSortFirstPivot.comparisons);

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

        IO.println("QuickSort-LastPivot-Full     Time: " + timer1.getTime()
                + "     Comparisons: " + QuickSortLastPivot.comparisons);

        QuickSortLastPivot.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        QuickSortLastPivot.sortUnique(alcohol);
        timer2.end();

        IO.println("QuickSort-LastPivot-Unique     Time: " + timer2.getTime()
                + "     Comparisons: " + QuickSortLastPivot.comparisons);

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

        IO.println("QuickSort-MedianPivot-Full     Time: " + timer1.getTime()
                + "     Comparisons: " + QuickSortMedianPivot.comparisons);

        QuickSortMedianPivot.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        QuickSortMedianPivot.sortUnique(alcohol);
        timer2.end();

        IO.println("QuickSort-MedianPivot-Unique     Time: " + timer2.getTime()
                + "     Comparisons: " + QuickSortMedianPivot.comparisons);

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

        IO.println("QuickSort-RandomPivot-Full     Time: " + timer1.getTime()
                + "     Comparisons: " + QuickSortRandomPivot.comparisons);

        QuickSortRandomPivot.comparisons = 0;
        Timer timer2 = new Timer();
        timer2.start();
        QuickSortRandomPivot.sortUnique(alcohol);
        timer2.end();

        IO.println("QuickSort-RandomPivot-Unique     Time: " + timer2.getTime()
                + "     Comparisons: " + QuickSortRandomPivot.comparisons);

        IO.println("");
    }

    public static void runAllQuickSorts() {
        IO.println("---AllQuickSorts---");
        runQuickSortFirstPivot();
        runQuickSortLastPivot();
        runQuickSortMedianPivot();
        runQuickSortRandomPivot();
    }

    public static void runAllSortnigAlgorithms() {
        IO.println("---AllSortingAlgorithms---");
        runBubbleSort();
        runInsertionSort();
        runMergeSort();
        runAllQuickSorts();
    }
}