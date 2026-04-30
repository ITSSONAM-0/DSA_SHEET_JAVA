package DSA_SHEET_JAVA.DoublyLinkedList;

class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = next;
        this.next = prev;
    }
}

class DoublyLinkedList {

    Node head;

    // Insert at the end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert at the beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Delete a node
    void deleteNode(int key) {
        if (head == null)
            return;

        Node temp = head;

        // If the node to be deleted is the head
        if (head.data == key) {
            head = head.next;
            if (head != null)
                head.prev = null;
            return;
        }

        // Traverse to find the node
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null)
            return; // Key not found

        if (temp.next != null)
            temp.next.prev = temp.prev;
        if (temp.prev != null)
            temp.prev.next = temp.next;
    }

    // Print list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}

public class DLLExample {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtBeginning(5);
        dll.insertAtEnd(30);
        dll.display(); // Output: 5 ⇄ 10 ⇄ 20 ⇄ 30 ⇄ null

        dll.deleteNode(20);
        dll.display(); // Output: 5 ⇄ 10 ⇄ 30 ⇄ null
    }
}