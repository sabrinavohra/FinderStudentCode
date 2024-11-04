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
    private static final int BEG_SIZE = 100;
    private int[] map = new int[BEG_SIZE];
    private int current = 0;
    private int mapSize = 100;
    public Finder() {}


    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        current++;
        if(current > mapSize/2) {
            mapSize = mapSize * 2;
        }
        map[current] = keyCol;
    }

    public String query(String key){
        // TODO: Complete the query() function!
        int unhash = 0;
        for(int i = 0; i < key.length(); i++) {
            unhash = (unhash / RADIX - key.charAt(i) % PRIME);
        }
        for(int i = 0; i < mapSize; i++) {
            if(unhash == map[i]) {
                return map[i];
            }
        }
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