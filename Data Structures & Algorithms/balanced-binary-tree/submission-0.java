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
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root).getValue();
    }

    private Pair<Integer, Boolean> checkBalanced(TreeNode root) {
        if (root == null)
            return new Pair<>(0, true);
        
        Pair<Integer, Boolean> left = checkBalanced(root.left);
        Pair<Integer, Boolean> right = checkBalanced(root.right);
        boolean isBalanced = Math.abs(left.getKey() - right.getKey()) <= 1 
                            && left.getValue() && right.getValue();
        return new Pair<>(1 + Math.max(left.getKey(), right.getKey()), isBalanced);
    }
}
