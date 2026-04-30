import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> leftTree = new LinkedList<>();
        Queue<TreeNode> rightTree = new LinkedList<>();

        leftTree.add(root.left);
        rightTree.add(root.right);

        while(!leftTree.isEmpty() && !rightTree.isEmpty()){
            TreeNode leftnode = leftTree.remove();
            TreeNode rightnode = rightTree.remove();

            if(leftnode == null && rightnode == null){
                continue;
            }
            if(leftnode == null || rightnode == null){
                return false;
            }
            if(leftnode.val != rightnode.val){
                return false;
            }

            leftTree.add(leftnode.left);
            leftTree.add(leftnode.right);
            rightTree.add(rightnode.right);
            rightTree.add(rightnode.left);
        }
        return true;
    }
}
