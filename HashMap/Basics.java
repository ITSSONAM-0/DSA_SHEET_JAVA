package DSA_SHEET_JAVA.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Basics {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Insertion
        map.put("India", 140);
        map.put("China", 120);
        map.put("Usa", 30);

        System.out.println(map);

        map.put("China", 50);
        System.out.println(map);

        // Search

        if (map.containsKey("India")) {
            System.out.println("True");
        }

        // Accessing values
        int ans = map.get("India");
        System.out.println(ans);

        // Iteration
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        // Removing
        map.remove("Usa");
        System.out.println(map);

    }
}
