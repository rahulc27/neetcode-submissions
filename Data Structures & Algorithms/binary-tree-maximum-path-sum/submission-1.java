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
        if (root == null)
            return 0;
        int leftSum = getMaxPathSum(root.left);
        int rightSum = getMaxPathSum(root.right);

        int currNodeSum = root.val;
        if (leftSum > 0)
            currNodeSum += leftSum;
        if (rightSum > 0)
            currNodeSum += rightSum;

        maxSum = Math.max(maxSum, currNodeSum);

        return root.val + Math.max(0, Math.max(leftSum, rightSum));
    }
}
