/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        if(height == -1){
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftsubtree = getHeight(root.left);
        int rightsubtree = getHeight(root.right);

        if(leftsubtree == -1 || rightsubtree == -1){
            return -1;
        }
        if(Math.abs(leftsubtree-rightsubtree) > 1){
            return -1;
        }
        return 1+Math.max(leftsubtree,rightsubtree);
    }
}