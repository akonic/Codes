class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> v(n,vector<int>(m,0));
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if(matrix[i][j]=='1')
               {
                v[i][j]=1;
               }
             
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(v[i][j]!=0){
                v[i][j] += v[i - 1][j];}
            }
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
           v[i].push_back(0);
             stack<int> s;
            for(int j = 0; j < v[i].size(); j++) {
                while(!s.empty() && v[i][s.top()] > v[i][j]) {
                    int height = v[i][s.top()];
                    s.pop();
                    int width = s.empty() ? j : j - s.top() - 1;
                    ans = max(ans, height * width);
                }
                s.push(j);
            }
        }
        return ans;
    }
};