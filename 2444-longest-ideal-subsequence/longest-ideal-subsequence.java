class Solution {

    public int longestIdealString(String s, int k) {
        int[] best = new int[26];
        int ans = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            int cur = 0;

            for (int j = 0; j < 26; j++) {
                if (Math.abs(idx - j) <= k) {
                    cur = Math.max(cur, 1 + best[j]);
                }
            }

            best[idx] = Math.max(best[idx], cur);
            ans = Math.max(ans, cur);
        }

        return ans ;
    }

}