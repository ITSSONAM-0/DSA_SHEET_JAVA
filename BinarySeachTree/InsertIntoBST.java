package DSA_SHEET_JAVA.BinarySeachTree;

import javax.swing.tree.TreeNode;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        TreeNode temp = root;

        while (temp != null) {

            if (val < temp.val) {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }
}
