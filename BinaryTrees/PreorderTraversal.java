import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode rigth;

    TreeNode(){

    }
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.rigth = right;
    }
}



public class PreorderTraversal {
    
    public List<Integer> preorder(TreeNode root){
        ArrayList<Integer> ls = new ArrayList<>();

        return ls;
    }

    private void preordertraversal(TreeNode node, ArrayList<Integer> ls){
        if(node == null){
            return;
        }
        ls.add(node.val);
        preordertraversal(node.left, ls);
        preordertraversal(node.rigth, ls);
        

    }
}
