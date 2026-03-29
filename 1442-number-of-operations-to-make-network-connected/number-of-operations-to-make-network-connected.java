class Solution {
    private void helper(ArrayList<ArrayList<Integer>> adj, int[] visited, int i) {
        visited[i] = 1;
        for (int node : adj.get(i)) {
            if (visited[node] == 0) {
                helper(adj, visited, node);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
            adj.add(new ArrayList<>());
        }
        int m = connections.length;
        for (int i = 0; i < m; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++;
                helper(adj, visited, i);
            }
        }
        if (m >= n-1) {
            return count - 1;
        }
        return -1;
    }
}