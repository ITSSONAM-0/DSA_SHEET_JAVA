import java.util.*;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){

    }
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



public class PostorderTraversal {
    
    public List<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> ls = new ArrayList<>();
        helperpostorder(root, ls);
        return ls;
    }

    private void helperpostorder(TreeNode node,ArrayList<Integer> ls){
        if(node == null){
            return;
        }
        helperpostorder(node.left, ls);
        helperpostorder(node.right, ls);
        ls.add(node.val);
    }
}
