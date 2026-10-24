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
       Map<String, List<Integer>> mp = new TreeMap<>();

    private void traverse(TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }
        traverse(node.left, x - 1, y + 1);
        mp.computeIfAbsent(String.format("%04d-%04d", x + 1000, y + 1000),
                           k -> new ArrayList<>()).add(node.val);
        traverse(node.right, x + 1, y + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        mp.clear();
        traverse(root, 0, 0);

        List<List<Integer>> ls = new ArrayList<>();
        String prevX = null;
        List<Integer> col = null;

        for (Map.Entry<String, List<Integer>> e : mp.entrySet()) {
            String currX = e.getKey().substring(0, 4);
            if (!currX.equals(prevX)) {       
                col = new ArrayList<>();
                ls.add(col);
                prevX = currX;
            }
            List<Integer> cell = e.getValue();
            Collections.sort(cell);            
            col.addAll(cell);
        }
        return ls;
    }
}