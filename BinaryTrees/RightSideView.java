import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null){
            return ls;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            while(size > 0){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                size--;
                if(size == 0){
                    ls.add(node.val);
                }
            }
        }
        return ls;
    }
}
