class Solution {
public:
    void floydWarshall(vector<vector<int>> &v, int INF) {
        int V = v.size();

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (v[i][k] != INF && v[k][j] != INF)
                        v[i][j] = min(v[i][j], v[i][k] + v[k][j]);
                }
            }
        }
    }

    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        int INF = 100000000;
        vector<vector<int>> v(n, vector<int>(n, INF));
        for (int i = 0; i < n; i++) v[i][i] = 0;

        for (auto& i : edges) {
            int a = i[0], b = i[1], c = i[2];
            v[a][b] = c;
            v[b][a] = c;
        }

        floydWarshall(v, INF);

        int x = INT_MAX;
        int c = -1;

        for (int i = 0; i < n; i++) {
            int p = 0;
            for (int j = 0; j < n; j++) {
                if (v[i][j] <= distanceThreshold)
                    p++;
            }

            if (p <= x) {
                x = p;
                c = i;
            }
        }

        return c;
    }
};
