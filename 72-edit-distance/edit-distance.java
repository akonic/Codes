class Solution {
    private int lcs(char[] a,char[] b,int i,int j,int[][] dp)
    {
        if(i==a.length)
        {
            return b.length-j;
        }
        if(j==b.length)
        {
            return a.length - i;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int x = 0,y=0;
        if(a[i]==b[j])
        {
            return lcs(a,b,i+1,j+1,dp);
        }
        int insert = lcs(a,b,i,j+1,dp);
        int delete = lcs(a,b,i+1,j,dp);
        int replace = lcs(a,b,i+1,j+1,dp);
        return dp[i][j]=1+Math.min(insert,Math.min(delete,replace));

    }
    public int minDistance(String word1, String word2) {
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        int n=a.length;
        int m=b.length;
        int[][] dp = new int[n][m];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        int x=lcs(a,b,0,0,dp);

        return x;
    }
}