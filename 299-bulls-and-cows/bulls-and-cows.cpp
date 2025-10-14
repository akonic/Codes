class Solution {
public:
    string getHint(string secret, string guess) {
        int x = 0, y = 0;
        map<char, int> m, mv;
        map<int,int> ind;
        int n = secret.size();
        for (int i = 0; i < n; i++) {
            m[secret[i]]++;
        }
        for (int i = 0; i < n; i++) {
            mv[guess[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (secret[i] == guess[i]) {
                x++;
                mv[guess[i]]--;
                m[guess[i]]--;
                ind[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) {
                if (mv[guess[i]] > 0 && m[guess[i]] > 0) {
                    y++;
                    mv[guess[i]]--;
                    m[guess[i]]--;
                }
            }
        }
        return to_string(x) + 'A' + to_string(y) + 'B';
    }
};