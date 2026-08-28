class Solution {
    private int helper(char[] ch, Set<String> dict,int i,int j,int[][] dp)
    {
        if(i==ch.length)
        {
            return 1;
        }
        if(j==ch.length)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int skip=0,pick=0;
        if(dict.contains(new String(ch, i, j - i + 1)))
        {
            pick=helper(ch,dict,j+1,j+1,dp);
        }
        skip = helper(ch,dict,i,j+1,dp);

        return dp[i][j] = Math.max(skip,pick);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        if( helper(ch,new HashSet<>(wordDict),0,0,dp)==1)
        {
            return true;
        }
        return false;
    }
}