package code;

public class JZ55_2 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    // 后序遍历
    private int height(TreeNode root) {
        if (root == null || !isBalanced) { // !isBalanced 剪枝
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }

}
