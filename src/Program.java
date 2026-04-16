void main() {

    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
        IO.println("=== SORTING-PROGRAM ===");
        IO.println("1. bubble");
        IO.println("2. insertion");
        IO.println("3. merge");
        IO.println("4. quick");
        IO.println("5. run all");
        IO.println("6. quit");
        IO.print("choose one: ");

        int choice = scanner.nextInt();
        IO.println("");

        switch (choice) {
            case 1:
                SortTest.runBubbleSort();
                break;

            case 2:
                SortTest.runInsertionSort();
                break;

            case 3:
                SortTest.runMergeSort();
                break;

            case 4:
                SortTest.runAllQuickSorts();
                break;

            case 5:
                SortTest.runAllSortnigAlgorithms();
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

