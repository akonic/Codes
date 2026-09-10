class Solution {
    private int helper(char[] ch,char[] bh,int i,int j,int n,int[][] dp)
    {
        if(i==n || j==n)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(ch[i]==bh[j])
        {
            return dp[i][j]=1+helper(ch,bh,i+1,j+1,n,dp);
        }

        return dp[i][j]=Math.max(helper(ch,bh,i+1,j,n,dp),helper(ch,bh,i,j+1,n,dp));
    }
    public int longestPalindromeSubseq(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        char[] bh = new char[n];
        for(int i=0;i<n;i++)
        {
            bh[i]=ch[n-i-1];
        }
        int[][] dp = new int[n][n];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(ch,bh,0,0,n,dp);
    }
}