public class PalidromeOfLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;


        // Step 1: Find the middle of the linked list using slow & fast pointers
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode prev = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // Step 3: Compare the first half and the reversed second half
        while(prev != null){
            if(head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
