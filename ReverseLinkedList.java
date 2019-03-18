package ByteDance;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        if (head.next.next == null) {
            ListNode x = head.next;
            x.next = head;
            head.next = null;
            return x;
        }
        ListNode one = head, two = head.next, three = head.next.next;
        while(three != null) {
            two.next = one;
            one = two;
            two = three;
            three = three.next;
        }
        two.next = one;
        return two;
    }
}


