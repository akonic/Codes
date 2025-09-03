class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n=grid.size(),m=grid[0].size();
        vector<vector<int>> cost(n,vector<int>(m,INT_MAX));
        queue<pair<pair<int,int>,int>> q;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    cost[i][j]=0;
                    q.push({{i,j},0});
                }
            }
        }
        while(!q.empty())
        {
            int x=q.front().first.first;
            int y=q.front().first.second;
            int cst=q.front().second;

            q.pop();
            if(x+1<n && grid[x+1][y]==1 && cost[x+1][y]>1+cst)
            {
                cost[x+1][y]=1+cst;
                q.push({{x+1,y},1+cst});
            }
            if(y+1<m && grid[x][y+1]==1 && cost[x][y+1]>1+cst)
            {
                cost[x][y+1]=1+cst;
                q.push({{x,y+1},1+cst});
            }
                if(x-1>=0 && grid[x-1][y]==1 && cost[x-1][y]>1+cst)
            {
                cost[x-1][y]=1+cst;
                q.push({{x-1,y},1+cst});
            } 
            if(y-1>=0 && grid[x][y-1]==1 && cost[x][y-1]>1+cst)
            {
                cost[x][y-1]=1+cst;
                q.push({{x,y-1},1+cst});
            }
        }

        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && cost[i][j]==INT_MAX)
                {
                    return -1;
                }
                else if(grid[i][j]==1 && cost[i][j]!=INT_MAX)
                {
                    ans=max(ans,cost[i][j]);
                }

            }
        }
        return ans;

    }
};