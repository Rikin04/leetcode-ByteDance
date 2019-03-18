package ByteDance;


public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = listNode;

        while (true) {
            boolean flag = false;
            int min = Integer.MAX_VALUE, index = -1;

            for (int i = 0; i < lists.length;i ++) {
                if (lists[i] != null) {
                    flag = true;
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        index = i;
                    }
                }
            }

            if (flag) {
                listNode1.next = lists[index];
                lists[index] = lists[index].next;
                listNode1 = listNode1.next;
            }

            if (!flag)
                break;
        }

        return listNode.next;
    }
}

