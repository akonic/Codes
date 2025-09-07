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
    int minDistance(string s1, string s2) {

        int m = s1.size();
        int n = s2.size();

        vector<int> prev(n + 1, 0), curr(n + 1, 0);

        // For 0-th row
        for (int j = 0; j <= n; j++)
            prev[j] = j;

        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1])
                    curr[j] = prev[j - 1];
                else
                    curr[j] = 1 + min({curr[j - 1], prev[j], prev[j - 1]});
            }
            prev = curr;
        }
        return prev[n];
    }
};