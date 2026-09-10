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
    int ans = 0;

    private int[] len(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }

        int[] left = len(root.left);

        int[] right = len(root.right);

        int x = 1 + left[1] + right[1];
        int p = left[0] + right[0];

       
        if (root.val == (root.val + p) / (x)) {
            ans++;
        }
        return new int[] { root.val + p, x };
    }

    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        int[] u = len(root);
        return ans;
    }
}