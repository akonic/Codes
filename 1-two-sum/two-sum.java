class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int ans = target - nums[i];
            if (map.containsKey(ans)) {
                int ind = map.get(ans);
                if (ind != i) {
                    return new int[] { i, ind };
                }
            }
        }

        return new int[] {};
    }
}