class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0;
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        int temp=0;
        while(i<n && j<n)
        {
            if(temp<target)
            {
                temp+=nums[j];
                j++;
            }
            else if(temp>=target)
            {
                ans=Math.min(ans,j-i);
                temp-=nums[i];
                i++;
            }

            if(j==n)
            {
                while(i<n && temp>=target)
                {
                    temp-=nums[i];
                    ans=Math.min(ans,j-i);
                    i++;
                }
            }
        }
        if(ans==Integer.MAX_VALUE)
        {
            return 0;
        }
        return ans;
    }
}