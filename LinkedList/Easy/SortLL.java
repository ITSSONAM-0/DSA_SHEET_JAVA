
 






public class SortLL {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find the middle of linked list
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split the linked list into two parts
        ListNode right = slow.next;
        slow.next = null;
        
        // Recursive calls
        ListNode left = sortList(head);
        right = sortList(right);
        
        // Merge the sorted lists
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        
        return dummy.next;
    }
}
