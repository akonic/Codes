class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n=points.size();
        vector<vector<pair<int,int>>> adj(n);
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                adj[i].push_back({j,abs(points[i][0]-points[j][0])+abs(points[i][1]-points[j][1])});
                adj[j].push_back({i,abs(points[i][0]-points[j][0])+abs(points[i][1]-points[j][1])});
            }
        }
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> q;
        int sum=0;
        vector<int> cost(n,0);
        cost[0]=0;
        q.push({0,0});
        while(!q.empty())
        {
            int cst=q.top().first;
            int node=q.top().second;
            q.pop();
            if(cost[node]) continue;

            cost[node]=1;
            sum+=cst;

            for(auto& i : adj[node])
            {
                if(cost[i.first]==0)
                {
                    q.push({i.second,i.first});
                }
            }
        }
        return sum;
    }
  
};