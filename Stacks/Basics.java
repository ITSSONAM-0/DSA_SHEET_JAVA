package DSA_SHEET_JAVA.Stacks;

//Impementation of Stack using Linked List

public class Basics {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Stack class

    static class Stack {
        public static Node head;

        public static boolean isEmpty() {
            return head == null;
        }

        // Push Operation on stack

        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;

        }

        // Pop operation on Stack

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // Peek operation on Stack

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}