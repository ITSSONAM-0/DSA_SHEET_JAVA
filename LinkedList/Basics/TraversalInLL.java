package Basics;
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}


public class TraversalInLL {

    public int geCount(Node head){
        int count = 0;
        Node curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
    
}