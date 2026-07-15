class Solution {
    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a == b)
            return a;

        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }

    public int gcdOfOddEvenSums(int n) {
        int sum1=n*n;
        int sum2=n*n + n;
        return gcd(sum1,sum2);
    }
}