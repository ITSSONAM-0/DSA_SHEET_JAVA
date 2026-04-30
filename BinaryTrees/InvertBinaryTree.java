import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        final Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            final TreeNode node = q.remove();

           final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
        return root;


    }
}
