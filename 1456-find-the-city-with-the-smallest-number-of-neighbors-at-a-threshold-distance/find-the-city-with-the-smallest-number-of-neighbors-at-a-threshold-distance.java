class Solution {
    private void helper(ArrayList<ArrayList<int[]>> adj,int[] dist,int i)
    {
         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
         dist[i] = 0;
        pq.offer(new int[]{0, i});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];

            if (d > dist[u])
                continue;

            for (int p[] : adj.get(u)) {
                int v = p[0];
                int w = p[1];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            int c=edges[i][2];
            adj.get(a).add(new int[]{b,c});
            adj.get(b).add(new int[]{a,c});
        }
        int node=Integer.MIN_VALUE,c=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int[] dist=new int[n];
            int p=0;
            Arrays.fill(dist,Integer.MAX_VALUE);
            helper(adj,dist,i);
            for(int j=0;j<n;j++)
            {
                if(i!=j && dist[j]<=distanceThreshold)
                {
                    p++;
                }
            }
            if(c>=p)
            {
                c=Math.min(c,p);
                node=Math.max(node,i);
            }
        }
        return node;
    }
}