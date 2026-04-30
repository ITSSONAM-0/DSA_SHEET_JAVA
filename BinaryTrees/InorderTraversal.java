import java.util.*;

 class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    //when node are empty
    TreeNode(){

    }

    // only root has value
    TreeNode(int val){
        this.val = val;
    }

    //complete Binary Tree
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}





public class InorderTraversal {
    
    public List<Integer> indorder(TreeNode root){
        ArrayList<Integer> ls = new ArrayList<>();
        helperinorder(root, ls);
        return ls;
    }

    private void helperinorder(TreeNode node, ArrayList<Integer> ls){
        if(node == null){
            return;
        }

        helperinorder(node.left, ls);
        ls.add(node.val);
        helperinorder(node.right, ls);
    }
}
