package ByteDance;

import java.util.List;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode rm = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            }
            else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        if (l1 != null)
            listNode.next = l1;
        else if (l2 != null)
            listNode.next = l2;
        return rm.next;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

