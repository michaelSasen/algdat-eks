void main() {

    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
        IO.println("=== SORTING-PROGRAM ===");
        IO.println("1. Run Full Dataset Benchmark");
        IO.println("2. Run Unique Dataset Benchmark");
        IO.println("3. Run Both Datasets");
        IO.println("4. Quit");
        IO.println("Enter action: ");

        int choice = scanner.nextInt();
        IO.println("");

        switch (choice) {
            case 1:
                SortTest.runAllFullDatasetTests();
                break;

            case 2:
                SortTest.runAllUniqueDatasetTests();
                break;

            case 3:
                SortTest.runAllSortingAlgorithms();
                break;

            case 4:
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

