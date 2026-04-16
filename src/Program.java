void main() {

    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
        IO.println("=== SORTING-PROGRAM ===");
        IO.println("1. full dataset");
        IO.println("2. unique dataset");
        IO.println("3. run all");
        IO.println("4. quit");
        IO.print("choose one: ");

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

