

class ListNode{
    int data;
    ListNode next;
    public Object val;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}



public class MiddleOfTheLinkedList {


    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
