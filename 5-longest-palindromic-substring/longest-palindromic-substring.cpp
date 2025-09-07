class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty()) return "";
        int x = 0;
        string s1 = s, s2 = s;
        reverse(s2.begin(), s2.end());
        int n = s1.size();
        int m = s2.size();
        int dp[1001][1001];
        int bestStart = 0;
        int bestLen = 0;
        memset(dp, 0, sizeof(dp));

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1[i-1] == s2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    int L = dp[i][j];
                    int startInS = i - L;    
                    int startMapped = n - j;  
                    if (L > bestLen && startInS == startMapped) {
                        bestLen = L;
                        bestStart = startInS;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        if (bestLen == 0) return s.substr(0,1); 
        return s.substr(bestStart, bestLen);
    }
};
