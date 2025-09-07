class Solution {
public:
    int dp[501][501];
    long fun(string word1, string word2,int i,int j)
    {
        if(i>=word1.size() && j>=word2.size())
        {
            return 0;
        }
        if(i>=word1.size() ||  j>=word2.size())
        {
            return max(word2.size() - j,word1.size() - i);
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        long ans=0;
        if(word1[i]==word2[j])
        {
            ans=fun(word1,word2,i+1,j+1);
        }
       else
        {
            ans=min({1+fun(word1,word2,i+1,j),1+fun(word1,word2,i+1,j+1),1+fun(word1,word2,i,j+1)});
        }
        return dp[i][j]=ans;
    }
    int minDistance(string word1, string word2) {
        memset(dp,-1,sizeof(dp));
        return fun(word1,word2,0,0);
    }
};