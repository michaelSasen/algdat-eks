import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVImport {
    public static void main(String[] args) {
        fileReader();
    }

    public static ArrayList<Wine> fileReader() {

        // CSV file path
        String[] filePaths = {
                "src/wine+quality/winequality-red.csv",
                "src/wine+quality/winequality-white.csv"};

        // List to store CSV elements
        ArrayList<Wine> wines = new ArrayList<>();
    for(String filePath : filePaths) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] row = line.split(";");

                Wine wine = new Wine(
                        Double.parseDouble(row[0]),
                        Double.parseDouble(row[1]),
                        Double.parseDouble(row[2]),
                        Double.parseDouble(row[3]),
                        Double.parseDouble(row[4]),
                        Double.parseDouble(row[5]),
                        Double.parseDouble(row[6]),
                        Double.parseDouble(row[7]),
                        Double.parseDouble(row[8]),
                        Double.parseDouble(row[9]),
                        Double.parseDouble(row[10]),
                        Integer.parseInt(row[11])
                );

                wines.add(wine);

            }
        } catch (IOException e) {
            System.err.println("Error reading the file " + filePath);
        }
            }
        return wines;
        }
    }


