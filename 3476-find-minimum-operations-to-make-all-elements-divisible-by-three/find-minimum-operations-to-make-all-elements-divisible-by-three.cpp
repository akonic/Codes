class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int c=0;
        for(auto& i : nums)
        {
            c+=min(3-(i%3) , i%3);
        }
        return c;
    }
};