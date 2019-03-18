package ByteDance;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode l3 = listNode;

        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
            l3.next = new ListNode(sum % 10);
            l3 = l3.next;
        }

        while (l1 != null) {
            int sum = carry + l1.val;
            l1 = l1.next;
            carry = sum / 10;
            l3.next = new ListNode(sum % 10);
            l3 = l3.next;
        }
        while (l2 != null) {
            int sum = carry + l2.val;
            l2 = l2.next;
            carry = sum / 10;
            l3.next = new ListNode(sum % 10);
            l3 = l3.next;
        }
        if (carry != 0)
            l3.next = new ListNode(carry);
        return listNode.next;

    }
}

