public class DeleteMiddleOfLinkedList {
     public ListNode deleteMiddle(ListNode head) {

        //this is cheeky solution okay
        ListNode curr = head;
        int len = 0;

        //count the number of nodes here 
        while(curr != null){
            len++;
            curr = curr.next;
        }

        // if only one node in the LL the return null because that node itself is middle 
        if(len == 1){
            return null;
        }

        int middle = len/2;

        // reset the curr to head
        curr = head;

        // loop it middle - 1 
        for(int i=0;i<middle -1 ; i++){
            curr = curr.next;
        }

        // assign curr next ot its next next
        curr.next = curr.next.next;
        return head;
    }
}
