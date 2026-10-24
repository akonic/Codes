/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }
    private void build(TreeNode node, StringBuilder sb) {
        if (node == null) { sb.append("N,"); return; }
        sb.append(node.val).append(',');
        build(node.left, sb);
        build(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        return parse(new ArrayDeque<>(Arrays.asList(data.split(","))));
    }
    private TreeNode parse(Queue<String> q) {
        String s = q.poll();
        if (s.equals("N")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left  = parse(q);
        node.right = parse(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;