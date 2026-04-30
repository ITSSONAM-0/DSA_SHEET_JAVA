package Basics;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
        
    }
}

class Solution {
    public void deleteNode(Node node) {
        // Copy the value from the next node
        node.data = node.next.data;
        // Point to the next node's next (skip the next node)
        node.next = node.next.next;
    }
}



public class DeletedNodeInLL {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating linked list: 4 -> 5 -> 1 -> 9
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(1);
        head.next.next.next = new Node(9);

        System.out.print("Original List: ");
        printList(head);

        // Deleting node with value 5 (2nd node)
        new Solution().deleteNode(head.next);

        System.out.print("After Deleting 5: ");
        printList(head); // Expected Output: 4 -> 1 -> 9
    }
}
