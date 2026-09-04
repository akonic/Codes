class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int ind = Integer.MAX_VALUE;
        int x=nums[0];
        for(int i=0;i<n;i++)
        {
            x=Math.max(x,nums[i]);
            pre[i]=x;
        }
        x=nums[n-1];
        for(int i=n-1;i>=0;i--)
        {
            x=Math.min(x,nums[i]);
            suf[i]=x;
        }

        for(int i=0;i<n;i++)
        {
            if(pre[i]-suf[i]<=k)
            {
                return i;
            }
        }
        return -1;
    }
}