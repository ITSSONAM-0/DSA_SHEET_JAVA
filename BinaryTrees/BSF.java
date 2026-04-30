import java.util.*;
public class BSF {

    class TreeNode<E>{
        E data;
        TreeNode left;
        TreeNode right;

        public TreeNode(E data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }



    public static void main(String[] args) {
        
    }

    public ArrayList<Integer> BFSS(TreeNode<Integer> root){
            ArrayList<Integer> ls = new ArrayList<>();
            Queue<TreeNode> qu = new LinkedList<>();
            qu.offer(root);

            while(!qu.isEmpty()){
                TreeNode<Integer> node = qu.poll();
                ls.add(node.data);

                if(node.left != null){
                    qu.offer(node.left);
                }
                if(node.right != null){
                    qu.offer(node.right);
                }
            }
 
            return ls;
    }
}
