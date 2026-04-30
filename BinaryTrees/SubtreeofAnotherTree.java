public class SubtreeofAnotherTree {
     public String postorder(TreeNode node){
        if(node == null){
            return "null";
        }
        StringBuilder sb = new StringBuilder("^");
        sb.append(node.val);
        sb.append(postorder(node.left));
        sb.append(postorder(node.right));

        return sb.toString();
    }




    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        String fulltree = postorder(root);
        String subtree = postorder(subRoot);

        if(!fulltree.contains(subtree)){
            return false;
        }
        return true;
    }
}
