class Solution {
    private long gcd(long a,long b)
    {
        if(a%b==0)
        {
            return b;
        }

        return gcd(b,a%b);
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] preMax= new int[n];
        long[] preGcd = new long[n];
        int x=nums[0];
        for(int i=0;i<n;i++)
        {
            x=Math.max(x,nums[i]);
            preMax[i]=x;
            preGcd[i]=gcd(x,nums[i]);
        }
        long ans=0;
        Arrays.sort(preGcd);
        for(int i=0;i<n/2;i++)
        {
            ans+=gcd(preGcd[i],preGcd[n-i-1]);
        }
        return ans;
    }
}