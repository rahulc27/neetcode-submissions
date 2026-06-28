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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pPath = new Stack();
        Stack<TreeNode> qPath = new Stack();
        findPath(root, p, pPath);
        findPath(root, q, qPath);

        TreeNode lca = root;
        while(!pPath.isEmpty() && !qPath.isEmpty()) {
            TreeNode pNode = pPath.pop();
            TreeNode qNode = qPath.pop();
            if (pNode.val == qNode.val)
                lca = qNode;
        }

        return lca;
    }

    private boolean findPath(TreeNode root, TreeNode target, Stack<TreeNode> path) {
        if (root == null) 
            return false;
        if (root.val == target.val) {
            path.push(target);
            return true;
        }
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            path.push(root);
            return true;
        }

        return false;
    }
}
