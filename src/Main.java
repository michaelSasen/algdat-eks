/* void main() {

    //CSV-filene mappa
    String folderPath = "src/wine+quality";

    // leser alle filene i mappa
    List<Double> originalList = CSVImport.readAllCSVs(folderPath);

    //en for optimalisert og en for ikke optimalisert
    List<Double> list1 = new ArrayList<>(originalList);
    List<Double> list2 = new ArrayList<>(originalList);

    //unødvendig egt
    IO.println("Antall alcohol-verdier: " + originalList.size());

    // Ikke-optimalisert
    BubbleSort.bubbleSortNonOptimized(list1);

    // Optimalisert
    BubbleSort.bubbleSortOptimized(list2);


    // bingbong
    IO.println("\nIkke-optimalisert sortert liste:");
    IO.println(list1);

    IO.println("\nOptimalisert sortert liste:");
    IO.println(list2);

}

 */
