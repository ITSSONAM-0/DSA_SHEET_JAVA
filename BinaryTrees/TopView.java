import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.w3c.dom.Node;

class CustomNode {
    Node node;
    int col;

    CustomNode(Node node, int col) {
        this.node = node;
        this.col = col;
    }
}

public class TopView {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }

        Queue<CustomNode> q = new LinkedList<>();
        q.offer(new CustomNode(root, 0));
        TreeMap<Integer, Integer> tp = new TreeMap<>();

        while (!q.isEmpty()) {
            CustomNode customnode = q.poll();
            Node node = customnode.node;
            int col = customnode.col;

            // Only add first node seen at this column
            if (!tp.containsKey(col)) {
                tp.put(col, node.data);
            }

            if (node.left != null) {
                q.offer(new CustomNode(node.left, col - 1));
            }
            if (node.right != null) {
                q.offer(new CustomNode(node.right, col + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : tp.entrySet()) {
            ls.add(entry.getValue());
        }

        return ls;
    } 
}
