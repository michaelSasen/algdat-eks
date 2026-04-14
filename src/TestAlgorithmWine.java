void main() {
    ArrayList<Wine> dataset = CSVImport.fileReader();
    ArrayList<Double> uniqueAlcohol = new ArrayList<>(CSVImport.uniqueAlcoholValues(dataset));

    // =========================
    // WARM-UP
    // =========================
    runWarmUp(dataset, 10, "Bubble Sort Non-Optimized", BubbleSortNonOptimized::bubbleSortNonOptimized);
    runWarmUp(dataset, 10, "Bubble Sort Optimized", BubbleSortOptimized::bubbleSortOptimized);

    runWarmUp(dataset, 10, "Insertion Sort", InsertionSort::insertionSort);

    runMergeWarmUp(dataset, 10, "Merge Sort");

    runWarmUp(dataset, 10, "Quick Sort First Pivot", QuickSortFirstPivot::sort);
    runWarmUp(dataset, 10, "Quick Sort Last Pivot", QuickSortLastPivot::sort);
    runWarmUp(dataset, 10, "Quick Sort Median Pivot", QuickSortMedianPivot::sort);
    runWarmUp(dataset, 10, "Quick Sort Random Pivot", QuickSortRandomPivot::sort);

    // =========================
    // FULL DATASET TESTS
    // =========================
    testWineAlgorithm(dataset, true, 100, "Bubble Sort Non-Optimized", BubbleSortNonOptimized::bubbleSortNonOptimized);
    testWineAlgorithm(dataset, true, 100, "Bubble Sort Optimized", BubbleSortOptimized::bubbleSortOptimized);

    testWineAlgorithm(dataset, true, 100, "Insertion Sort", InsertionSort::insertionSort);

    testMergeSort(dataset, 100);

    testWineAlgorithm(dataset, true, 100, "Quick Sort First Pivot", QuickSortFirstPivot::sort);
    testWineAlgorithm(dataset, true, 100, "Quick Sort Last Pivot", QuickSortLastPivot::sort);
    testWineAlgorithm(dataset, true, 100, "Quick Sort Median Pivot", QuickSortMedianPivot::sort);
    testWineAlgorithm(dataset, true, 100, "Quick Sort Random Pivot", QuickSortRandomPivot::sort);

    // =========================
    // UNIQUE ALCOHOL VALUE TESTS
    // =========================
    testUniqueAlgorithm(uniqueAlcohol, true, 100, "Bubble Sort Non-Optimized Unique", BubbleSortNonOptimized::bubbleSortNonOptimizedUnique);
    testUniqueAlgorithm(uniqueAlcohol, true, 100, "Bubble Sort Optimized Unique", BubbleSortOptimized::bubbleSortOptimizedUnique);

    testUniqueAlgorithm(uniqueAlcohol, true, 100, "Insertion Sort Unique", InsertionSort::insertionSortUniqueAlcohol);

    testMergeSortUnique(uniqueAlcohol, 100);

    testUniqueAlgorithm(uniqueAlcohol, true, 100, "Quick Sort First Pivot Unique", QuickSortFirstPivot::sortUnique);
    testUniqueAlgorithm(uniqueAlcohol, true, 100, "Quick Sort Last Pivot Unique", QuickSortLastPivot::sortUnique);
    testUniqueAlgorithm(uniqueAlcohol, true, 100, "Quick Sort Median Pivot Unique", QuickSortMedianPivot::sortUnique);
    testUniqueAlgorithm(uniqueAlcohol, true, 100, "Quick Sort Random Pivot Unique", QuickSortRandomPivot::sortUnique);
}

public static void runWarmUp(ArrayList<Wine> dataset, int warmUpLength, String name,
                             Consumer<ArrayList<Wine>> algorithm) {
    IO.println("*** Starting warm-up of JVM with " + name + " ***");

    for (int i = 0; i < warmUpLength; i++) {
        ArrayList<Wine> copiedData = new ArrayList<>(dataset);
        algorithm.accept(copiedData);
    }

    IO.println("*** Finished warm-up of JVM with " + name + " ***");
}

