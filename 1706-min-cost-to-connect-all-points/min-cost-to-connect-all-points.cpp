class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n=points.size();
        vector<vector<pair<int,int>>> adj(n);
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int cost=abs(points[i][0]-points[j][0]) + abs(points[i][1]-points[j][1]);
                adj[i].push_back({j,cost});
                adj[j].push_back({i,cost});
            }
        }
        vector<int> visited(n,0);
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> q;
        q.push({0,0});
        int sum=0;
        while(!q.empty())
        {
            int node = q.top().second;
            int cost=q.top().first;

            q.pop();
            if(visited[node]) continue;

            visited[node]=1;
            sum+=cost;
            for(auto& v : adj[node])
            {
                int newNode=v.first;
                int newCost=v.second;
                if(visited[newNode]) continue;
                q.push({newCost,newNode});
            }

        }

          return sum;
    }
  
};