class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        for (int i : nums) {
           
            int q = i + k;
            if (mp.get(i) > 0) {
                if (mp.containsKey(q) && mp.get(q) > 0) {
                    if (q == i) {
                        if (mp.get(q) > 1) {
                            mp.put(i, 0);
                            ans++;
                        }
                    } else {
                        mp.put(i, 0);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}