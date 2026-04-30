package Basics;
class Node {
    int data;
    Node next;

    Node (int data){
        this.data = data;
        this.next = null;
    }
}

public class InesertAtEnd {
    
    Node insertAtEnd(Node head, int x) {

        Node newNode = new Node(x);
        if(head == null){
            return newNode;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }


}
