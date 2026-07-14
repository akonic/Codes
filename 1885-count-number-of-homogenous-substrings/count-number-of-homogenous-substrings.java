class Solution {
    public int countHomogenous(String s) {
        final int mod = 1_000_000_007;
        final long inv2 = (mod + 1) / 2;
        long ans = 0;
        int n= s.length();
        int c=1;
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                c++;
            }
            else{
                ans = (ans + (long) c * (c + 1) % mod * inv2) % mod;
                c=1;
            }
        }
        ans = (ans + (long) c * (c + 1) % mod * inv2) % mod;
        return (int)ans;
    }
}