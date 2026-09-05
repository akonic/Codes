class Solution {
    private int check(char[] ch,int i,int j,int[][] dp)
    {
        if(i>=j)
        {
            return 1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int a =0;
       if(ch[i]==ch[j])
       {
          a = check(ch,i+1,j-1,dp);
       }
        else{
            a=0;
        }
        return dp[i][j]=a;
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