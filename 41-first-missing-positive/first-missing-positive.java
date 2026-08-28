class Solution {
    public int firstMissingPositive(int[] nums) {
        int x=Integer.MIN_VALUE;
        int n = nums.length;
       
        for(int i=0;i<n;i++)
        {
            if(nums[i]<1 || nums[i]>n)
            {
                nums[i]=n+1;
            }
        }
        x=Integer.MIN_VALUE;
        int ans=n+1;
        for(int i=0;i<n;i++)
        {
            int p = Math.abs(nums[i]);
            if(p<=n && p>=1 && nums[p-1]>0)
            {
                nums[p-1]*=-1;
            }
        }
        for(int i=0 ;i<n;i++)
        {
            if(nums[i]>0)
            {
                return i+1;
            }
        }
        return n+1;
    }
}