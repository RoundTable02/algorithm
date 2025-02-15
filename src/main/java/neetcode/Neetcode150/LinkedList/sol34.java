package neetcode.Neetcode150.LinkedList;

public class sol34 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode before = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = before;
            before = head;
            head = next;
        }

        return before;
    }
}