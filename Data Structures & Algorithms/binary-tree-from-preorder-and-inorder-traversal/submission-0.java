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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
            
        TreeNode root = new TreeNode();
        root.val = preorder[0];
        if (preorder.length == 1) 
            return root;

        int rootIndex = findIndex(inorder, root.val);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootIndex+1, inorder.length));
        
        return root;
    }

    private int findIndex(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i; // Element found, return its index
        }
    }
    return -1; // Element not found
}

}
