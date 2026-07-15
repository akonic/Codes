class Solution {
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int gcdOfOddEvenSums(int n) {
        int sum1 = n * n;
        int sum2 = n * n + n;
        return gcd(sum1, sum2);
    }
}