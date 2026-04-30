package DSA_SHEET_JAVA.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(0);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int room = q.poll();

            for (int key : rooms.get(room)) {
                if (!hs.contains(key)) {
                    hs.add(key);
                    q.add(key);
                }
            }
        }
        return rooms.size() == hs.size();
    }
}
