import java.io.*;
import java.util.ArrayList;

/**
 * This class provides methods to read data from a CSV file and return it as an ArrayList of String arrays.
 * Each String array represents a row in the CSV file, where each element of the array corresponds to a cell in that row.
 * Note: The first line of the CSV file is assumed to be a header and is skipped during reading.
 */
public class CSVReader {

    /** Buffered reader to read the CSV file. */
    private BufferedReader br;

    /**
     * Reads data from the given CSV file and returns it as an ArrayList of String arrays.
     * @param csvFile The FileReader object pointing to the CSV file to be read.
     * @return An ArrayList where each element is a String array representing a row in the CSV file.
     *         Each String in the array corresponds to a cell in that row.
     * @throws IOException If there's an error reading the file.
     */
    public ArrayList<String[]> read(FileReader csvFile) throws IOException {
        ArrayList<String[]> eachLine = new ArrayList<>();

        br = new BufferedReader(csvFile);
        String line;
        // Skip the header line
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] tempArr = line.split(",");
            eachLine.add(tempArr);
        }
        return eachLine;
    }

    /**
     * Closes the buffered reader.
     * This method should be called after reading the CSV file to release the resources.
     * @throws IOException If there's an error closing the buffered reader.
     */
    public void close() throws IOException {
        br.close();
    }
}
