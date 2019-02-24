package code;

import java.util.ArrayList;
import java.util.Stack;

public class JZ32_3 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        int cnt = 0;
        boolean flag = true;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(pRoot);
        while (!stack.isEmpty()) {
            cnt = stack.size();
            ArrayList<Integer> list = new ArrayList<>();
            Stack<TreeNode> stackTmp = new Stack();
            while (cnt-- > 0) {
                if (flag == true) {
                    TreeNode tmp = stack.pop();
                    list.add(tmp.val);
                    if (tmp.left != null) {
                        stackTmp.push(tmp.left);
                    }
                    if (tmp.right != null) {
                        stackTmp.push(tmp.right);
                    }
                } else if (flag == false) {
                    TreeNode tmp = stack.pop();
                    list.add(tmp.val);
                    if (tmp.right != null) {
                        stackTmp.push(tmp.right);
                    }
                    if (tmp.left != null) {
                        stackTmp.push(tmp.left);
                    }
                }
            }
            flag = !flag;
            ret.add(list);
            stack = stackTmp;
        }
        return ret;
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
