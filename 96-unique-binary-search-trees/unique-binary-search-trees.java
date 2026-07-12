class Solution {
    private int count(int n,int[] dp)
    {
        if(n==0)
        {
            return 1;
        }
        if(n==2 || n==1)
        {
            return n;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }   
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            sum+=count(i-1,dp) * count(n-i,dp);
        }
        return dp[n]=sum;
    }
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return count(n,dp);
    }
}