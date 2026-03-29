class Solution {
    // private void helper(ArrayList<ArrayList<Integer>> adj,int[] visited,int i)
    // {
    //     visited[i]=1;
    //     for(int j : adj.get(i))
    //     {
    //         if(visited[j]==0)
    //         {
    //             helper(adj,visited,j);
    //         }
    //     }
    // }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++;
                q.offer(i);
                visited[i] = 1;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[node][j] == 1 && visited[j]==0) {
                            visited[j] = 1;
                            q.offer(j);
                        }
                    }
                }
            }
        }

        return count;
    }
}