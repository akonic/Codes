class Solution {
public:
    int compareVersion(string version1, string version2) {
        int n = version1.size(), m = version2.size();
        vector<int> v, u;
        string p;
        for (int i = 0; i < n; i++) {
            if (version1[i] == '.') {
                if (p.size() > 0) {
                    v.push_back(stoi(p));
                }
                p.clear();
            } else {
                p += version1[i];
            }
        }
        if (p.size() > 0) {
            v.push_back(stoi(p));
        }
        p.clear();
        for (int i = 0; i < m; i++) {
            if (version2[i] == '.') {
                if (p.size() > 0) {
                    u.push_back(stoi(p));
                }
                p.clear();
            } else {
                p += version2[i];
            }
        }
        if (p.size() > 0) {
            u.push_back(stoi(p));
        }
        p.clear();

        int a = v.size(), b = u.size(), i = 0, j = 0;
        while (i < a && i < b) {
            if (v[i] == u[i]) {
                i++;
            } else if (v[i] < u[i]) {
                return -1;
            } else {
                return 1;
            }
            cout << endl;
        }
        if (a < b) {
            for (int j = i; j < b; j++) {
                if (u[j] > 0) {
                    return -1;
                }
            }

        } else if (a > b) {
            for (int j = i; j < a; j++) {
                if (v[j] > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }
};