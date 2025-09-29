class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        heights.push_back(0);
        int ans=0;
        stack<int> s;
        for(int i=0;i<heights.size();i++)
        {
            while(!s.empty() && heights[s.top()]>heights[i])
            {
                int height=heights[s.top()];s.pop();
                int width;
                if(!s.empty())
                {
                    width=i-s.top()-1;
                }
                else{
                    width=i;
                }
                ans=max(ans,height*width);
            }
            s.push(i);
        }

        return ans;
    }
};