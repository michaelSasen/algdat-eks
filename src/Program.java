void main() {

    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
        IO.println("=== SORTING-PROGRAM ===");
        IO.println("1. Run Full Dataset Benchmark (Sorted)");
        IO.println("2. Run Full Dataset Benchmark (Shuffled)");
        IO.println("3. Run Unique Dataset Benchmark (Sorted)");
        IO.println("4. Run Unique Dataset Benchmark (Shuffled)");
        IO.println("5. Run Both Datasets (Sorted & Shuffled)");
        IO.println("6. Quit");
        IO.println("Enter action: ");

        int choice = scanner.nextInt();
        IO.println("");

        switch (choice) {
            case 1:
                RunBenchmark.runAllFullDatasetTests();
                break;

            case 2:
                RunBenchmark.runAllFullDatasetTestsShuffled();
                break;

            case 3:
                RunBenchmark.runAllUniqueDatasetTests();
                break;

            case 4:
                RunBenchmark.runAllUniqueDatasetTestsShuffled();
                break;

            case 5:
                RunBenchmark.runAllSortingAlgorithms();
                break;

            case 6:
                running = false;
                IO.println("Program exit.");
                break;

            default:
                IO.println("Invalid input, try again..");
                IO.println("");
        }
    }

    scanner.close();
}

