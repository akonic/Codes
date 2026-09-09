class Solution {
    public long countCommas(long n) {
        int x = 0;
        long temp = n;

        while (temp > 0) {
            x++;
            temp /= 10;
        }

        if (x < 4) {
            return 0;
        }

        long[] pow10 = new long[19];
        pow10[0] = 1;
        for (int i = 1; i < 19; i++) {
            pow10[i] = pow10[i - 1] * 10;
        }
        long ans = 0;
        int c = 3;
        while (c < x) {
            c++;
            long commas = (c - 1) / 3;

            if (c == x) {
                ans += (n - pow10[c - 1] + 1) * commas;
            } else {
                ans += (pow10[c] - pow10[c - 1]) * commas;
            }
        }

        return ans;
    }
}

/*


1
10
100
1,000
10,000
100,000
1,000,000
10,000,000
100,000,000
1,000,000,000
10,000,000,000
100,000,000,000
1,000,000,000,000
10,000,000,000,000
100,000,000,000,000
1,000,000,000,000,000


*/