public static void runMergeWarmUp(ArrayList<Wine> dataset, int warmUpLength, String name) {
    IO.println("*** Starting warm-up of JVM with " + name + " ***");

    for (int i = 0; i < warmUpLength; i++) {
        ArrayList<Wine> copiedData = new ArrayList<>(dataset);
        MergeSort.mergeCount = 0;
        MergeSort.mergeSort(copiedData);
    }

    IO.println("*** Finished warm-up of JVM with " + name + " ***");
}

public static void testWineAlgorithm(ArrayList<Wine> dataset, boolean shuffle, int repetitions,
                                     String name, Consumer<ArrayList<Wine>> algorithm) {
    IO.println("\n*** Starting test of " + name + " ***");

    long totalTime = 0;

    for (int i = 0; i < repetitions; i++) {
        ArrayList<Wine> copiedData = new ArrayList<>(dataset);

        if (shuffle) {
            Collections.shuffle(copiedData);
        }

        Timer timer = new Timer();
        timer.start();
        algorithm.accept(copiedData);
        timer.end();

        totalTime += timer.getTime();
    }

    printResults(name, repetitions, shuffle, totalTime);
}

public static void testUniqueAlgorithm(ArrayList<Double> dataset, boolean shuffle, int repetitions,
                                       String name, Consumer<ArrayList<Double>> algorithm) {
    IO.println("\n*** Starting test of " + name + " ***");

    long totalTime = 0;

    for (int i = 0; i < repetitions; i++) {
        ArrayList<Double> copiedData = new ArrayList<>(dataset);

        if (shuffle) {
            Collections.shuffle(copiedData);
        }

        Timer timer = new Timer();
        timer.start();
        algorithm.accept(copiedData);
        timer.end();

        totalTime += timer.getTime();
    }

    printResults(name, repetitions, shuffle, totalTime);
}

public static void testMergeSort(ArrayList<Wine> dataset, int repetitions) {
    IO.println("\n*** Starting test of Merge Sort ***");

    long totalTime = 0;

    for (int i = 0; i < repetitions; i++) {
        ArrayList<Wine> copiedData = new ArrayList<>(dataset);
        Collections.shuffle(copiedData);

        MergeSort.mergeCount = 0;

        Timer timer = new Timer();
        timer.start();
        MergeSort.mergeSort(copiedData);
        timer.end();

        totalTime += timer.getTime();
    }

    printResults("Merge Sort", repetitions, true, totalTime);
}

public static void testMergeSortUnique(ArrayList<Double> dataset, int repetitions) {
    IO.println("\n*** Starting test of Merge Sort Unique ***");

    long totalTime = 0;

    for (int i = 0; i < repetitions; i++) {
        ArrayList<Double> copiedData = new ArrayList<>(dataset);
        Collections.shuffle(copiedData);

        HashSet<Double> uniqueSet = new HashSet<>(copiedData);

        MergeSort.uniqueMergeCount = 0;

        Timer timer = new Timer();
        timer.start();
        MergeSort.mergeSortUniqueAlcohol(uniqueSet);
        timer.end();

        totalTime += timer.getTime();
    }

    printResults("Merge Sort Unique", repetitions, true, totalTime);
}

public static void printResults(String name, int repetitions, boolean shuffle, long totalTimeNano) {
    double totalMs = totalTimeNano / 1_000_000.0;
    double totalSec = totalTimeNano / 1_000_000_000.0;
    long avgNano = totalTimeNano / repetitions;
    double avgMs = avgNano / 1_000_000.0;
    double avgSec = avgNano / 1_000_000_000.0;

    if (shuffle) {
        System.out.printf("Total runtime for %d tests of %s when data is shuffled: %.4f seconds (%d ns)%n",
                repetitions, name, totalSec, totalTimeNano);
    } else {
        System.out.printf("Total runtime for %d tests of %s when data is not shuffled: %.4f seconds (%d ns)%n",
                repetitions, name, totalSec, totalTimeNano);
    }

    System.out.printf("Average runtime: %d ns (%.4f ms / %.6f s)%n", avgNano, avgMs, avgSec);
    System.out.printf("Total runtime in ms: %.4f ms%n", totalMs);
}