package DSA_SHEET_JAVA.BinarySeachTree;

import javax.swing.tree.TreeNode;

public class DeleteaNodeinBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode node = findpre(root.left);
                root.val = node.val;
                root.left = deleteNode(root.left, node.val);
            }

        }
        return root;
    }

    public TreeNode findpre(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
