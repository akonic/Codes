class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        int x=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            x=Math.max(x,nums[i]);
            pre[i]=x;
        }
        x=Integer.MAX_VALUE;
        for(int j=n-1;j>=0;j--)
        {
            x=Math.min(x,nums[j]);
            suff[j]=x;
        }
        int i=0,j=n-1;
        while(i<n && pre[i]==suff[i])
        {
            i++;
        }
        if(i==n)
        {
            return 0;
        }
        while(j>=0 && pre[j]==suff[j])
        {
            j--;
        }
        return j-i+1;
    }
}