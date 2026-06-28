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
    // If the helper returns -1, the tree is unbalanced.
    return checkHeight(root) != -1;
}

private int checkHeight(TreeNode root) {
    if (root == null) {
        return 0; // Base case: height of an empty tree is 0
    }
    
    // Check left subtree
    int leftHeight = checkHeight(root.left);
    if (leftHeight == -1) return -1; // Bubble up the failure
    
    // Check right subtree
    int rightHeight = checkHeight(root.right);
    if (rightHeight == -1) return -1; // Bubble up the failure
    
    // If the current node is unbalanced, return -1
    if (Math.abs(leftHeight - rightHeight) > 1) {
        return -1;
    }
    
    // Otherwise, return the actual height of this subtree
    return 1 + Math.max(leftHeight, rightHeight);
}
}
