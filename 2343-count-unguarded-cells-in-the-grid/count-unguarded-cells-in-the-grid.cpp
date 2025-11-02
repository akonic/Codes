class Solution {
public:
    int countUnguarded(int n, int m, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        vector<vector<int>> v(n,vector<int>(m,0));
        for(int i=0;i<guards.size();i++)
        {
            v[guards[i][0]][guards[i][1]]=-1;
        }
        for(int i=0;i<walls.size();i++)
        {
            v[walls[i][0]][walls[i][1]]=-2;
        }
        for(int i=0;i<n;i++)
        {
            int x=1;
            for(int j=0;j<m;j++)
            {
                if(v[i][j]==-2)
                {
                    x=1;
                }
                else if(x==-1 && v[i][j]==0)
                {
                    v[i][j]=-4;
                }
                else if(v[i][j]==-1)
                {
                    x=-1;
                }

            }
        }
        for(int i=n-1;i>=0;i--)
        {
            int x=1;
            for(int j=m-1;j>=0;j--)
            {
                if(v[i][j]==-2)
                {
                    x=1;
                }
                else if(x==-1  && v[i][j]==0)
                {
                    v[i][j]=-4;
                }
                else if(v[i][j]==-1)
                {
                    x=-1;
                }

            }
        }
        for(int j=0;j<m;j++)
        {
            int x=1;
            for(int i=0;i<n;i++)
            {
                if(v[i][j]==-2)
                {
                    x=1;
                }
                else if(x==-1  && v[i][j]==0)
                {
                    v[i][j]=-4;
                }
                else if(v[i][j]==-1)
                {
                    x=-1;
                }

            }
        }
        for(int j=0;j<m;j++)
        {
            int x=1;
            for(int i=n-1;i>=0;i--)
            {
                if(v[i][j]==-2)
                {
                    x=1;
                }
                else if(x==-1  && v[i][j]==0)
                {
                    v[i][j]=-4;
                }
                else if(v[i][j]==-1)
                {
                    x=-1;
                }

            }
        }
        int c=0;
         for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
               
                if(v[i][j]==0)
                {
                    c++;
                }
            }
            
        }
        return c;
        
    }
};