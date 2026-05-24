/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
        {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Node> ls = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                ls.add(node);
            }
            for (int i = 0; i < size - 1; i++) {
                Node node = ls.get(i);
                if (i == size - 1) {
                    node.next = null;
                } else {
                    Node nextNode = ls.get(i + 1);
                    node.next = nextNode;
                }

            }

        }
        return root;
    }
}