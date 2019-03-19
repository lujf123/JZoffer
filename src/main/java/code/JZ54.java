package code;

public class JZ54 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private int cnt = 0;
    private TreeNode ret;
    public  void inOrder(TreeNode pRoot, int k)
    {
        if (pRoot == null || cnt >= k) {
            return;
        }
        if (pRoot.left != null) {
            inOrder(pRoot.left, k);
        }
        cnt++;
        if (cnt == k) {
            ret = pRoot;
        }
        if (pRoot.right != null) {
            inOrder(pRoot.right, k);
        }
    }
}
