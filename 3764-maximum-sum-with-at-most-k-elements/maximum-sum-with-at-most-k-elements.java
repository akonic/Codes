class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        long ans=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0;i<grid.length;i++)
        {
            Arrays.sort(grid[i]);
            int len = grid[i].length;
            for (int j = len - 1; j >= len - limits[i]; j--) {
                pq.offer(grid[i][j]);
            }
        }
        while(k>0)
        {k--;
            ans+=pq.poll();
        }
        return ans;
    }
}