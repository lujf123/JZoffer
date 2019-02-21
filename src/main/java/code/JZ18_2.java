package code;

public class JZ18_2 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next1 = pHead;
        ListNode next2 = pHead.next;
        ListNode beforeNext = null;
        while (next2 != null) {
            if (next1.val == next2.val) {
                if (next1 == pHead) {
                    pHead = next2.next;
                    next1 = pHead;
                    next2 = pHead.next;
                    beforeNext = null;
                } else {
                    beforeNext.next = next2.next;
                    next1 = beforeNext.next;
                    next2 = next1.next;
                }
            } else {
                beforeNext = next1;
                next1 = next2;
                next2 = next2.next;
            }
        }
        return pHead;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
