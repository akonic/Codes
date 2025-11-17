class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
        int p=-1;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]==1 && p==-1)
            {
                p=i;
            }
            else if(nums[i]==1)
            {
                if(i-p-1<k)
                {
                    return false;
                }
                else{
                    p=i;
                }
            }
        }
        return true;
    }
};