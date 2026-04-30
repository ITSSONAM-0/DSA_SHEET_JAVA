package Hard;

public class RotateLLbyK {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // Edge case: empty list, single-node list, or no rotation needed
        }

        // Step 1: Compute length of the list
        int length = 1;
        ListNode fast = head;
        while (fast.next != null) {  // Corrected loop to calculate the length
            fast = fast.next;
            length++;
        }
        // Step 2: Adjust k (if k >= length)
        k = k % length;
        if (k == 0) return head; // No rotation needed

        // Step 3: Move fast pointer k steps ahead
        fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // Step 4: Move slow and fast simultaneously
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 5: Update new head and reconnect the list
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head; // Connect tail to old head

        return newHead;
    }
}