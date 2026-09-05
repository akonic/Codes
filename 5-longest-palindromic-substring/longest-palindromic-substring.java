class Solution {
    private int check(char[] ch, int i, int j, int[][] dp) {
        if (i >= j) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int a = 0;
        if (ch[i] == ch[j]) {
            a = check(ch, i + 1, j - 1, dp);
        } else {
            a = 0;
        }
        return dp[i][j] = a;
    }

    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int maxL=0;
        String st ="";int ind=-1;
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++)
        {
            dp[i][i]=true;
        }
        for(int L=2;L<=n;L++)
        {
            for(int i=0;i<n-L+1;i++)
            {
                if(L==2)
                {
                    if(ch[i]==ch[i+L-1])
                    {
                        dp[i][i+L-1]=true;
                         if(maxL<L)
                        {
                            maxL=L;
                            ind=i;
                        }
                    }
                }

                else if(ch[i]==ch[i+L-1] && dp[i+1][i+L-1-1])
                {
                    dp[i][i+L-1]=true;
                    if(maxL<L)
                    {
                        maxL=L;
                        ind=i;
                    }
                }
                
            }
        }
        if(maxL==0)
        {
            return s.substring(0,1);
        }
        return s.substring(ind, ind + maxL);
    }
}