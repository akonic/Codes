class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;  
        int[][] effort = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty())
        {
            int[] top = pq.poll();
            int eff = top[0];
            int x = top[1];
            int y = top[2];

            if(eff > effort[x][y]) continue;

            if(x == n-1 && y == m-1) return eff; 

            if(x+1 < n)  
            {
                int newEff = Math.max(eff, Math.abs(heights[x][y] - heights[x+1][y]));
                if(newEff < effort[x+1][y])
                {
                    effort[x+1][y] = newEff;
                    pq.offer(new int[]{newEff, x+1, y});
                }
            }
            if(y+1 < m)
            {
                int newEff = Math.max(eff, Math.abs(heights[x][y] - heights[x][y+1]));
                if(newEff < effort[x][y+1])
                {
                    effort[x][y+1] = newEff;
                    pq.offer(new int[]{newEff, x, y+1});
                }
            }
            if(y-1 >= 0)
            {
                int newEff = Math.max(eff, Math.abs(heights[x][y] - heights[x][y-1]));
                if(newEff < effort[x][y-1])
                {
                    effort[x][y-1] = newEff;
                    pq.offer(new int[]{newEff, x, y-1});
                }
            }
            if(x-1 >= 0)
            {
                int newEff = Math.max(eff, Math.abs(heights[x][y] - heights[x-1][y]));
                if(newEff < effort[x-1][y])
                {
                    effort[x-1][y] = newEff;
                    pq.offer(new int[]{newEff, x-1, y});
                }
            }
        }
        return -1;
    }
}