class Solution {
    public int minCostConnectPoints(int[][] points) {
       int sum=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
       int n=points.length;
       pq.offer(new int[]{0,0,-1});
       boolean[] visited = new boolean[n];
       Arrays.fill(visited,false);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
       while(!pq.isEmpty())
       {
         int[] top = pq.poll();
         int a=top[0];
         int b=top[1];
         if(visited[b]) continue ;
         sum+=a;
         visited[b]=true;
         for(int j=0;j<n;j++)
         {
           if(!visited[j])
                {
                    int d = Math.abs(points[b][0] - points[j][0])
                          + Math.abs(points[b][1] - points[j][1]);
                    if(d < dist[j])       
                    {
                        dist[j] = d;
                        pq.offer(new int[]{d, j});
                    }
                }
         }

       }
       return sum;
    }
}