class Solution {
    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int i = 0, ans = 0;
        int mod = 1000000007;
        int n = deliciousness.length;
        for (int k = 0; k < n; k++) {
            mp.put(deliciousness[k], mp.getOrDefault(deliciousness[k], 0) + 1);
        }
        for (int k = 0; k < n; k++) {
            mp.put(deliciousness[k], mp.getOrDefault(deliciousness[k], 0) - 1);
            for (int l = 0; l < 22; l++) {
                int target = (1 << l) - deliciousness[k];
                int val = mp.getOrDefault(target, 0);
                if (target == deliciousness[k]) {
                    ans = (ans + val) % mod;  
                } else if (val >= 1) {
                    ans = (ans + val) % mod;
                }
            }
        }
        return ans;
    }
}