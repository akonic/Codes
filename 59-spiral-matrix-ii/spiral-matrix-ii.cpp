class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> v(n,vector<int>(n,0));
        int step=0,c=1,i=0,j=0;
        while(c<=n*n)
        { 
            if(step==0)
            {
                while(j<n && v[i][j]==0)
                { 
                    v[i][j]=c;
                    c++;
                    j++;
                   
                }
                j--;
                i++;
                step=1;
            }
            else if(step==1)
            {
                while(i<n && v[i][j]==0)
                {
                    v[i][j]=c;
                    c++;
                    i++;
                    
                }
                i--;
                j--;
                step=2;
            }
            else if(step==2)
            {
                while(j>=0 && v[i][j]==0)
                {
                    v[i][j]=c;
                    c++;
                    j--;
                }
                j++;
                i--;
                step=3;
            }
            else if(step==3)
            {
                while(i>=0 && v[i][j]==0)
                {
                    v[i][j]=c;
                    c++;
                    i--;
                }
               i++;
               j++;
                step=0;
            }
        }
        return v;

    }
};
