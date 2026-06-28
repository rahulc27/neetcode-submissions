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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        if (root == null)
            return levelOrderTraversal;

        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        TreeNode lastNode = root;
        List<Integer> currentLevel = new ArrayList<>();

        while(!nodes.isEmpty()) {
            TreeNode currentNode = nodes.poll();
            if (currentNode.left != null)
                nodes.add(currentNode.left);
            if (currentNode.right != null)
                nodes.add(currentNode.right);

            currentLevel.add(currentNode.val);

            if (currentNode == lastNode) {
                levelOrderTraversal.add(currentLevel);
                currentLevel = new ArrayList();
                lastNode = nodes.peekLast();
            }
        }


        return levelOrderTraversal;
    }
}
