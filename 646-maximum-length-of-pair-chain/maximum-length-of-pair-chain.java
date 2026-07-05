class Solution {
    private int helper(int[][] pairs,int i,int last,int[][] dp)
    {
        if(i==pairs.length)
        {
            return 0;
        }
        if(dp[i][last]!=-1)
        {
            return dp[i][last];
        }
        int pick=0,skip=0;
        if(last==0)
        {
            pick=1+helper(pairs,i+1,i+1,dp);
        }
        else if(pairs[last-1][1]<pairs[i][0])
        {
            pick=1+helper(pairs,i+1,i+1,dp);
        }
        skip=helper(pairs,i+1,last,dp);
        
        return dp[i][last]=Math.max(pick,skip);
    }
    public int findLongestChain(int[][] pairs) {
         Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
         int n=pairs.length;
         int[][] dp = new int[n+1][n+1];
         for(int[] i: dp)
         {
            Arrays.fill(i,-1);
         }
        return helper(pairs,0,0,dp);
    }
}