import java.util.*;

public class Main {
    public static void main(String[] args) {

        //CSV-filene mappa
        String folderPath = "src/wine+quality";

        // leser alle filene i mappa
        List<Double> originalList = ReadCSV.readAllCSVs(folderPath);

        //en for optimalisert og en for ikke optimalisert
        List<Double> list1 = new ArrayList<>(originalList);
        List<Double> list2 = new ArrayList<>(originalList);

        //unødvendig egt
        System.out.println("Antall alcohol-verdier: " + originalList.size());

        // Ikke-optimalisert
        BubbleSort.bubbleSortNonOptimized(list1);

        // Optimalisert
        BubbleSort.bubbleSortOptimized(list2);


        // bingbong
        System.out.println("\nIkke-optimalisert sortert liste:");
        System.out.println(list1);

        System.out.println("\nOptimalisert sortert liste:");
        System.out.println(list2);

    }
}
