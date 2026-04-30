class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val,TreeNode left, TreeNode right){
        this.val = val;
        this.left =left;
        this.right = right;
    }
}



public class DepthofTree {
    
    public int maxoftree(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftdepth = maxoftree(root.left);
        int rigthdepth = maxoftree(root.right);
        return Math.max(leftdepth,rigthdepth)+1;
    }
}
