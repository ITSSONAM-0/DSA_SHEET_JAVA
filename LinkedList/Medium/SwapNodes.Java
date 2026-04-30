class SwapNodes{
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        while(temp.next != null && temp.next.next != null){
            ListNode swap1 = temp.next;
            ListNode swap2 = temp.next.next;

            swap1.next = swap2.next;
            swap2.next = swap1;

            temp.next = swap2;
            temp = swap1;
        }
        return dummy.next;
    }
}