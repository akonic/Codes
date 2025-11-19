class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        map<int,int> m;
        for(auto& i : nums)
        {
            m[i]++;
        }
        while(1)
        {
            if(m[original]==0)
            {
                return original;
            }
            original*=2;
        }
        return original;
    }
};