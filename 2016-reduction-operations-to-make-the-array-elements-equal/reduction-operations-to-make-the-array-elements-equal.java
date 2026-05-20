class Solution {
    public int reductionOperations(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int x = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            x = Math.min(x, nums[i]);
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        int c = mp.size();
        int[] arr = mp.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        for (int i = c - 1; i > 0; i--) {
            ans += i * mp.get(arr[i]);
        }
        return ans;
    }
}