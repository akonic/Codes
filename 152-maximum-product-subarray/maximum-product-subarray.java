class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] suff = new int[n];
        int[] pre = new int[n];
        int prod=1;
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]==0)
            {
                suff[i]=0;
                prod=1;
            }
            else{
                prod*=nums[i];
                suff[i]=prod;
            }
        }
        prod=1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                pre[i]=0;
                prod=1;
            }
            else{
                prod*=nums[i];
                pre[i]=prod;
            }
        }
        int ans=nums[0];
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,Math.max(pre[i],suff[i]));
        }
        return ans;
    }
}