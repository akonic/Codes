class Solution {
public:
    int index(int i,int j,vector<int>& nums,int target)
    {
        int n=nums.size();
        while (i <j) {
            int mid = i + (j - i) / 2;
            if (target<=nums[mid]) {
                 i = mid + 1;
                
            } else {
               j = mid;
            }
        }
        return j;
    }
    int countNegatives(vector<vector<int>>& grid) {
        int n=grid.size(),m=grid[0].size();
        vector<int> v;
        for(int i=0;i<n;i++)
        {
            v.push_back(index(0,m,grid[i],0));
        }
        int c=0;
        for(auto i : v)
        {
            c+=m-i;
        }
        return c;
    }
};