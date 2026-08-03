class Solution {
    private int helper(int n,int i,int prev,int picked,int[][][] dp)
    {
        if(n==i)
        {
            return 0;
        }
        if(i>n || prev>n)
        {
            return 1000;
        }
        if(dp[i][prev][picked]!=-1)
        {
            return dp[i][prev][picked];
        }
        int a = 1+helper(n,i+prev,prev,0,dp);
        int b=1000;
        if(picked==0){
         b= 1+ helper(n,i,i,1,dp);
        }
        return dp[i][prev][picked]=Math.min(a,b);
    }
    public int minSteps(int n) {
        if(n==1)
        {
            return 0;
        }
        int[][][] dp = new int[n+1][n+1][2];
        for(int[][] i : dp)
        {
            for(int[] j : i)
            {
                Arrays.fill(j,-1);
            }
        }
        return 1 + helper(n,1,1,1,dp);

    }
}