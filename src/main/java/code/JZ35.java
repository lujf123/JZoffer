package code;

import javafx.scene.control.RadioButton;

import java.util.HashMap;

public class JZ35 {

    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
        // 插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }
        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }

    public RandomListNode Clone1(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        RandomListNode cloneHead = new RandomListNode(pHead.label);
        RandomListNode tmpCloneHead = cloneHead;
        RandomListNode tmpPHead = pHead;
        hashMap.put(pHead, tmpPHead);
        // 复制链表
        while (tmpPHead.next != null) {
            tmpCloneHead.next = new RandomListNode(tmpPHead.next.label);
            hashMap.put(tmpPHead.next, tmpCloneHead.next);
            tmpPHead = tmpPHead.next;
            tmpCloneHead = tmpCloneHead.next;
        }

        tmpCloneHead = cloneHead;
        while (pHead != null) {
            RandomListNode tmp = hashMap.get(pHead.random);
            tmpCloneHead.random = tmp;
            pHead = pHead.next;
            tmpCloneHead = tmpCloneHead.next;
        }
        return cloneHead;
    }

    private void CloneNodes(RandomListNode pHead) {

    }

    private void ConnectSiblingNodes(RandomListNode pHead) {

    }


    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

}
