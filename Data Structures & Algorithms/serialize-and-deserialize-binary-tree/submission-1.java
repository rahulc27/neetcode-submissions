/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList();
        dfs(root, res);
        return String.join(",",res);
    }

    public void dfs(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public TreeNode dfs(String[] elements) {
        if (elements[index].equals("N")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(elements[index]));
        index++;
        root.left = dfs(elements);
        root.right = dfs(elements);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] elements = data.split(",");
        return dfs(elements);
    }
}
