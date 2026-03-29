class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                q.offer(i);
                while (!q.isEmpty()) {
                    int p = q.poll();
                    for (int neighbor : graph[p]) {
                        if (color[neighbor] == 0) {

                            color[neighbor] = -color[p];
                            q.offer(neighbor);
                        } else if (color[neighbor] == color[p]) {

                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }
}