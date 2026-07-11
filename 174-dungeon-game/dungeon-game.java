class Solution {
    private int helper(int[][] dungeon,int i,int j,int[][] dp)
    {
        int n=dungeon.length;
        int m = dungeon[0].length;
        if(i==n-1 && j==m-1)
        {
           return Math.max(1, 1 - dungeon[i][j]);
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int down=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(i+1<n)
        {
            right =helper(dungeon,i+1,j,dp);
        }
        if(j+1<m)
        {
            down = helper(dungeon,i,j+1,dp);
        }

        return dp[i][j]= Math.max(1,  Math.min(down, right) - dungeon[i][j]);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int[][] dp = new int[n][m];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(dungeon,0,0,dp);
    }
}