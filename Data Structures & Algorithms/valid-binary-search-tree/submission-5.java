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

    public boolean isValidBST(TreeNode root) {
        return traverseTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean traverseTree(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        
        if (root.val <= min || root.val >= max)
            return false;

        return traverseTree(root.left, min, root.val) 
                && traverseTree(root.right, root.val, max); 
    }
}
