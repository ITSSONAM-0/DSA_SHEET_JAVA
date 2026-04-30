package Basics;
class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}


public class SearchInLinkedList {
    static boolean searchKey(int n, Node head, int key){
        Node curr = head;

        while(curr != null){
            if(curr.data == key)
                return true;
            curr = curr.next;
        }
        return false;
    }
}
