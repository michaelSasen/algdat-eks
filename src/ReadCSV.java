import java.io.*;
import java.util.*;
/*


public class ReadCSV {

    String filePath = "src/wine+quality";

    public static List<Double> readWineValues(String filePath) {
        List<Double> alcoholValues = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine(); // hopper over header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                String alcohol = values[10].replace("\"", "").trim();
                alcoholValues.add(Double.parseDouble(alcohol));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return alcoholValues;
    }

    public static List<Double> readAllCSVs(String folderPath) {
        List<Double> allValues = new ArrayList<>();

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".csv")) {
                    allValues.addAll(readAlcoholValues(file.getPath()));
                }
            }
        }

        return allValues;
    }
}


 */