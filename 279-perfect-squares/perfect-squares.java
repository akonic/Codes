class Solution {
    private int helper(int n,int i,List<Integer> ls,int[][] dp)
    {
        if(n==0)
        {
            return 0;
        }
        if(i==ls.size() || n<0)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[n][i]!=-1)
        {
            return dp[n][i];
        }
        int a=helper(n-ls.get(i),i,ls,dp);
        if(a!=Integer.MAX_VALUE)
        {
            a++;
        }
        int b=helper(n,i+1,ls,dp);
        return dp[n][i] = Math.min(a,b);
        
    }
    public int numSquares(int n) {
        int x=1;
        List<Integer> ls = new ArrayList<>();
        while(x*x<=n)
        {
            ls.add(x*x);
            x++;
        }
        int[][] dp = new int[n+1][ls.size()+1];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(n,0,ls,dp);
    }
}