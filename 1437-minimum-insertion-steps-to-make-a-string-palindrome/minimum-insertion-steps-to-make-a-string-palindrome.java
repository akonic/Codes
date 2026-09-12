class Solution {
    private int helper(char[] ch,char[] bh,int i,int j,int[][] dp)
    {
        if(i>= ch.length || j>=bh.length)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(ch[i]==bh[j])
        {
            return dp[i][j] = 1 + helper(ch,bh,i+1,j+1,dp);
        }

        return dp[i][j] = Math.max(helper(ch,bh,i+1,j,dp),helper(ch,bh,i,j+1,dp));
    }
    public int minInsertions(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] dp = new int[n][n];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        char[] bh = new char[n];
        for(int i=0;i<n;i++)
        {
            bh[i]=ch[n-i-1];
        }
        int x = helper(ch,bh,0,0,dp);
        System.out.println(x);
        return n-x;
    }
}