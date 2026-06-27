class Solution {
    public int maximumLength(int[] nums) {
        int ans = 1;
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int p = mp.getOrDefault(1, 0);
        if (p % 2 == 0) {
            p--;
        }
        ans = Math.max(ans, p);
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            int x = 0, last = 0;
            if (value >= 2 && key!=1) {
                long temp = key;
                while (temp <= Integer.MAX_VALUE && mp.containsKey((int) temp)) {
                    if (mp.get((int) temp) >= 2) {
                        x++;
                    } else if (mp.get((int) temp) == 1) {
                        last = 1;
                        break;
                    }
                    temp *= temp;
                }
            }
            if (last == 1) {
                ans = Math.max(ans, 2 * x + 1);
            } else {
                ans = Math.max(ans, 2 * x - 1);
            }
        }
        return ans;
    }
}