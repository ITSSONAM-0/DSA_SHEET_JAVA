package DSA_SHEET_JAVA.TreeMap;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {
    HashMap<String, TreeMap<Integer, String>> hp;

    public TimeMap() {
        hp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!hp.containsKey(key)) {
            hp.put(key, new TreeMap<>());
        }
        TreeMap<Integer, String> submap = hp.get(key);
        submap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!hp.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> submap = hp.get(key);
        Integer prev = submap.floorKey(timestamp);

        if (prev == null) {
            return "";
        }
        return submap.get(prev);
    }
}
