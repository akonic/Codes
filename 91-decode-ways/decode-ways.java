class Solution {
    private int helper(char[] ch,int i,int n,int[] dp)
    {
        if(i==n)
        {
            return 1;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int a=0,b=0;
        if(ch[i]!='0')
        {
            b=helper(ch,i+1,n,dp);
            if(i+1<n)
            {
                int x = (ch[i] - '0') * 10 + (ch[i+1] - '0');
                if(x<27)
                {
                    a=helper(ch,i+2,n,dp);
                }
            }
        }
        return dp[i]=a+b;
    }
    public int numDecodings(String s) {
        int n=s.length();
        char[] ch = s.toCharArray();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(ch,0,n,dp);
    }
}