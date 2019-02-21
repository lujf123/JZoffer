package code;

public class JZ22 {

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        int cnt = 1;
        while (cnt < k) {
            p2 = p2.next;
            if (p2 != null) {
                cnt++;
            } else {
                break;
            }
        }
        if (cnt != k) {
            return null;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
