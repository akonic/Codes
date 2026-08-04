class Solution {
    private int sum(int n)
    {
        int ans=0;
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                ans+=i;
                n /= i;
            }
        }
        if(n>2)
        {
            ans+=n;
        }
        return ans;
    }
    public int minSteps(int n) {
        if(n==1)
        {
            return 0;
        }
        int ans=0;
        while(n%2==0)
        {
            n/=2;
            ans+=2;
        }
        ans+=sum(n);
        return ans;
    }
}