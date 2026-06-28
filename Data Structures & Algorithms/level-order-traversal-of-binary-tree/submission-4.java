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

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            int levelSize = nodes.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodes.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) 
                    nodes.add(currentNode.left);
                
                if (currentNode.right != null)
                    nodes.add(currentNode.right);
            }

            levelOrderTraversal.add(currentLevel);
        }

        return levelOrderTraversal;
    }
}
