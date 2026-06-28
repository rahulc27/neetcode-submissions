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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxSum;
    }

    private int getMaxPathSum(TreeNode root) {
    if (root == null) return 0;

    int leftSum = Math.max(0, getMaxPathSum(root.left));
    int rightSum = Math.max(0, getMaxPathSum(root.right));

    maxSum = Math.max(maxSum, root.val + leftSum + rightSum);

    return root.val + Math.max(leftSum, rightSum);
}
}
