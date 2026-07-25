class Solution {
    private int helper(char[] a,char[] b,char[] c,int i,int j,int[][] dp)
    {
        int n=a.length;
        int m=b.length;
        int o=c.length;
        if(i==n && j==m)
        {
            return 1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int a1= 0,b1=0,k=i+j;
        if(i<n && k<o && a[i]==c[k])
        {
            a1=helper(a,b,c,i+1,j,dp);
        }
        if(j<m && k<o  && b[j]==c[k])
        {
            b1=helper(a,b,c,i,j+1,dp);
        }
        return dp[i][j] = Math.max(a1,b1);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        char[] c = s3.toCharArray();
        int n=a.length;
        int m=b.length;
        int o=c.length;
        if(n+m!=o)
        {
            return false;
        }
        int[][] dp = new int[n+1][m+1];
        for(int[] i : dp)
        {
             Arrays.fill(i,-1);
        }
        int x= helper(a,b,c,0,0,dp);
        if(x==0)
        {
            return false;
        }
        return true;
    }
}