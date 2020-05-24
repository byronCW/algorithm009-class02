/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        // 尾节点，用于指示追加位置
        ListNode tail = l3;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                tail.next = l2;
                l2 = l2.next;
            } else {
                tail.next = l1;
                l1 = l1.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return l3.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}