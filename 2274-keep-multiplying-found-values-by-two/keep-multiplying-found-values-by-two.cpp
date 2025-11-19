class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        unordered_map<int,bool> m;
        for(auto& i : nums)
        {
            m[i]=true;
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