class Solution {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int n = pairs.length;
        int ans = 1;
        int prevf = pairs[0][0];
        int prevl = pairs[0][1];
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] > prevl) {
                ans++;
                prevf = pairs[i][0];
                prevl = pairs[i][1];
            }
        }
        return ans;
    }
}