class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int[] pre = new int[n];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            pre[i]=sum;
        }
        sum=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum+=i*nums[i];
        }
        ans=Math.max(ans,sum);
        for(int i=n-1;i>=0;i--)
        {
            int pref=0,suf=0;
            if(i>0)
            {
                pref=pre[i-1];
            }
            if(i<n-1)
            {
                suf=pre[n-1]-pre[i];
            }
            sum+=pref+suf-(n-1)*nums[i];
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}