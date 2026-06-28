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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> rightSideViewList = new ArrayList();
        if (root == null)
            return rightSideViewList;
        
        ArrayDeque<TreeNode> nodes = new ArrayDeque();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            rightSideViewList.add(nodes.peekLast().val);
            int currLevelSize = nodes.size();

            for(int i = 0; i < currLevelSize; i++) {
                TreeNode currNode = nodes.pollFirst();
                if(currNode.left != null)
                    nodes.addLast(currNode.left);
                if(currNode.right != null)
                    nodes.addLast(currNode.right);
            }
        }
        return rightSideViewList;   
    }
}
