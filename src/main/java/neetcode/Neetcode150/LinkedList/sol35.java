package neetcode.Neetcode150.LinkedList;

public class sol35 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first;
        if (list1 == null){
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }
        else {
            if (list1.val > list2.val) {
                first = list2;
                list2 = list2.next;
            }
            else {
                first = list1;
                list1 = list1.next;
            }
        }
        ListNode now = first;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                now.next = list2;
                list2 = list2.next;
            }
            else {
                now.next = list1;
                list1 = list1.next;
            }
            now = now.next;
        }

        if (list1 == null) {
            now.next = list2;
        }
        else {
            now.next = list1;
        }

        return first;
    }

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode5 = new ListNode(3, listNode6);
        ListNode listNode4 = new ListNode(1, listNode5);
        mergeTwoLists(listNode1, listNode4);
    }
}
