class Solution {
public:
    // int dp[501][501];
    // long fun(string word1, string word2,int i,int j)
    // {
    //     if(i>=word1.size() && j>=word2.size())
    //     {
    //         return 0;
    //     }
    //     if(i>=word1.size() ||  j>=word2.size())
    //     {
    //         return max(word2.size() - j,word1.size() - i);
    //     }
    //     if(dp[i][j]!=-1)
    //     {
    //         return dp[i][j];
    //     }
    //     long ans=0;
    //     if(word1[i]==word2[j])
    //     {
    //         ans=fun(word1,word2,i+1,j+1);
    //     }
    //    else
    //     {
    //         ans=min({1+fun(word1,word2,i+1,j),1+fun(word1,word2,i+1,j+1),1+fun(word1,word2,i,j+1)});
    //     }
    //     return dp[i][j]=ans;
    // }
    int minDistance(string word1, string word2) {
        //memset(dp,-1,sizeof(dp));
        int n=word1.size(),m=word2.size();
        int dp[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0)
                {
                    dp[i][j]=j;
                }
                else if(j==0)
                {
                    dp[i][j]=i;
                }
                else if(word1[i-1]==word2[j-1])
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=1+min({dp[i-1][j],dp[i-1][j-1],dp[i][j-1]});
                }
            }
        }
        return dp[n][m];
    }
};