package DSA_SHEET_JAVA.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class Basics {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // Insering elements
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        System.out.println(set);

        // contains

        if (set.contains(3)) {
            System.out.println("true");
        }

        if (!set.contains(6)) {
            System.out.println("true");
        }

        // Delete
        set.remove(2);
        System.out.println(set);

        // size
        int ans = set.size();
        System.out.println(ans);

        // Iterator like travesring

        Iterator it = set.iterator();

        // hasNext() check where there is next element
        // next() is like i accesing sigle element in set

        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
