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
    Map<Integer, TreeMap<Integer, List<Integer>>> mp = new TreeMap<>();

    private void traverse(TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }
        traverse(node.left, x - 1, y + 1);
        mp.computeIfAbsent(x, k -> new TreeMap<>())
                .computeIfAbsent(y, k -> new ArrayList<>())
                .add(node.val);
        traverse(node.right, x + 1, y + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        mp.clear();
        traverse(root, 0, 0);
        List<List<Integer>> ls = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> col : mp.values()) {
            List<Integer> colList = new ArrayList<>();
            for (List<Integer> cell : col.values()) {
                Collections.sort(cell);
                colList.addAll(cell);
            }
            ls.add(colList);
        }
        return ls;
    }
}