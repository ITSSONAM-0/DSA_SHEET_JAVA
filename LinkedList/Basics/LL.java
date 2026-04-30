package Basics;
public class LL {
    Node head;
    class Node {
        String data;
        Node next;


        Node(String data){
            this.data = data;
            this.next =null;
        }
    }

    //Adding element at the first of LL (Head)

    
    public void addFist(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //Adding element at the last of LL (tail)

    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }


    //printing the LinkedList
    public void printList(){
        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }

        Node currNode = head;

        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("Null");

    }

    //Deleting node at first

    public void deleteFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }


    //Deleting node at last
    public void deleteLast(){

        if(head == null){
            System.out.println("List is empty");
            return;
        }

        if(head == null){
            head = null;
            return;
        }

        Node secondlast = head;
        Node lastnode = head.next;

        while (lastnode.next != null) {
            lastnode = lastnode.next;
            secondlast = secondlast.next;
        }

        secondlast.next = null;


    }


    public static void main(String[] args) {
        LL list = new LL();
        list.addFist("hello");
        list.addFist("this");
        list.printList();

        list.addLast("Linked List");
        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();
    }
}
