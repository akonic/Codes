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
    List<Integer> ls = new ArrayList<>();
    private void traverse(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        traverse(root.left);
        ls.add(root.val);
        traverse(root.right);

        return;
    }
    public boolean isValidBST(TreeNode root) {
        ls.clear();
        traverse(root);

        int n=ls.size();
        for(int i=1;i<n;i++)
        {
            if(ls.get(i)<=ls.get(i-1))
            {
                return false;
            }
        }
        return true;
    }
}