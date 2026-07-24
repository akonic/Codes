class Solution {
    private int helper(int n,int i,int count,int original,int[][][] dp)
    {   //System.out.println(n);
        if(n==0 && count>=2)
        {
            return 1; 
        }
        if(n<0 || (n==0 && count<2) || i>original)
        {
            return 0;
        }
        if(dp[n][count][i]!=-1)
        {
            return dp[n][count][i];
        }
        int pick=0,notPick=0;
         pick+= i*helper(n-i,i,count+1,original,dp);
         notPick+= helper(n,i+1,count,original,dp);

        return dp[n][count][i] = Math.max(pick,notPick);
    }
    public int integerBreak(int n) {
        int[][][] dp = new int[59][59][59];
        for(int[][] i : dp)
        {
            for(int[] j : i)
            {
                Arrays.fill(j,-1);
            }
        }
        return helper(n,1,0,n,dp);

    }
}