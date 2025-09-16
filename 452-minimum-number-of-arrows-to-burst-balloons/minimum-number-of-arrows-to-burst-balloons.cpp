class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
                int n = points.size(),c=0;
           sort(points.begin(), points.end(),
         [](const vector<int>& a, const vector<int>& b) {
             return a[1] < b[1];
         });
        int y=points[0][1];
        for(int i=1;i<n;i++)
        {
            if(y>=points[i][0])
            {
               
            }
            else{
                c++;
               
                y=points[i][1];
        
            }

        }
        c++;
        return c;
    
    }
};