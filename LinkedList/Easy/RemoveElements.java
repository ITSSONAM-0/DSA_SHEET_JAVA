package LinkedList.Easy;

public class RemoveElements {
     public ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode temp = dum;

        while(temp.next != null ){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return dum.next;
    }
}
