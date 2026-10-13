class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int x= (n+1)/2;
        int y=n-x;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<0)
            {
                nums[i]*=-1;
            }
        }
        Arrays.sort(nums);
        long sum=0;
        for(int i=0;i<y;i++)
        {
            sum-=(long)nums[i]*nums[i];
        }
        for(int i=y;i<n;i++)
        {
            sum+=(long)nums[i]*nums[i];
        }
        return sum;
    }
}