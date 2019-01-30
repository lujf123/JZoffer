package code;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 递归
 */

public class JZ06 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (listNode == null) {
            return arr;
        }
        f(arr, listNode);
        return arr;
    }

    private void f(ArrayList<Integer> arr, ListNode listNode) {
        if (listNode == null) {
            return;
        } else {
            f (arr, listNode.next);
        }
        arr.add(listNode.val);
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用递归（参考）
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     * 使用头插法
     * 利用列表头插法为逆序的特点
     * 头节点和第一个节点的区别：
     *   - 头节点是在头插法中使用的一个额外节点，这个节点不存储值
     *   - 第一个节点就是链表的一个真正存储值的节点
     */

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
           ListNode memo = listNode.next;
           listNode.next = head.next;
           head.next = listNode;
           listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<Integer>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    /**
     * 使用栈
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.println(new JZ06().printListFromTailToHead(l1));
        System.out.println(new JZ06().printListFromTailToHead1(l1));
        //System.out.println(new JZ06().printListFromTailToHead2(l1));
        System.out.println(new JZ06().printListFromTailToHead3(l1));
    }

}
