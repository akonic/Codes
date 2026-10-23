class Solution {
    private int helper(int[] arr, int i, int j, int[][] dp, Map<Integer, Integer> idx) {
        if (dp[i][j] != -1) return dp[i][j];

        int res = 0;
        long sum = (long) arr[i] + arr[j];
        if (sum <= arr[arr.length - 1]) {        
            Integer k = idx.get((int) sum);
            if (k != null) res = 1 + helper(arr, j, k, dp, idx);
        }
        return dp[i][j] = res;
    }

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, ans = 0;
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.put(arr[i], i);

        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int p = helper(arr, i, j, dp, idx);
                if (p != 0) p += 2;
                ans = Math.max(ans, p);
            }
        }
        return ans;
    }
}