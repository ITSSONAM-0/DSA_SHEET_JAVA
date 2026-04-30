package DSA_SHEET_JAVA.BinarySeachTree;

import javax.swing.tree.TreeNode;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        TreeNode ans = null;
        if (val < root.val) {
            ans = searchBST(root.left, val);
        } else {
            ans = searchBST(root.right, val);
        }
        return ans;
    }

}