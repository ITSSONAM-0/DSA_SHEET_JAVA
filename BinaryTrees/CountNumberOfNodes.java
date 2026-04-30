public class CountNumberOfNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftdep = countNodes(root.left);
        int rightdep = countNodes(root.right);
        return (1+leftdep+rightdep);
    }
}
