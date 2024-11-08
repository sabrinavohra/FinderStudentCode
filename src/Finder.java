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
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        newMap = new HashMap();
        String line = br.readLine();
        while(line != null) {
            String[] split = line.split(",");
            newMap.add(split[keyCol], split[valCol]);
            line = br.readLine();
        }
    }

    public String query(String key){
        // TODO: Complete the query() function!
        String returns = newMap.get(key);
        if(Objects.equals(returns, "INVALID")) {
            return INVALID;
        }
        return returns;
    }
}