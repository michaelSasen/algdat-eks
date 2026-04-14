import java.util.ArrayList;
import java.util.Collections;

/* ==============================================================================
* TASK 4: QUICK SORT ALGORITHM PIVOT MEDIAN
* code inspiration source: Geeksforgeeks
* fetched: 25/03-26
*
============================================================================== */

 public class QuickSortMedianPivot {
    static int comparisons = 0;

    public static void sort(ArrayList<Wine> wines) {
        comparisons = 0;
        if (wines != null && !wines.isEmpty()) {
            quickSort(wines, 0, wines.size() - 1);
        }
    }

    public static void sortUnique(ArrayList<Double> alcohol) {
        comparisons = 0;
        if (alcohol != null && !alcohol.isEmpty()) {
            quickSortUnique(alcohol, 0, alcohol.size() - 1);
        }
    }

 /*

    static int comparisons = 0;

    void main() {
        // full dataset
        ArrayList<Wine> wines = CSVImport.fileReader();
        // hashset with only unique alcohol values
        HashSet<Double> uniqueAlcohol = CSVImport.uniqueAlcoholValues(wines);
        // converting hashset to arraylist
        ArrayList<Double> alcohol = new ArrayList<>(uniqueAlcohol);

        Timer timer = new Timer();
        timer.start();
        quickSort(wines, 0, wines.size() - 1);
        timer.end();

        IO.println("Full dataset: ");
        IO.println("Time: " + timer.getTime());
        IO.println("Comparisons: " + comparisons);

        IO.println("");
        // Reset comparisons
        comparisons = 0;

        timer.start();
        quickSortUnique(alcohol, 0, alcohol.size() - 1);
        timer.end();

        IO.println("Unique alcohol values: ");
        IO.println("Time: " + timer.getTime());
        IO.println("Comparisons: " + comparisons);
    }

  */
/* ==============================================================================
* QUICK SORT ALGORITHM PIVOT MEDIAN OF THREE
============================================================================== */

    public static int medianOfThree(ArrayList<Wine> wines, int low, int high) {
        int mid = low + (high - low) / 2;

        double medLow = wines.get(low).alcohol();
        double medMid = wines.get(mid).alcohol();
        double medHigh = wines.get(high).alcohol();

        if (medLow > medMid) {
            if (medMid > medHigh) return mid;
            else if (medLow > medHigh) return high;
            else return low;
        } else {
            if (medLow > medHigh) return low;
            else if (medMid > medHigh) return high;
            else return mid;
        }
    }

    public static void quickSort(ArrayList<Wine> wines, int low, int high) {
        if (low < high) {
            int pivot = partition(wines, low, high);
            // Recursion for smaller elements and greater or equal
            quickSort(wines, low, pivot - 1);
            quickSort(wines, pivot + 1, high);
        }
    }

    public static int partition(ArrayList<Wine> wines, int low, int high) {
        // Get median og three pivot index
        int medianIndex = medianOfThree(wines, low, high);
        // Random in current as the pivot
        Collections.swap(wines, medianIndex, high);
        double pivot = wines.get(high).alcohol();

        int left = low - 1;
        for (int right = low; right < high; right++) {
            comparisons++;
            if (wines.get(right).alcohol() < pivot) {
                left++;
                Collections.swap(wines, left, right);
            }
        }
        Collections.swap(wines, left + 1, high);
        return left + 1;
    }
// ----QUICK SORT RANDOM PIVOT WITH UNIQUE ALCOHOL VALUES----

    public static int medianOfThreeUnique(ArrayList<Double> alcohol, int low, int high) {
        int mid = low + (high - low) / 2;

        double medLow = alcohol.get(low);
        double medMid = alcohol.get(mid);
        double medHigh = alcohol.get(high);

        if (medLow > medMid) {
            if (medMid > medHigh) return mid;
            else if (medLow > medHigh) return high;
            else return low;
        } else {
            if (medLow > medHigh) return low;
            else if (medMid > medHigh) return high;
            else return mid;
        }
    }

    public static void quickSortUnique(ArrayList<Double> alcohol, int low, int high) {
        if (low < high) {
            int pivot = partitionUnique(alcohol, low, high);

            // Recursion for smaller elements and greater or equal
            quickSortUnique(alcohol, low, pivot - 1);
            quickSortUnique(alcohol, pivot + 1, high);
        }
    }

    public static int partitionUnique(ArrayList<Double> alcohol, int low, int high) {
        // Get median og three pivot index
        int medianIndex = medianOfThreeUnique(alcohol, low, high);
        // Random in current as the pivot
        Collections.swap(alcohol, medianIndex, high);
        // First in current as the pivot
        double pivot = alcohol.get(high);
        int left = low - 1;
        for (int right = low; right < high; right++) {
            comparisons++;
            if (alcohol.get(right) < pivot) {
                left++;
                Collections.swap(alcohol, left, right);
            }
        }
        Collections.swap(alcohol, left + 1, high);
        return left + 1;
    }
}
