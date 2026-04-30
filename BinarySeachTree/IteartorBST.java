package DSA_SHEET_JAVA.BinarySeachTree;

import java.util.Stack;

import javax.swing.tree.TreeNode;

public class IteartorBST {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();

        TreeNode node = root;
        while(node != null){
            st.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = st.pop();
        int val = node.val;
        node = node.right;

        while (node != null) {
            st.push(node);
            node = node.left;
        }
        return val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
