class Solution {
public:
    int dp[101];
    int fun(string s, int i) {
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
                c += fun(s, i + 2);
            }
            c += fun(s, i + 1);
        }

        return dp[i]=c;
    }
    int numDecodings(string s) { 
        memset(dp,-1,sizeof(dp));
        return fun(s, 0); }
};