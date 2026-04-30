package DSA_SHEET_JAVA.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class Basics {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> tp = new TreeMap<>();

        tp.put(1, 10);
        tp.put(5, 100);
        tp.put(10, 1000);

        System.out.println(tp);

        for (Map.Entry<Integer, Integer> e : tp.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}