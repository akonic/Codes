class Solution {
    private int helper(char[] s1,char[] s2,int i,int j,int[][] dp)
    {
        if(i==s1.length || j==s2.length)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
       // int pick=0,skip1=0,skip2=0;
        if(s1[i]==s2[j])
        {
            return  dp[i][j]= 1+helper(s1,s2,i+1,j+1,dp);
        }
        return dp[i][j]=Math.max(helper(s1,s2,i,j+1,dp),helper(s1,s2,i+1,j,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int n = s1.length;
        int m = s2.length;
        int[][] dp = new int[n+1][m+1];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(s1,s2,0,0,dp);
    }
}