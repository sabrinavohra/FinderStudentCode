import java.util.Objects;

public class HashMap {
   private static final int BEG_SIZE = 16;
   private static final int RADIX = 123;
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
            if(keyValMap[i].equals(key)) {
                return keyValMap[i];
            }
        }
        return "INVALID";

    }

    public void add(String key, String value) {
        numKeys++;
        resize();
        int hashed = hash(key);
        while(!map[hashed].isEmpty()) {
            hashed++;
        }
        map[hashed] = value;
        keyValMap[hashed] = key;
    }

    // Issue with resize and not accounting for keyValMap??
    public void resize() {
        String[] newMap = new String[0];
        String[] newKeyValMap = new String[0];
        if(numKeys > (tableSize / 2)) {
            tableSize = tableSize * 2;
            newMap = new String[tableSize];
            newKeyValMap = new String[tableSize];
            for(int i = 0; i < map.length; i++) {
                int newHash = hash(keyValMap[i]);
                while(newMap[newHash] != null) {
                    newHash++;
                }
                newMap[newHash] = map[i];
            }
            for(int i = 0; i < keyValMap.length; i++) {
                int newHash = hash(keyValMap[i]);
                while(newKeyValMap[newHash] != null) {
                    newHash++;
                }
                newKeyValMap[newHash] = keyValMap[i];
            }
        }
        map = newMap;
        keyValMap = newKeyValMap;
    }
}
