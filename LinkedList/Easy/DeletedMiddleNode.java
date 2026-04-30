public class DeletedMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: if list is empty or has only one node
        if (head == null || head.next == null) {
            return null;
        }
        
        // Edge case: if list has only two nodes
        if (head.next.next == null) {
            head.next = null;
            return head;
        }
        
        // Use fast and slow pointer technique
        ListNode slow = head;
        ListNode fast = head.next.next;
        
        // Move fast pointer two steps and slow pointer one step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Delete the middle node
        slow.next = slow.next.next;
        
        return head;
    }
}
