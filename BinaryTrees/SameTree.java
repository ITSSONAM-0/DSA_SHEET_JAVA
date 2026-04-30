import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
       
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(p);
        qu.add(q);

        while(!qu.isEmpty()){
            TreeNode node1 = qu.remove();
            TreeNode node2 = qu.remove();

            if(node1 == null && node2 == null){
                continue;
            }
            if(node1 == null || node2 == null || node1.val != node2.val){
                return false;
            }

            qu.add(node1.left);
            qu.add(node2.left);
            qu.add(node1.right);
            qu.add(node2.right);
        }
        return true;
      
    }
    
}