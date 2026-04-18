class Solution {
    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        int mod = 1_000_000_007;
        int n = deliciousness.length;

        for(int k = 0; k < n; k++)
        {
            for(int p = 0; p < 22; p++)
            {
                int target = (1 << p) - deliciousness[k];  
                ans = (ans + mp.getOrDefault(target, 0)) % mod;
            }
            mp.put(deliciousness[k], mp.getOrDefault(deliciousness[k], 0) + 1); 
        }
        return ans;
    }
}