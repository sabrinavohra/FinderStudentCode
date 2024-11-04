public class HashMap {
   private static final int BEG_SIZE = 13;
   private static final int RADIX = 123;
   private int tableSize;
   private String[] map;
   private String[] keyValMap;
   private int numKeys;
   private String[] keys;
   private String[] values;

    public HashMap() {
        map = new String[BEG_SIZE];
        keyValMap = new String[BEG_SIZE];
        tableSize = BEG_SIZE;
        numKeys = 0;
    }

    public int hash(String key) {
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            hash =(hash * RADIX + key.charAt(i) % tableSize);
        }
        return hash;
    }

    public String get(String key) {
        int unhash = hash(key);
        return map[unhash];
    }

    public void add(String key, String value) {
        numKeys++;
        resize();
        int hashed = hash(key);
        while(map[hashed] != null) {
            hashed++;
        }
        map[hashed] = value;
        keyValMap[hashed] = key;
    }

    public void resize() {
        String[] newMap = new String[0];
        if(numKeys > (tableSize / 2)) {
            tableSize = tableSize * 2;
            newMap = new String[tableSize];
            for(int i = 0; i < map.length; i++) {
                int newHash = hash(keyValMap[i]);
                while(newMap[newHash] != null) {
                    newHash++;
                }
                newMap[newHash] = map[i];
            }
        }
        map = newMap;
    }
}
