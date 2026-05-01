class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int[] pre = new int[n];
        int totalSum=0;
        for(int i=0;i<n;i++)
        {
            totalSum+=nums[i];
        }
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum+=i*nums[i];
        }
        ans=Math.max(ans,sum);
        for(int i=n-1;i>=0;i--)
        {
           
            sum+=totalSum-nums[i]-(n-1)*nums[i];
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}