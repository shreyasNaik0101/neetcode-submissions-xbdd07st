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
    int res;
    public int maxPathSum(TreeNode root) {
        res=root.val;
        maxBro(root);
        return res;
    }
    public int maxBro(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftMax = Math.max(maxBro(root.left), 0);
        int rightMax = Math.max(maxBro(root.right), 0);

        res = Math.max(res, root.val+leftMax+rightMax);
        return root.val+Math.max(leftMax, rightMax);
    }
}
