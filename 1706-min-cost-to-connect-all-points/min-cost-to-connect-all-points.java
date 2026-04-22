class Solution {
    public int minCostConnectPoints(int[][] points) {
       int sum=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
       int n=points.length;
       pq.offer(new int[]{0,0,-1});
       int[] visited = new int[n];
       Arrays.fill(visited,-1);
       while(!pq.isEmpty())
       {
         int[] top = pq.poll();
         int a=top[0];
         int b=top[1];
         int c=top[2];
         if(visited[b]==1) continue ;
         sum+=a;
         visited[b]=1;
         for(int j=0;j<n;j++)
         {
            if(b!=j && visited[j]==-1)
            {
                int dist = Math.abs(points[b][0]-points[j][0])+ Math.abs(points[b][1]-points[j][1]);
                pq.offer(new int[]{dist,j,b});
            }
         }

       }
       return sum;
    }
}