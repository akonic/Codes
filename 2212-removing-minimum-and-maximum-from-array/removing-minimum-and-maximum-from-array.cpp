class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        int x,y;
        int n=nums.size();
        int mx=INT_MIN,mn=INT_MAX;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>mx)
            {
                mx=nums[i];
                x=i;
            }
            if(nums[i]<mn)
            {
                mn=nums[i];
                y=i;
            }
        }
        int a=max(x,y),b=min(x,y);
        return min({
            a+1,
            n-b,
            b+1 + n-a
        });
    }
};