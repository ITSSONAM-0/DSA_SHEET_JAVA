import java.util.ArrayList;

public class ValidateBinaryTree {
    public void helper(TreeNode node, ArrayList<Integer> ls){
        if(node == null){
            return;
        }
        helper(node.left,ls);
        ls.add(node.val);
        helper(node.right,ls);

    }


    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();

        boolean isBST = true;
        helper(root,ls);
        int prev = ls.get(0);

        for(int i=1;i<ls.size();i++){
            if(ls.get(i) <= prev){
                isBST = false;
            }
            prev = ls.get(i);
        }
        return isBST;
    }
}
