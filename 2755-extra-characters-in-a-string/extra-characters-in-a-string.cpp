class Solution {
public:
    int fun(const string &s, unordered_set<string>& st, int i, vector<int>& v, int maxLen) {
        if (i >= (int)s.size()) return 0;
        if (v[i] != -1) return v[i];

        int ans = INT_MAX;
        string temp;
        for (int k = i; k < (int)s.size() && k - i + 1 <= maxLen; ++k) {
            temp += s[k];
            int extra = (st.find(temp) == st.end()) ? (k - i + 1) : 0;
            int sub = fun(s, st, k + 1, v, maxLen);
            if (sub != INT_MAX) ans = min(ans, extra + sub);
        }
        return v[i] = ans;
    }

    int minExtraChar(string s, vector<string>& dictionary) {
        unordered_set<string> st(dictionary.begin(), dictionary.end());
        int maxLen = 0;
        for (auto &w : dictionary) maxLen = max(maxLen, (int)w.size());

        int n = s.size();
        vector<int> v(n + 1, -1);
        return fun(s, st, 0, v, maxLen);
    }
};
