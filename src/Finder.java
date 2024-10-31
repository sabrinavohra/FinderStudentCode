import java.io.BufferedReader;
import java.io.IOException;
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
    // ASCII for all lower and uppercase letters
    private static final int RADIX = 123;
    // big prime
    private static final int PRIME = 506683;

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!

        // Map
        int map[] = new int[];
        // For each space in array / each key:
            // Create hash and assign it (make the key traceable)

        // Assign index by hashing (find index depending on value at [keyCol][valCol]) to original value
        for(int i = 0; i < keyCol; i++) {
            // Use hashes as the input for the Array
            map[i] = keyCol;
        }

        // Create map for each new added key with its value attached--use Array as map?
            // Create hash map based on key and corresponding value--index of map leads to value?--more efficient Array
            // because the values will be too large to store in this way? create smaller hashes?
            // How to organize map? Values cannot be too big and must be easily recognizable
        // Every time adding, search map for that key first and make sure not match before adding to map at correct spot
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        int hashKey = hash(key);
        for(int i = 0; i < map.length; i++) {
            // Compare each hashed value in map to key's hashed value
            if(map[i] == hashKey) {
                return key;
            }
        }
        // Look through map to find any possible matches--make sure map makes value easy to find with access to key
        // If not in map / hash map:
            // return invalid
        return INVALID;
    }

    // Basic hash method
    public int hash(String key) {
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            hash =(hash * RADIX + key.charAt(i) % PRIME);
        }
        return hash;
    }
}