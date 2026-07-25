class Solution {
    private int helper(char[] a,char[] b,char[] c,int i,int j,int k,int[][][] dp)
    {
        int n=a.length;
        int m=b.length;
        int o=c.length;
        if(k==o && i==n && j==m)
        {
            return 1;
        }
        if(dp[i][j][k]!=-1)
        {
            return dp[i][j][k];
        }
        // if((i==n && j!=m && k!=o) || (j==m && i!=n && k!=o) || (k==o && i!=n && j!=m))
        // {
        //     return false;
        // }
        int a1= 0,b1=0;
        if(i<n && k<o && a[i]==c[k])
        {
            a1=helper(a,b,c,i+1,j,k+1,dp);
        }
        if(j<m && k<o  && b[j]==c[k])
        {
            b1=helper(a,b,c,i,j+1,k+1,dp);
        }
        return dp[i][j][k] = Math.max(a1,b1);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        char[] c = s3.toCharArray();
        int n=a.length;
        int m=b.length;
        int o=c.length;
        int[][][] dp = new int[n+1][m+1][o+1];
        for(int[][] i : dp)
        {
            for(int[] j : i)
            {
                Arrays.fill(j,-1);
            }
        }
        int x= helper(a,b,c,0,0,0,dp);
        if(x==0)
        {
            return false;
        }
        return true;
    }
}