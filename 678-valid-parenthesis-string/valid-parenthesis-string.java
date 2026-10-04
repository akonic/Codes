class Solution {
    private int helper(char[] ch,int i,int c,int[][] dp)
    {
        if(c==0)
        {
            return 0;
        }
        if(i==ch.length && c==1)
        {
            return 1;
        }
        if(i>=ch.length && c>1)
        {
            return 0;
        }
        if(dp[i][c]!=-1)
        {
            return dp[i][c];
        }
        int a=0,b=0;
        if(ch[i]=='(')
        {
            a = helper(ch,i+1,c+1,dp);
        }
        if(ch[i]==')')
        {
            a= helper(ch,i+1,c-1,dp);
        }
        if(ch[i]=='*')
        {
            b=Math.max(helper(ch,i+1,c+1,dp),Math.max(helper(ch,i+1,c-1,dp),helper(ch,i+1,c,dp)));
        }

        return dp[i][c]=Math.max(a,b);
    }
    public boolean checkValidString(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        if(helper(ch,0,1,dp)==1)
        {
            return true;
        }
        return false;
    }
}