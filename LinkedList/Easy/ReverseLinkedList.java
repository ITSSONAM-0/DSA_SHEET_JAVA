class ListNode{
    int data;
    ListNode next;
    public Object val;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}



public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null , temp;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
}
}