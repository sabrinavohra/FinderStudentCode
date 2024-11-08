import java.util.Objects;
public class HashMap {
    // Initializes default size of table
    private static final int BEG_SIZE = 43;
    private static final int RADIX = 43;
    private int tableSize;
    private String[] map;
    private String[] keyValMap;
    private int numKeys;

    public HashMap() {
        // Initializes tables for values and keys
        map = new String[BEG_SIZE];
        keyValMap = new String[BEG_SIZE];
        tableSize = BEG_SIZE;
        numKeys = 0;
    }

    // Method uses Horner's method to hash a given key
    public int hash(String key) {
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            hash = ((hash * RADIX + key.charAt(i)) % (tableSize));
        }
        return hash;
    }

    // Method returns the value associated with a key
    public String get(String key) {
        // Checks map location for key
        int newHash = hash(key);
        if( keyValMap[newHash] != null && keyValMap[newHash].equals(key)) {
            return map[newHash];
        }
        // Moves through map until key is found
        else {
            while(keyValMap[newHash] != null) {
                if(newHash == tableSize - 1) {
                    newHash = -1;
                }
                if(keyValMap[newHash].equals(key)) {
                    return map[newHash];
                }
                newHash++;
            }
        }
        return "INVALID";
    }

    // Method adds a key and its corresponding value to the map
    public void add(String key, String value) {
        numKeys++;
        // Resizes table, if necessary
        if(numKeys >= (tableSize / 2)) {
            resize();
        }
        // Hashes key and adds to map, if possible
        int hashed = hash(key);
        while(map[hashed] != null) {
            // Increases hashed if the spot is already taken in the map
            hashed++;
            // Makes sure hashed doesn't go out of bounds of the map
            if(hashed == tableSize - 1) {
                hashed = 0;
            }
        }
        // Updates key and value maps with added values
        map[hashed] = value;
        keyValMap[hashed] = key;
    }

    // Method resizes the map when the number of keys reaches greater than half of the map size
    public void resize() {
        tableSize = tableSize * 2;
        // Creates new maps as placeholders to re-hash values
        String[] newMap = new String[tableSize];
        String[] newKeyValMap = new String[tableSize];
        // Re-hashes each value and adds to map--follows the same checks as adding
        for(int i = 0; i < map.length; i++) {
            int newHash = 0;
            if(keyValMap[i] != null) {
                newHash = hash(keyValMap[i]);
                while(newMap[newHash] != null) {
                    newHash++;
                    if(newHash == newMap.length - 1) {
                        newHash = 0;
                    }
                }
            }
            // Adds each re-hashed value to the new maps
            newMap[newHash] = map[i];
            newKeyValMap[newHash] = keyValMap[i];
        }
        // Replaces instance variable maps with the updated ones
        map = newMap;
        keyValMap = newKeyValMap;
    }
}
