class Solution {
    int ans=0;
    private int helper(char[] ch,char[] bh,int i,int j,int[][] dp)
    {
        if(j==bh.length)
        {
            
            return 1;
        }
        if(i>=ch.length)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
           return  dp[i][j];
        }
        int x=0,y=0;
        if(ch[i]==bh[j])
        {
            x=helper(ch,bh,i+1,j+1,dp);
        }
        y=helper(ch,bh,i+1,j,dp);
        return dp[i][j] = x+y;
    }
    public int numDistinct(String s, String t) {
        ans=0;
        char[] ch = s.toCharArray();
        char[] bh = t.toCharArray();
        int n = ch.length;
        int m = bh.length;
        int[][] dp = new int[n+1][m+1];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }

       return helper(ch,bh,0,0,dp);

      //  return ans;
    }
}