class Solution {
    int mod = 1000000007;
    private int ways(int n,List<Integer> ls,int len,int i,int[][] dp)
    {
        if(n==0)
        {
            return 1;
        }
        if(i==len || n<0)
        {
            return 0;
        }
        if(dp[n][i]!=-1)
        {
            return dp[n][i];
        }
        int a = ways(n-ls.get(i),ls,len,i+1,dp);
        int b= ways(n,ls,len,i+1,dp);

        return dp[n][i]=(a+b)%mod;
    }
    public int numberOfWays(int n, int x) {
        List<Integer> ls = new ArrayList<>();
        int i=1;
        while(i<=n)
        {
            int p=(int)Math.pow(i,x);
            if(p > n) break;
            
            ls.add(p);
            i++;
        }
        int len = ls.size();
        int[][] dp = new int[n+1][len+1];
        for(int[] j : dp)
        {
            Arrays.fill(j,-1);
        }
        return ways(n,ls,len,0,dp);
        
    }
}