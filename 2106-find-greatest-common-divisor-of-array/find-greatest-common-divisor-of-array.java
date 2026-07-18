class Solution {
    private int gcd(int a,int b)
    {
        if(a%b==0)
        {
            return b;
        }
        return gcd(b,a%b);
    }
    public int findGCD(int[] nums) {
        int minValue=Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i : nums)
        {
            minValue=Math.min(minValue,i);
            maxValue=Math.max(maxValue,i);
        }
        return gcd(minValue,maxValue);
    }
}