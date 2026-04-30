package DSA_SHEET_JAVA.BinarySeachTree;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> ls = new ArrayList<>();
        helper(root, ls);
        int start = 0;
        int end = ls.size() - 1;

        while (start < end) {
            int sum = ls.get(start) + ls.get(end);

            if (sum == k) {
                return true;
            }
            if (sum < k) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    public void helper(TreeNode node, ArrayList<Integer> ls) {
        if (node == null) {
            return;
        }
        helper(node.left, ls);
        ls.add(node.val);
        helper(node.right, ls);
    }
}
