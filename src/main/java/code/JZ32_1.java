package code;

import java.util.ArrayList;
import java.util.LinkedList;

public class JZ32_1 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode tmp = linkedList.getFirst();
            arrayList.add(tmp.val);
            linkedList.removeFirst();
            if (tmp.left != null) {
                linkedList.add(tmp.left);
            }
            if (tmp.right != null) {
                linkedList.add(tmp.right);
            }
        }
        return arrayList;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
