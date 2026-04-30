package LinkedList.Easy;

public class MergeTwoLL {

     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode newNode = res;

        while(list1 != null && list2 != null){
            if(list1.val<=list2.val){
                newNode.next = list1;
                newNode = newNode.next;
                list1 = list1.next;
            }else{
                newNode.next = list2;
                newNode = newNode.next;
                list2 = list2.next;
            }
        }
        while(list1 != null){
            newNode.next = list1;
            newNode = newNode.next;
            list1 = list1.next;
        }
        while(list2 != null){
            newNode.next = list2;
            newNode = newNode.next;
            list2 = list2.next;
        }
        return res.next;
    }
}