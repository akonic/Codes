class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n=triangle.size();
        int c=INT_MAX;
        int m=triangle[n-1].size();
        vector<vector<int>> cost(n+1,vector<int>(m+1,INT_MAX));
        queue<pair<int,int>>q;
        q.push({0,0});
        cost[0][0]=triangle[0][0];
        while(!q.empty())
        {
            int x=q.front().first;
            int y=q.front().second;
            q.pop();
            
            if (x + 1 < n) { 
                if (y+1 < triangle[x+1].size() && 
                    cost[x+1][y+1] > cost[x][y] + triangle[x+1][y+1]) {
                    q.push({x+1,y+1});
                    cost[x+1][y+1] = cost[x][y] + triangle[x+1][y+1];
                }
                if (cost[x+1][y] > cost[x][y] + triangle[x+1][y]) {
                    q.push({x+1,y});
                    cost[x+1][y] = cost[x][y] + triangle[x+1][y];
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            c=min(c,cost[n-1][i]);
        }
        return c;
    }
};