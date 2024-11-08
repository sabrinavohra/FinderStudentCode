import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import static java.util.Objects.hash;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Sabrina Vohra
 **/

public class Finder {
    private static final String INVALID = "INVALID KEY";
    private HashMap newMap;

    public Finder() {}
    // Method creates a table using the csv file
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // Creates a new map corresponding to the values by reading through the file
        newMap = new HashMap();
        String line = br.readLine();
        while(line != null) {
            // Splits each section of line up by comma
            String[] split = line.split(",");
            newMap.add(split[keyCol], split[valCol]);
            line = br.readLine();
        }
    }

    // Method returns the String associated with the key, if it's in the map
    public String query(String key){
        String value = newMap.get(key);
        // Checks if String is in the map
        if(Objects.equals(value, "INVALID")) {
            return INVALID;
        }
        return value;
    }
}