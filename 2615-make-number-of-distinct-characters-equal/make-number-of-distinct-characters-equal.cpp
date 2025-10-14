class Solution {
public:
    bool check(vector<int>& v, vector<int>& u) {
        int x = 0, y = 0;
        for (auto& i : v) {
            if (i > 0) {
                x++;
            }
        }
        for (auto& i : u) {
            if (i > 0) {
                y++;
            }
        }
        if (x == y) {
            return true;
        }
        return false;
    }
    bool isItPossible(string word1, string word2) {
        int  n = word1.size(), m = word2.size();
        vector<int> v(26, 0), u(26, 0);

        for (int i = 0; i < n; i++) {
            v[word1[i] - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            u[word2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (u[j] > 0 && v[i]>0){
                   {
                        u[j]--;
                        v[i]--;
                        u[i]++;
                        v[j]++;
                        if (check(v, u)) {
                            return true;
                        }
                        u[j]++;
                        v[i]++;
                        u[i]--;
                        v[j]--;
                    }
                }
            }
        }
        return false;
    }
};
/*
1.total distinct character - word1+word2 - 5
2.char with freq 2 - word1+word2 - 5

*/