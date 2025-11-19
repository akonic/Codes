class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        set<int> s;
        for(auto& i : nums)
        {
            s.insert(i);
        }
        while(1)
        {
            if(s.find(original)==s.end())
            {
                return original;
            }
            original*=2;
        }
        return original;
    }
};