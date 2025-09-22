class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        int x=INT_MIN;
        unordered_map<int,int> m;
        for(auto& i:nums)
        {
            m[i]++;
            x=max(x,m[i]);
        }
        int c=0;
        for(auto& i:m)
        {
            if(i.second==x)
            {
                c+=x;
            }
        }
        return c;
    }
};