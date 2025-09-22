class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        int x=INT_MIN;
        vector<int> m(101,0);
        for(auto& i:nums)
        {
            m[i]++;
            x=max(x,m[i]);
        }
        int c=0;
        for(auto& i:m)
        {
            if(i==x)
            {
                c+=x;
            }
        }
        return c;
    }
};