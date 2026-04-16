import java.util.ArrayList;
import java.util.HashSet;

/* ==============================================================================
* TASK 3: MERGE SORT ALGORITHM
* code inspiration source: LO 3_SortingAlgorithms.pptx by Prof. Dr. Rashmi Gupta
* fetched: 26/03/2026
* Time Complexity: O(n log n) all cases - divide and conquer pattern
============================================================================== */

public class MergeSort {
    // merge counters for operations
    public static int mergeCount = 0;
    public static int uniqueMergeCount = 0;

/* ==============================================================================
* MERGE SORT ALGORITHM
============================================================================== */

    // Time Complexity: O(n log n) - divide and conquer pattern
    public static void mergeSort(ArrayList<Wine> wines) {
        mergeSortRecursive(wines);
    }

    // Time Complexity: O(n log n) - divides array in half recursively, merges in O(n)
    private static void mergeSortRecursive(ArrayList<Wine> wines) {
        // Base case: array of size 0 or 1 is already sorted
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
        mergeSortRecursive(leftHalf);
        mergeSortRecursive(rightHalf);

        // merge back to original
        mergeSortedLists(wines, leftHalf, rightHalf);
    }

    // Time Complexity: O(n) - single pass to merge two sorted halves
    private static void mergeSortedLists(ArrayList<Wine> wines, ArrayList<Wine> leftHalf, ArrayList<Wine> rightHalf) {
        // increment merge operation counter: tracks how many times merge is performed
        mergeCount++;

        int leftIndex = 0;
        int rightIndex = 0;
        int currentIndex = 0;

        while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
            if (leftHalf.get(leftIndex).alcohol() <= rightHalf.get(rightIndex).alcohol()) {
                wines.set(currentIndex, leftHalf.get(leftIndex));
                leftIndex++;
            } else {
                wines.set(currentIndex, rightHalf.get(rightIndex));
                rightIndex++;
            }

            currentIndex++;
        }

        while (leftIndex < leftHalf.size()) {
            wines.set(currentIndex, leftHalf.get(leftIndex));
            leftIndex++;
            currentIndex++;
        }

        while (rightIndex < rightHalf.size()) {
            wines.set(currentIndex, rightHalf.get(rightIndex));
            rightIndex++;
            currentIndex++;
        }
    }

    /* ==============================================================================
    * MERGE SORT ALGORITHM UNIQUE
    ============================================================================== */

    // Time Complexity: O(n log n) - divide and conquer pattern
    public static void mergeSortUnique(HashSet<Double> uniqueAlcohol) {
        ArrayList<Double> alcoholValues = new ArrayList<>(uniqueAlcohol);
        mergeSortUniqueRecursive(alcoholValues);
    }

    // Time Complexity: O(n log n) - divides array in half recursively, merges in O(n)
    private static void mergeSortUniqueRecursive(ArrayList<Double> alcoholValues) {
        // Base case: array of size 0 or 1 is already sorted
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

        mergeSortUniqueRecursive(leftHalf);
        mergeSortUniqueRecursive(rightHalf);

        mergeSortedListsUnique(alcoholValues, leftHalf, rightHalf);
    }

    // Time Complexity: O(n) - single pass to merge two sorted halves
    private static void mergeSortedListsUnique(ArrayList<Double> alcoholValues, ArrayList<Double> leftHalf, ArrayList<Double> rightHalf) {
        // increment merge operation counter: tracks how many times merge is performed
        uniqueMergeCount++;

        int leftIndex = 0;
        int rightIndex = 0;
        int currentIndex = 0;

        while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
            if (leftHalf.get(leftIndex) <= rightHalf.get(rightIndex)) {
                alcoholValues.set(currentIndex, leftHalf.get(leftIndex));
                leftIndex++;
            } else {
                alcoholValues.set(currentIndex, rightHalf.get(rightIndex));
                rightIndex++;
            }

            currentIndex++;
        }

        while (leftIndex < leftHalf.size()) {
            alcoholValues.set(currentIndex, leftHalf.get(leftIndex));
            leftIndex++;
            currentIndex++;
        }

        while (rightIndex < rightHalf.size()) {
            alcoholValues.set(currentIndex, rightHalf.get(rightIndex));
            rightIndex++;
            currentIndex++;
        }
    }
}