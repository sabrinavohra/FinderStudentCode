import java.util.Objects;
public class HashMap {
   private static final int BEG_SIZE = 16;
   private static final int RADIX = 257;
   private int tableSize;
   private String[] map;
   private String[] keyValMap;
   private int numKeys;

    public HashMap() {
        map = new String[BEG_SIZE];
        keyValMap = new String[BEG_SIZE];
        tableSize = BEG_SIZE;
        numKeys = 0;
    }

    public int hash(String key) {
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            hash =((hash * RADIX + key.charAt(i)) % tableSize);
        }
        return hash;
    }

    public String get(String key) {
        for(int i = 0; i < keyValMap.length; i++) {
            if(keyValMap[i] != null) {
                if(keyValMap[i].equals(key)) {
                    return map[i];
                }
            }
        }
        return "INVALID";

    }

    public void add(String key, String value) {
        numKeys++;
        if(numKeys > (tableSize/2)) {
            resize();
        }
        int hashed = hash(key);
        while(map[hashed] != null) {
            hashed++;
            if(hashed == tableSize) {
                hashed = 0;
            }
        }
        map[hashed] = value;
        keyValMap[hashed] = key;
    }

    // Issue with resize and not accounting for keyValMap??
    public void resize() {
        tableSize = tableSize * 2;
        String[] newMap = new String[tableSize];
        String[] newKeyValMap = new String[tableSize];
        for(int i = 0; i < map.length; i++) {
            int newHash = 0;
            if(keyValMap[i] != null) {
                newHash = hash(keyValMap[i]);
                while(newMap[newHash] != null) {
                    newHash++;
                    if(newHash == newMap.length) {
                        newHash = 0;
                    }
                }
            }
            newMap[newHash] = map[i];
            newKeyValMap[newHash] = keyValMap[i];
        }
        map = newMap;
        keyValMap = newKeyValMap;
    }
}
