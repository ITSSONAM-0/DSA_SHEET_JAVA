import org.w3c.dom.Node;

public class SumofBinaryTree {
    static int sumBT(Node root) {
        
        if(root == null){
            return 0;
        }
        int sum = 0;
        
        return root.data + 
        sumBT(root.left) +
        sumBT(root.right);
        
        
        
        
    }
}
