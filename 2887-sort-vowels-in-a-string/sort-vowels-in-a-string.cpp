class Solution {
public:
    string sortVowels(string s) {
        vector<int> v;
        string p;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' ||
                s[i] == 'U' || s[i] == 'a' || s[i] == 'e' || s[i] == 'i' ||
                s[i] == 'o' || s[i] == 'u') {
                p.push_back(s[i]);
                v.push_back(i);
            }
        }
        if (p.size() > 0) {
            sort(p.begin(), p.end());
            int u = 0;
            for (int i = 0; i < v.size(); i++) {
               
                int k = v[i];
                s[k] = p[u];u++;
            }
        }
        return s;
    }
};