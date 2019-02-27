package code;

public class JZ37 {

    public int index;

    String Serialize(TreeNode root) {
        return build(root);
    }

    public String build(TreeNode root) {
        if (root != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(root.val + ",");
            stringBuilder.append(build(root.left));
            stringBuilder.append(build(root.right));
            return stringBuilder.toString();
        } else {
            return "#,";
        }
    }

    TreeNode Deserialize(String str) {
        if (str.equals("#,")) {
            return null;
        }
        String[] chars = str.split(",");
        index = 0;
        return deserializeToTree(chars);
    }

    TreeNode deserializeToTree(String[] string) {
        if (index > string.length || string[index].equals("#")) {
            index++;
            return null;
        } else {
            TreeNode treeNode = new TreeNode(Integer.parseInt(string[index++]));
            treeNode.left = deserializeToTree(string);
            treeNode.right = deserializeToTree(string);
            return treeNode;
        }
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
