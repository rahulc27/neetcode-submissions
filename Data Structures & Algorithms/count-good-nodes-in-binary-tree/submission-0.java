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
    private int goodNodeCount = 0;
    public int goodNodes(TreeNode root) {
        if (root == null)
            return goodNodeCount;
        calculateGoodNodeCount(root, root.val);
        return goodNodeCount;
    }
    private void calculateGoodNodeCount(TreeNode root, int maxValueInPath) {

        if (root == null)
            return;
        
        if (root.val >= maxValueInPath)
            goodNodeCount++;
        if (root.left != null)
            calculateGoodNodeCount(root.left, Math.max(root.left.val, maxValueInPath));
        if (root.right != null)
            calculateGoodNodeCount(root.right, Math.max(root.right.val, maxValueInPath));
    }
}
