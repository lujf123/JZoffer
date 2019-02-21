package code;

public class JZ24 {

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode tHead = null;
        boolean isTail = false;
        while (p != null) {
            if (isTail == false) {
                tHead = p;
                p = p.next;
                tHead.next = null;
                isTail = true;
            } else {
                ListNode tmp = tHead;
                tHead = p;
                p = p.next;
                tHead.next = tmp;
            }
        }
        return tHead;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
