import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree {
     public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int childcount = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                int sameparentcount = 0;

                if(node.left != null){
                    if(node.left.val == x || node.left.val == y){
                        sameparentcount++;
                        childcount++;
                    }
                    q.offer(node.left);
                }
                if(node.right != null){
                    if(node.right.val == x || node.right.val == y){
                        sameparentcount++;
                        childcount++;
                    }
                    q.offer(node.right);
                }

                if(sameparentcount == 2){
                    return false;
                }
           

            }
            if(childcount == 2){
                return true;
            }
            if(childcount == 1){
                return false;
            }

        }
        return false;




    }
    
}