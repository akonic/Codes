class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0;
        int n = nums.length;
        for(int i : nums)
        {
            sum+=i;
        }
        long x=0;
        int ans=0;
        for(int i=0;i<n-1;i++)
        {
            x+=nums[i];
            sum-=nums[i];
            if(x>=sum)
            {
                ans++;
            }
        }
        return ans;
    }
}