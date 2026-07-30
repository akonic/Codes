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
    Map<TreeNode, Integer> mpCanSelect = new HashMap<>();
    Map<TreeNode, Integer> mpMustSkip = new HashMap<>();

    private int helper(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }

        if (i == 0 && mpCanSelect.containsKey(root)) {
            return mpCanSelect.get(root);
        }
        if (i == 1 && mpMustSkip.containsKey(root)) {
            return mpMustSkip.get(root);
        }

        int select = 0, skip = 0;
        if (i == 0) {
            select = root.val + helper(root.right, 1) + helper(root.left, 1);
        }
        skip = helper(root.right, 0) + helper(root.left, 0);
        int ans = Math.max(skip, select);
        if (i == 0) {
            mpCanSelect.put(root, ans);
        } else {
            mpMustSkip.put(root, ans);
        }

        return ans;
    }

    public int rob(TreeNode root) {
        mpCanSelect.clear();
        mpMustSkip.clear();
        return helper(root, 0);
    }
}