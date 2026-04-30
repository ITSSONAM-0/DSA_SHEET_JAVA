public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode leftchild = lowestCommonAncestor(root.left,p,q);
        TreeNode rightchild = lowestCommonAncestor(root.right,p,q);

        if(leftchild == null){
            return rightchild;
        }else if(rightchild == null){
            return leftchild;
        }else if(leftchild == null && rightchild == null){
            return root;
        }
        return root;
    }
}
