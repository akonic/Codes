
class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();
        if (n == 0) return 0;

        auto dist = [&](int i, int j) {
            return abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
        };

        vector<int> cost(n, INT_MAX);             
        vector<char> inMST(n, 0);                
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

        cost[0] = 0;
        pq.push({0, 0});
        long long ans = 0;

        while (!pq.empty()) {
            auto [w, u] = pq.top(); pq.pop();
            if (inMST[u]) continue;     
            inMST[u] = 1;
            ans += w;                 

            for (int v = 0; v < n; ++v) {
                if (!inMST[v]) {
                    int d = dist(u, v);
                    if (d < cost[v]) {
                        cost[v] = d;
                        pq.push({d, v});   
                    }
                }
            }
        }

        return (int)ans;
    }
};
