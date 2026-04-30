package DSA_SHEET_JAVA.HashMap.Medium;

import java.util.*;

class CanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> hp = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            hp.put(target[i], hp.getOrDefault(target[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!hp.containsKey(arr[i])) {
                return false;
            }
            hp.put(arr[i], hp.get(arr[i]) - 1);
            if (hp.get(arr[i]) == 0) {
                hp.remove(arr[i]);
            }
        }

        if (hp.size() == 0) {
            return true;
        }
        return false;
    }
}