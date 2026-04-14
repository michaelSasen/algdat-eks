/* ==============================================================================
* TASK 3: MERGE SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 26/03-26
============================================================================== */

import java.util.ArrayList;
import java.util.HashSet;

public class MergeSort {
    // merge counters for operations
    public static int mergeCount = 0;
    public static int uniqueMergeCount = 0;


/*
void main() {

    ArrayList<Wine> wines = CSVImport.fileReader();
    HashSet<Double> uniqueAlcohol = CSVImport.uniqueAlcoholValues(wines);

    // reset counter befor sorting
    mergeCount = 0;
    uniqueMergeCount = 0;

    int[] result = mergeSort(wines);
    int[] uniqueResults = mergeSortUniqueAlcohol(uniqueAlcohol);

    Timer timer = new Timer();

    // reset counter to avoid adding merge counts from previous runs
    mergeCount = 0;
    timer.start();
    mergeSort(wines);
    timer.end();

    IO.println("Full dataset: ");
    IO.println("Time: " + timer.getTime());
    IO.println("Comparisons: " + result[0]);
    IO.println("Moves: " + result[1]);
    IO.println("Merge operations: " + mergeCount); // ADDED

    // reset counter to avoid adding merge counts from previous runs
    uniqueMergeCount = 0;
    timer.start();
    mergeSortUniqueAlcohol(uniqueAlcohol);
    timer.end();

    IO.println("");

    IO.println("Unique alcohol values: ");
    IO.println("Time: " + timer.getTime());
    IO.println("Comparisons: " + uniqueResults[0]);
    IO.println("Moves: " + uniqueResults[1]);
    IO.println("Merge operations: " + uniqueMergeCount); // ADDED
}

/* ==============================================================================
* MERGE SORT ALGORITHM
============================================================================== */


    // ---- MERGE SORT FULL DATASET ----
    public static int[] mergeSort(ArrayList<Wine> wines) {
        int[] counts = new int[2];
        mergeSortRecursive(wines, counts);
        return counts;
    }

    private static void mergeSortRecursive(ArrayList<Wine> wines, int[] counts) {
        // stops if last element
        if (wines.size() <= 1) {
            return;
        }

        // split list in half
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
        mergeSortRecursive(leftHalf, counts);
        mergeSortRecursive(rightHalf, counts);

        // merge back to original
        mergeSortedWineLists(wines, leftHalf, rightHalf, counts);
    }

    private static void mergeSortedWineLists(ArrayList<Wine> wines, ArrayList<Wine> leftHalf, ArrayList<Wine> rightHalf, int[] stats) {
        // count +one merge operation when this method is called
        mergeCount++;

        int leftIndex = 0;
        int rightIndex = 0;
        int currentIndex = 0;

        while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
            stats[0]++; // comparison

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

    // ---- MERGE SORT UNIQUE ALCOHOL VALUES ----
    public static int[] mergeSortUniqueAlcohol(HashSet<Double> uniqueAlcohol) {
        ArrayList<Double> alcoholValues = new ArrayList<>(uniqueAlcohol);
        int[] stats = new int[2];
        mergeSortUniqueRecursive(alcoholValues, stats);
        return stats;
    }

    private static void mergeSortUniqueRecursive(ArrayList<Double> alcoholValues, int[] stats) {
        if (alcoholValues.size() <= 1) {
            return;
        }

        int middleIndex = alcoholValues.size() / 2;
        ArrayList<Double> leftHalf = new ArrayList<>();
        ArrayList<Double> rightHalf = new ArrayList<>();

        for (int i = 0; i < middleIndex; i++) {
            leftHalf.add(alcoholValues.get(i));
        }

        for (int i = middleIndex; i < alcoholValues.size(); i++) {
            rightHalf.add(alcoholValues.get(i));
        }

        mergeSortUniqueRecursive(leftHalf, stats);
        mergeSortUniqueRecursive(rightHalf, stats);

        mergeSortedAlcoholLists(alcoholValues, leftHalf, rightHalf, stats);
    }

    private static void mergeSortedAlcoholLists(ArrayList<Double> alcoholValues, ArrayList<Double> leftHalf, ArrayList<Double> rightHalf, int[] stats) {
        // count +one merge operation when this method is called
        uniqueMergeCount++;

        int leftIndex = 0;
        int rightIndex = 0;
        int currentIndex = 0;

        while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
            stats[0]++; // comparison

            if (leftHalf.get(leftIndex) <= rightHalf.get(rightIndex)) {
                alcoholValues.set(currentIndex, leftHalf.get(leftIndex));
                leftIndex++;
            } else {
                alcoholValues.set(currentIndex, rightHalf.get(rightIndex));
                rightIndex++;
            }

            currentIndex++;
            stats[1]++; // move
        }

        while (leftIndex < leftHalf.size()) {
            alcoholValues.set(currentIndex, leftHalf.get(leftIndex));
            leftIndex++;
            currentIndex++;
            stats[1]++;
        }

        while (rightIndex < rightHalf.size()) {
            alcoholValues.set(currentIndex, rightHalf.get(rightIndex));
            rightIndex++;
            currentIndex++;
            stats[1]++;
        }
    }
}