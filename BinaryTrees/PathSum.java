import java.util.Stack;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();

        st.push(root);
        st1.push(root.val);

        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            int tempval = st1.pop();

            if(temp.left == null && temp.right == null && tempval == targetSum){
                return true;
            }

            if(temp.left != null){
                st.push(temp.left);
                st1.push(temp.left.val + tempval);
            }

            if(temp.right != null){
                st.push(temp.right);
                st1.push(temp.right.val + tempval);
            }
        }
        return false;

    }
}
