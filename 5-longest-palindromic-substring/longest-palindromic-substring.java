class Solution {
    private int check(char[] ch,int i,int j,int[][] dp)
    {
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        while(i<j)
        {
            if(ch[i]!=ch[j])
            {
                return dp[i][j]=0;
            }
            i++;j--;
        }
        return dp[i][j]=1;
    }
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int ans=0;
        String st ="";
        int[][] dp = new int[n][n];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(check(ch,i,j,dp)==1 && j-i+1>ans)
                {
                   ans=j-i+1;
                    st = s.substring(i,j+1);
                }
            }
        }
        return st;
    }
}