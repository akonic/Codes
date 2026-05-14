class Solution {
    // private int helper(int n,int i,List<Integer> ls,int[][] dp)
    // {
    //     if(n==0)
    //     {
    //         return 0;
    //     }
    //     if(i==ls.size() || n<0)
    //     {
    //         return Integer.MAX_VALUE;
    //     }
    //     if(dp[n][i]!=-1)
    //     {
    //         return dp[n][i];
    //     }
    //     int a=helper(n-ls.get(i),i,ls,dp);
    //     if(a!=Integer.MAX_VALUE)
    //     {
    //         a++;
    //     }
    //     int b=helper(n,i+1,ls,dp);
    //     return dp[n][i] = Math.min(a,b);
        
    // }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++)
        {
            int j=1;
            while(j*j<=i)
            {
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                j++;
            }
        }
        return dp[n];
    }
}