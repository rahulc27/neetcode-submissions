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
    private boolean isValidBST = true;
    public boolean isValidBST(TreeNode root) {
        traverseTree(root);
        return isValidBST;
    }

    private Pair<Integer, Integer> traverseTree(TreeNode root) {
        if (root == null)
            return null;
        
        Pair<Integer, Integer> leftMinMax = traverseTree(root.left);
        Pair<Integer, Integer> rightMinMax = traverseTree(root.right);

        isValidBST = isValidBST
                    && (leftMinMax == null || root.val > leftMinMax.getValue())
                    && (rightMinMax == null || root.val < rightMinMax.getKey());
    
        int min = (leftMinMax == null) ? root.val : Math.min(root.val, leftMinMax.getKey());
        int max = (rightMinMax == null) ? root.val : Math.max(root.val, rightMinMax.getValue());
        return new Pair(min, max);
    }
}
