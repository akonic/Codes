class Solution {
    private boolean isPalindrome(char[] ch,int i ,int j,int[][] dp)
    {
        if(dp[i][j]!=-1)
        {
            if(dp[i][j]==1)
            {
                return true;
            }
            return false;
        }
        while(i<j)
        {
            if(ch[i]!=ch[j])
            {
                dp[i][j]=0;
                return false;
            }
            i++;j--;
        }
        dp[i][j]=1;
        return true;
    }
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        int n=ch.length;
        int ans=n;
        int[][] dp = new int[n+1][n+1];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(isPalindrome(ch,i,j,dp))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}