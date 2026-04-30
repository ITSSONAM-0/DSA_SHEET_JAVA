import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class LeftSideView {
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ls = new ArrayList<>();
        
        if(root == null){
            return ls;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
        
        for(int i=0;i<size;i++){
            Node node = q.poll();
            if(i == 0){
                ls.add(node.data);
            }
            
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
        }
        
        return ls;
        
    }
}
