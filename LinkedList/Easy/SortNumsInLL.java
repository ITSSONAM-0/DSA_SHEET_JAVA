

public class SortNumsInLL {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node segregate(Node head) {
        if (head == null || head.next == null) return head;

        // Dummy nodes for 0s, 1s, and 2s
        Node zeroD = new Node(0), oneD = new Node(0), twoD = new Node(0);
        Node zero = zeroD, one = oneD, two = twoD;
        Node curr = head;

        // Separate nodes into three lists
        while (curr != null) {
            if (curr.data == 0) {   
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // Connect three lists
        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;

        // Head of the new sorted list
        return zeroD.next;
    }
}
