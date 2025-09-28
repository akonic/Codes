class Solution {
public:

    int fun(string s, int i,vector<int>& dp) {
        if (i == s.size()) {
            return 1;
        }
        if (i > s.size()) {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int c = 0;

        if (s[i] == '0') {

        } else {
            if (i + 1 < s.size() && stoi(s.substr(i, 2)) < 27) {
                c += fun(s, i + 2,dp);
            }
            c += fun(s, i + 1,dp);
        }

        return dp[i]=c;
    }
    int numDecodings(string s) { 
         int n=s.size();
        vector<int> dp(n+1, -1);
        return fun(s, 0,dp); }
};