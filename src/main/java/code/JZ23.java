package code;

public class JZ23 {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null) {
            return null;
        }

        ListNode p1 = pHead;
        ListNode p2 = pHead;
        int cnt = 0;
        while (true) {
            if (p1.next != null && p2.next != null && p2.next.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
                //cnt++;
                if (p1 == p2) {
                    break;
                    //return p1;
                } else {
                    continue;
                }
            } else {
                return null;
            }
        }
        ListNode tmp = p1;
        cnt++;
        p1 = p1.next;
        while (tmp != p1) {
            cnt++;
            p1 = p1.next;
        }
        p1 = pHead;
        p2 = pHead;
        for (int i=0; i<cnt; i++) {
            p1 = p1.next;
        }
        while (p1 != p2) {
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
