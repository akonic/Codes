class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] pre = new int[n+2];
        int[] suff = new int[n+2];
        int p = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            p=Math.max(p,height[i]);
            pre[i+1]=p;
        }
        p = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--)
        {
            p=Math.max(p,height[i]);
            suff[i+1]=p;
        }
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            ans+=Math.min(pre[i],suff[i])-height[i-1];
        }
        return ans;
    }
}