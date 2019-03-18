package ByteDance;

import java.util.HashMap;

class ListNode2 {
    int val;
    int key;
    ListNode2 next = null; //后序结点
    ListNode2 pre = null; //前序结点

    ListNode2(int key, int val) {
        this.key = key;
        this.val = val;
    }

}

public class LRUCache {

    HashMap<Integer, ListNode2> hashMap = new HashMap<Integer, ListNode2>();
    ListNode2 endNode = null, startNode = null;
    int capacity, nowCapacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) return -1;
        ListNode2 nowNode = hashMap.get(key);

        if (nowNode == endNode) { }
        else {
            if (nowNode == startNode) {
                startNode = startNode.next;
                startNode.pre = null;
                nowNode.pre = endNode;
                endNode.next = nowNode;
                nowNode.next = null;
                endNode = endNode.next;
            }
            else {
                nowNode.pre.next = nowNode.next;
                nowNode.next.pre = nowNode.pre;
                endNode.next = nowNode;
                nowNode.pre = endNode;
                nowNode.next = null;
                endNode = endNode.next;
            }
        }

        return nowNode.val;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            ListNode2 nowNode = hashMap.get(key);
            nowNode.val = value;
            if (nowCapacity == 1 || nowNode == endNode) { }
            else {
                if (startNode == nowNode) startNode = startNode.next;
                if (nowNode.pre != null)
                    nowNode.pre.next = nowNode.next;
                if (nowNode.next != null)
                    nowNode.next.pre = nowNode.pre;

                endNode.next = nowNode;
                nowNode.pre = endNode;
                nowNode.next = null;
                endNode = nowNode;
            }
            hashMap.put(key, nowNode);
        }

        else {
            if (nowCapacity == capacity) {
                ListNode2 nowList = new ListNode2(key, value);
                hashMap.put(key, nowList);
                endNode.next = nowList;
                nowList.pre = endNode;
                endNode = nowList;
                hashMap.remove(startNode.key);
                startNode = startNode.next;
            }
            else {
                if (nowCapacity == 0) {
                    ListNode2 nowList = new ListNode2(key, value);
                    startNode = endNode = nowList;
                    hashMap.put(key, nowList);
                }
                else {
                    ListNode2 nowList = new ListNode2(key, value);
                    hashMap.put(key, nowList);
                    endNode.next = nowList;
                    nowList.pre = endNode;
                    endNode = nowList;
                }
                ++ nowCapacity;
            }
        }
    }

}



