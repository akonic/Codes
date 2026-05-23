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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<TreeNode> temp1 = new ArrayList<>();
            List<Integer> temp2 = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                temp1.add(node);
                temp2.add(node.val);
            }
            ls.add(temp2);
            for (TreeNode node : temp1) {
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            temp1.clear();

        }

        return ls;
    }
}