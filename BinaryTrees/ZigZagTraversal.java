import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null){
            return ls;
        }
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> ls1 = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                ls1.add(node.val);

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
            if(!flag){
                Collections.reverse(ls1);
            }
            ls.add(ls1);
            flag = !flag;

        }

        return ls;
    }
}
