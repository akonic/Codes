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
    private boolean helper(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }
        // if (targetSum < 0) {
        //     return false;
        // }
        boolean a = false, b = false;
        if (root.left != null) {
            a = helper(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            b = helper(root.right, targetSum - root.val);
        }
        return a || b;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        return helper(root, targetSum);
    }
}