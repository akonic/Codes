class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        vector<vector<int>> v(n + 1);
        vector<int> color(n + 1, -1);
        for (auto& i : dislikes) {
            v[i[0]].push_back(i[1]);
v[i[1]].push_back(i[0]);
        }
        queue<int> q;

        for (int i = 1; i <= n; i++) {
            if(color[i]==-1){
                color[i]=0;
            q.push(i);
            while (!q.empty()) {
                int p = q.front();
                q.pop();
                for (auto& u : v[p]) {
                    if (color[u] == -1) {
                        color[u] = 1 - color[p];
                        q.push(u);
                    } else if (color[u] == color[p]) {
                        return false;
                    }
                }
            }
            }
        }
        return true;
    }
};